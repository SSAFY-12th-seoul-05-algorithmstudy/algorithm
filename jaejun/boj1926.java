package boj;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int[][] arr;
	static int n, m, num, max;
	static boolean[][] check;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[n][m];
		check = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		bfs();
		System.out.println(num);
		System.out.println(max);
	}

	static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0 || check[i][j])
					continue;
				num++;
				check[i][j] = true;
				q.offer(new int[] { i, j });
				int area = 0;

				while (!q.isEmpty()) {
					area++;
					int[] now = q.poll();
					int nx = now[0];
					int ny = now[1];

					for (int k = 0; k < 4; k++) {
						int ox = nx + dr[k];
						int oy = ny + dc[k];

						if (ox >= 0 && oy >= 0 && ox < n && oy < m) {
							if (!check[ox][oy] && arr[ox][oy] == 1) {
								q.add(new int[] { ox, oy });
								check[ox][oy] = true;
							}
						}
					}
				}
				max = Math.max(max, area);
			}

		}
		
	}
}
