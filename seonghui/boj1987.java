import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj1987 {
	static int row, col;
	static char[][] board;
	static boolean[][] visited;
	static List<Character> checked; // 특정 알파벳 지나왔는지 체크용도
	static int maxCnt; // 말이 지나갈 수 있는 최대 칸
	
	// 상하좌우 이동 가능
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		row = sc.nextInt();
		col = sc.nextInt();
		
		board = new char[row][col];
		for(int r = 0; r < row; r++) {
			String s = sc.next();
			for(int c = 0; c < col; c++) {
				board[r][c] = s.charAt(c);
			}
		}
		
		visited = new boolean[row][col];
		checked = new ArrayList<>();
		maxCnt = 0;
		
		dfs(0,0,0); // 좌측 상단에서 시작 + 이동 횟수
		System.out.println(maxCnt);
	}
	
	static void dfs(int r, int c, int cnt) {
		cnt++; 
		visited[r][c] = true;
		checked.add(board[r][c]); // 도착한 위치의 알파벳 check
		
		maxCnt = Math.max(maxCnt, cnt); // 경로별 최대 이동 횟수 업데이트
		
		for(int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			
			if(nr < 0 || nr >= row || nc < 0 || nc >= col || visited[nr][nc]) continue;
			
			// 해당위치의 알파벳이 이미 checked 리스트에 있으면 pass
			if(checked.contains(board[nr][nc])) continue;
			dfs(nr, nc, cnt);
		}
		
		cnt--;
		visited[r][c] = false;
		checked.remove(checked.size() - 1); // 제일 마지막에 추가된 문자 제거
		
		
	}
}
