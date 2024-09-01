import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static boolean[][] visited;
	static int count=0;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static StringBuilder sb = new StringBuilder();
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[M][N];
		visited = new boolean[M][N];
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int r= (M-Math.max(y1, y2));r<(M-Math.min(y1, y2));r++) {
				for(int c= Math.min(x1, x2);c<Math.max(x1, x2);c++) {
					arr[r][c]=1;
					visited[r][c]=true;
				}
			}
			
		}
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					bfs(i,j);
				}
			}
		}
		System.out.println(count);
		Collections.sort(list);
		for(int num:list) {
			System.out.print(num+" ");
		}
		
		
		
	}
	static class square {
		int r, c, area;
		public square(int r, int c, int area) {
			this.r=r;
			this.c=c;
			this.area=area;
		}
	}
	public static void bfs(int r, int c) {
		Queue<square> queue = new ArrayDeque<>();
		queue.offer(new square(r,c,0));
		visited[r][c]=true;
		int num = 1;
		while(!queue.isEmpty()) {
			square current = queue.poll();
			for(int i=0;i<dr.length;i++) {
				int nextr=current.r +dr[i];
				int nextc=current.c +dc[i];
				if(nextr<0||nextr>=M||nextc<0||nextc>=N||visited[nextr][nextc]) {
					continue;
				}
				int nextarea = num++;
				queue.add(new square(nextr,nextc,nextarea));
				visited[nextr][nextc]=true;
			}
		}
		list.add(num);
		count++;
	}
}