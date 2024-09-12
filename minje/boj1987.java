package 백준;

import java.util.Scanner;

public class 알파벳 {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int R, C;
	static boolean[] visited;
	static char[][] arr;
	static int max = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		sc.nextLine();
		
		arr = new char[R][C];
		visited = new boolean[100];
		String s;
		for (int i = 0; i < R; i++) {
			s = sc.nextLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		visited[arr[0][0] - '0'] = true;
		dfs(0, 0, 1);
		System.out.println(max);
	}

	static void dfs(int r, int c, int length) {
		max = Math.max(max, length);
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (isValid(nr, nc) && !visited[arr[nr][nc] - '0']) {
				visited[arr[nr][nc] - '0'] = true;
				dfs(nr, nc, length + 1);
				visited[arr[nr][nc] - '0'] = false;

			}
		}
	}

	static boolean isValid(int nr, int nc) {
		if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
			return true;
		}
		return false;
	}
}
