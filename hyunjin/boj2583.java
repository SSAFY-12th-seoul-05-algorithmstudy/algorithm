package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class boj2583 {
	static int M, N, K;
	static int[][] board; // 색칠된 영역(1)과 아닌 영역(0)으로 나눈 배열
	static boolean[][] isChecked = new boolean[N][M]; // 탐색하는 영역(0) 중 탐색했는지 체크
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt(); // 행
		N = sc.nextInt(); // 열
		K = sc.nextInt(); // K개의 직사각형
		board = new int[N][M]; // (0,0) 이 왼쪽 아래 위치해 있으므로, N, M을 바꿔서 배열 돌리기

		for (int k = 0; k < K; k++) {
			int startR = sc.nextInt();
			int startC = sc.nextInt();
			int endR = sc.nextInt();
			int endC = sc.nextInt();

			for (int r = startR; r < endR; r++) {
				for (int c = startC; c < endC; c++) {
					if (board[r][c] == 0) {
						board[r][c] = 1;
					}
					continue;
				}
			}
		} // k번째 직사각형

		bfs();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	} // main

	private static void bfs() {
		List<Integer> areaSizeList = new ArrayList<>();
		int areaSize = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; i < M; j++) {
				// 색칠된 영역(1) 이거나 이미 방문한 곳(true) 이면 넘어가.
				if (board[i][j] == 1 || isChecked[i][j])
					continue;

				Queue<int[]> queue = new LinkedList<>();
				queue.offer(new int[] { i, j }); // i,j : 시작 위치, 영역 넓이
				isChecked[i][j] = true; // 처음 시작 지점 탐색 완 == TRUE 바꾸고 출발

				areaSizeList.add(areaSize); // 그림 크기 list에 추가

				// 그림 넓이는 시작 지점이 바뀔 때마다 갱신
				areaSize = 0;

				while (!queue.isEmpty()) {
					int[] tmp = queue.poll();

					int currentR = tmp[0]; // 현재 R 위치
					int currentC = tmp[1]; // 현재 C 위치

					areaSize++; // queue에서 하나씩 뺄때마다 넓이 ++

					// while 빠져나가는 조건?
					// queue가 비면 알아서 빠져나감?!

					// 탐색
					for (int dir = 0; dir < 4; dir++) {
						int nr = currentR + dr[dir];
						int nc = currentC + dc[dir];

						if (nr < 0 || nr >= N || nc < 0 || nc >= 0)
							continue;
						if (isChecked[nr][nc])
							continue;

						// 처음 방문한 영역 -> TRUE 변경
						isChecked[nr][nc] = true;

						// 해당 위치 queue 추가
						queue.offer(new int[] { nr, nc });
					}
				} // while
			} // i
		} // j

		System.out.println(areaSizeList.size());
	}
}
