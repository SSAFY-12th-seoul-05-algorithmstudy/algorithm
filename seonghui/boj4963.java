import java.util.Arrays;
import java.util.Scanner;

public class boj4963 {
	static int row, col;
	static int[][] map;
	static boolean[][] visited;
	static int cnt;
	
	static int[] dr = {-1,1,0,0,-1,-1,1,1};
	static int[] dc = {0,0,-1,1,-1,1,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		while(true) {
			col = sc.nextInt();
			row = sc.nextInt();
			if(col == 0 && row == 0) break; // 0 두 개 입력받으면 종료
			
			map = new int[row][col];
			for(int r = 0; r < row; r++) {
				for(int c = 0; c < col; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			visited = new boolean[row][col];
			cnt = 0;
			
			// 섬 갯수 카운트
			for(int r = 0; r < row; r++) {
				for(int c = 0; c < col; c++) {
					if(map[r][c] == 1 && !visited[r][c]) {
						cnt++;
						dfs(r,c);
					}
					
				}
			}
			System.out.println(cnt);
		}
		
	}
	
	static void dfs(int r, int c) {
		visited[r][c] = true;
		
		for(int k = 0; k < 8; k++) {
			int nr = r+dr[k];
			int nc = c+dc[k];
			// map 영역 벗어나거나 방문한 칸, 바다인 칸은 pass
			if(nr < 0 || nr >= row || nc < 0 || nc >= col || visited[nr][nc] || map[nr][nc] == 0) continue; 
			dfs(nr, nc);
		}
		
	}
}
