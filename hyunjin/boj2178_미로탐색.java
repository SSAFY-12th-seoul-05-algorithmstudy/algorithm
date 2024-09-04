package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// BOJ2178_미로탐색
public class boj2178_미로탐색 {
	static int N, M;
	static boolean[][] board;
	static int[] dr = new int[] { -1, 1, 0, 0 };
	static int[] dc = new int[] { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 도달하고자 하는 R
		M = sc.nextInt(); // 도달하고자 하는 C
		board = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				if (str.charAt(j) - '0' == 0) {
					board[i][j] = true;
				}
			}
		}

		bfs(0, 0);

	} // main

	private static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { r, c, 1 }); // r,c : 시작 위치, 0 : 연산 횟수
		board[r][c] = true;

		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();

			int currentR = tmp[0];
			int currentC = tmp[1];
			int cnt = tmp[2];

			if (currentR == N - 1 && currentC == M - 1) {
				System.out.println(cnt);
				return;
			}

			for (int dir = 0; dir < 4; dir++) {
				int nr = currentR + dr[dir];
				int nc = currentC + dc[dir];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue; // 범위 밖 탐색 X
				if (board[nr][nc])
					continue; // 이미 방문한 곳은 재방문X

				board[nr][nc] = true;

				queue.offer(new int[] { nr, nc, cnt + 1 });

			}
		}

	}
}
