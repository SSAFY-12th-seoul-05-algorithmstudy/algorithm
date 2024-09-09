import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int l;
	static int[] dr = {2,2,1,1,-2,-2,-1,-1};
	static int[] dc = {1,-1,2,-2,1,-1,2,-2};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			l = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
					
			int[] start = {r,c};
			int[] end = {x,y};
			
			bfs(start,end);
		}
	}
	static class pos {
		int r, c, step;
		public pos(int r, int c, int step) {
			this.r=r;
			this.c=c;
			this.step=step;
		}
	}
	public static void bfs(int[] start, int[] end) {
		if (start[0]==end[0]&&start[1]==end[1]) {
			System.out.println(0);
			return;
		}
		Queue<pos> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[l][l];
		queue.offer(new pos(start[0],start[1],0));
		visited[start[0]][start[1]]=true;
		while(!queue.isEmpty()) {
			pos current = queue.poll();
			for(int i=0;i<dr.length;i++) {
				int nextr=current.r +dr[i];
				int nextc=current.c +dc[i];
				int nextstep=current.step +1;
				if(nextr<0||nextr>=l||nextc<0||nextc>=l||visited[nextr][nextc]) {
					continue;
				}
				if(nextr==end[0]&&nextc==end[1]) {
					System.out.println(nextstep);
					return;
				}
				queue.add(new pos(nextr,nextc,nextstep));
				visited[nextr][nextc]=true;
			}
		}
	}
}