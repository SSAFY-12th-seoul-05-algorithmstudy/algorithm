import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Pos{
	int r, c;

	public Pos(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}

public class BOJ_4963 {
	static int w, h, cnt;
	static boolean[][] visited;
	static int[][] map;
	static int[] dr = {-1,-1,-1,0,1,1,1,0};
	static int[] dc = {-1,0,1,1,1,0,-1,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		w = sc.nextInt(); // 가로
		h = sc.nextInt(); // 높이
		
		while(w!=0 && h!=0) {
			
		visited = new boolean[h][w];
		map = new int[h][w];
		cnt = 0;

		for(int r=0; r<h; r++) {
			for(int c=0; c<w; c++) {
				map[r][c] = sc.nextInt();
			}
		} // 입력완료
		
		dfs();
		
		System.out.println(cnt);
		
		w = sc.nextInt(); // 가로
		h = sc.nextInt(); // 높이
		}
	} // main

	private static void dfs() {
		
		Stack<Pos> stack = new Stack<>();
		
		
		for(int r=0; r<h; r++) {
			for(int c=0; c<w; c++) {
				
				// 섬이고 아직 방문하지 않았다면
				if(map[r][c] == 1 && !visited[r][c]) {
					// 스택에 넣어준다
					stack.push(new Pos(r,c));
					cnt++;
				}
				
				while(!stack.isEmpty()) {
					// 스택에서 꺼내서
					Pos pos = stack.pop();
					// 방문체크
					visited[pos.r][pos.c] = true;
					
					// 주변섬 확인
					for(int i=0; i<dr.length; i++) {
						int nr = pos.r + dr[i];
						int nc = pos.c + dc[i];
						// 범위 밖이거나, 섬이 아니거나, 이미 방문한 곳이면 pass
						if(nr<0 || nr>= h || nc<0 || nc>=w || map[nr][nc] == 0 || visited[nr][nc]) continue;
						
						stack.push(new Pos(nr,nc));
					}
					
				}//while
				
			}
		}
	
	}// dfs
	
} // class		
