package 백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 나이트의이동 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int l = sc.nextInt();
			Queue<int[]> q = new LinkedList<>();
			boolean visited[][] = new boolean[l][l]; // 체스판 방문체크 배열 선언
			int start_x = sc.nextInt();
			int start_y = sc.nextInt();
			int end_x = sc.nextInt();
			int end_y = sc.nextInt();

			visited[start_x][start_y] = true; // 시작점 방문체크
			int[] dx = { 1, 1, 2, 2, -1, -1, -2, -2 };
			int[] dy = { -2, 2, 1, -1, -2, 2, 1, -1 }; // 나이트의 이동 가능 경로 총 8가지

			q.add(new int[] { start_x, start_y, 0 }); // 3번째 인덱스는 이동 횟수 cnt
			while (!q.isEmpty()) {
				int cur[] = q.poll();
				int x = cur[0];
				int y = cur[1];
				int cnt = cur[2];

				if (x == end_x && y == end_y) { // 현재 위치가 도착지점이 되면 종료
					System.out.println(cnt);
					break;
				}
				
				for (int i = 0; i < 8; i++) { // 8개의 방향 탐색
					if (x + dx[i] >= 0 && x + dx[i] <= l - 1 && y + dy[i] >= 0 && y + dy[i] <= l - 1
							&& !visited[x + dx[i]][y + dy[i]]) { // 그 중에서 경계범위 밖이거나 방문한 곳이면 쳐내기
						visited[x + dx[i]][y + dy[i]] = true; // 그렇지 않은 곳은 방문
						q.add(new int[] { x + dx[i], y + dy[i], cnt + 1 }); // 큐에 더하기 cnt++아니고 cnt+1
					}
				}
			}

		}
		sc.close();

	}
}
