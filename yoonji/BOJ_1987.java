import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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

public class BOJ_1987 {
	static int R, C;
	static List<Character> charList = new ArrayList<>();
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static char[][] board;
	static boolean[] check;
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt(); // 가로
		C = sc.nextInt(); // 높이
		ans = 0;
		board = new char[R][C];
		
		for(int r=0; r<R; r++) {
			String s = sc.next();
			char[] arr = s.toCharArray();
			for(int c=0; c<C; c++) {
				board[r][c] = arr[c];
				charList.add(arr[c]);
			}
		} // 입력완료
		
		Collections.sort(charList); // 정렬
		check = new boolean[charList.get(charList.size()-1) - 'A'+1];
		
		dfs(0,0,1);
		
		System.out.println(ans);
	} // main

	private static void dfs(int r, int c, int cnt) {
		char alpha = board[r][c];
		check[alpha-'A'] = true;
		
		ans = Math.max(ans, cnt);
		
		
		// 4방 탐색
		for(int dir=0; dir<4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
				
			// 범위 밖이면 넘어가
			if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
			// 이미 지났던 알파벳이면 넘어가
			char a = board[nr][nc];
			if(check[a-'A']) continue;
			
			// 갈 수 있다
			dfs(nr,nc, cnt+1);
			
		}
		// 방문체크 초기화
		check[alpha-'A'] = false;
	}
				
} // dfs		
