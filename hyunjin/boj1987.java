package DFS;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

// BOJ1987_알파벳
public class boj1987 {
	static int R, C, ans;
	static char[][] board;
	static boolean[][] visited;
	static boolean[] used = new boolean[26];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();
		board = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				board[i][j] = str.charAt(j);
			}
		}


		ans = -1;
		dfs(0, 0, 1);
		System.out.println(ans);

	}

	static void dfs(int r, int c, int dist) {
		if (dist > ans) {
			ans = dist;
		}

		visited[r][c] = true;
		used[board[r][c] - 65] = true; // 알파벳이 사용되었는지 체크

		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];

			if (nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc] || board[r][c] == board[nr][nc]
					|| used[board[nr][nc] - 65]) {
				continue;
			}

			// 해당 위치에 방문하고, 해당 알파벳을 사용했다면 true로 바꾸기
			visited[nr][nc] = true;
			used[board[nr][nc] - 65] = true;
			dfs(nr, nc, dist + 1);
		}
		
		// 초기화
		visited[r][c] = false;
		used[board[r][c] - 65] = false;

	}
}
