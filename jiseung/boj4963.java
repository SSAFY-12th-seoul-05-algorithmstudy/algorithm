import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int[] dr= {0,1,1,1,0,-1,-1,-1};
	static int[] dc= {1,1,0,-1,-1,-1,0,1};
	static int W,H,count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while(true) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			if(W==0&H==0) {
				break;
			}
			
			map = new int[H][W];
			visited = new boolean[H][W];
			for(int i=0;i<H;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<W;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			count=0;
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					if(!visited[i][j]&&map[i][j]==1) {
						bfs(i,j);
					}
				}
			}
			System.out.println(count);
		}
	}
	public static void bfs(int r, int c) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {r,c});
		visited[r][c]=true;
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			for(int i=0;i<dr.length;i++) {
				int nextr=current[0] +dr[i];
				int nextc=current[1] +dc[i];
				if(nextr<0||nextr>=H||nextc<0||nextc>=W||visited[nextr][nextc]||map[nextr][nextc]==0) {
					continue;
				}
				queue.add(new int[] {nextr,nextc});
				visited[nextr][nextc]=true;
			}
		}
		count++;
	}

}