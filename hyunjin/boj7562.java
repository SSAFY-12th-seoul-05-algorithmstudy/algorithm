package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// BOJ7562_나이트의 이동
public class boj7562 {
	static int I;
	static boolean[][] isChecked;
	static int startR, startC, endR, endC;
	static int[] dr = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dc = { -2, -1, 1, 2, 2, 1, -1, -2 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			I = sc.nextInt();
			startR = sc.nextInt();
			startC = sc.nextInt();
			endR = sc.nextInt();
			endC = sc.nextInt();

			bfs(startR, startC);
		} // tc
	} // main

	static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { r, c, 0 }); // r,c : 시작 위치, 0 : 연산횟수
		isChecked = new boolean[I][I];
		isChecked[r][c] = true;

		while (!queue.isEmpty()) {
			// queue에서 뺀 값을 담는 새 배열
			int[] tmp = queue.poll();
			
			int currentR = tmp[0]; // 현재 R 위치
			int currentC = tmp[1]; // 현재 C 위치
			int operationCnt = tmp[2]; // 현재 누적 연산 횟수

			// 나이트의 위치가 최종 위치에 도달할 경우, 연산 횟수 출력
			if (currentR == endR && currentC == endC) {
				System.out.println(operationCnt);
				return;
			}

			
			// 나이트가 이동할 수 있는 방향으로 탐색
			for (int dir = 0; dir < 8; dir++) {
				// 나이트가 이동하는 새로운 위치 인덱스
				int nr = currentR + dr[dir];
				int nc = currentC + dc[dir];
				
				// 해당 인덱스가 체스판 밖으로 벗어나는 경우 -> 다른 방향으로 이동
				if (nr < 0 || nr >= I || nc < 0 || nc >= I)
					continue;
				// 이미 방문한 위치에 가는 경우 -> 다른 방향으로 이동
				if (isChecked[nr][nc])
					continue;
				
				// 처음 방문한 칸에 갔을 때 -> TRUE로 변경
				isChecked[nr][nc] = true;
				
				// 새 위치 queue에 추가하기 + 연산 횟수 +1 추가
				queue.offer(new int[] { nr, nc, operationCnt + 1 });
			}

		}
	}
}
