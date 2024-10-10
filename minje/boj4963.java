package 백준;

import java.util.Scanner;

public class 섬의개수 {
	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };
	static int h, w;
	static int[][] arr;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();
			if (w == 0 && h == 0) {
				break;
			}
			arr = new int[h][w];

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			cnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (arr[i][j] == 1) {
						arr[i][j] = 0;
						dfs(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}

	static void dfs(int r, int c) {
		for (int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (isValid(nr, nc) && arr[nr][nc] == 1) {
				arr[nr][nc] = 0;
				dfs(nr, nc);
			}
		}
	}

	static boolean isValid(int nr, int nc) {
		if (nr >= 0 && nr < h && nc >= 0 && nc < w) {
			return true;
		}
		return false;
	}
}
