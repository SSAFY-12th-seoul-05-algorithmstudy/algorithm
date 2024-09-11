package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 그림 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n][m];
		int[] dx = { -1, 0, 0, 1 };
		int[] dy = { 0, -1, 1, 0 };

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int cnt = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1) {
					int S = 0;
					Queue<int[]> q = new LinkedList<>();
					q.add(new int[] { i, j });

					while (!q.isEmpty()) {
						int[] current = q.poll();
						int x = current[0];
						int y = current[1];
						S++;
						arr[x][y] = 0;
						for (int d = 0; d < 4; d++) {
							if (x + dx[d] >= 0 && x + dx[d] < n && y + dy[d] >= 0 && y + dy[d] < m
									&& arr[x + dx[d]][y + dy[d]] == 1) {
								arr[x + dx[d]][y + dy[d]] = 0;
								q.add(new int[] { x + dx[d], y + dy[d] });
							}
						}
					}
					max = Math.max(max, S);
					cnt++;
				}

			}
		}

		System.out.println(cnt);
		System.out.println(max);

	}
}
