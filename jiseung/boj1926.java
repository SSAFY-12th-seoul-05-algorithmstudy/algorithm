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
		
		int[][] arr = new int[M][N];
		visited = new boolean[M][N];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i][j]=num;
				if(num==0) {
					visited[i][j]=true;
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
		if(list.isEmpty()) {
			System.out.println(0);
		}
		else {
			Collections.sort(list);
			System.out.println(list.get(list.size()-1));
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