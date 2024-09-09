package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로탐색 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		int[][] arr = new int[N][M];
		int[] dr = { -1, 0, 0, 1 };
		int[] dc = { 0, -1, 1, 0 };

		queue.add(new int[] { 0, 0, 1 });
		visited[0][0] = true;

		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < M; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int row = cur[0];
			int col = cur[1];
			int cnt = cur[2];

			if (row == N - 1 && col == M - 1) {
				System.out.println(cnt);
				break;
			}

			for (int i = 0; i < 4; i++) {
				if (row + dr[i] < N && row + dr[i] >= 0 && col + dc[i] < M && col + dc[i] >= 0
						&& arr[row + dr[i]][col + dc[i]] == 1 && visited[row + dr[i]][col + dc[i]] == false) {
					visited[row + dr[i]][col + dc[i]] = true;
					queue.add(new int[] { row + dr[i], col + dc[i], cnt + 1 });
				}
			}

		}
		sc.close();
	}
}
