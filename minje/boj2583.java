package 백준;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 영역구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int K = sc.nextInt();
		List<Integer> L = new ArrayList<>(); // 결과값에서 각 영역의 넓이를 오름차순으로 출력해야 하는데, 미리 영역의 갯수를 알 수 없기 때문에 List로 선언
		boolean[][] visited = new boolean[N][M]; // N이 x방향!!!!!!, 방문 boolean 배열 선언.
		int[] dx = { -1, 0, 0, 1 };
		int[] dy = { 0, -1, 1, 0 }; // 사방 탐색을 위한 dx dy

		for (int rec = 0; rec < K; rec++) { // 직사각형 갯수만큼 반복
			int start_x = sc.nextInt();
			int start_y = sc.nextInt();
			int end_x = sc.nextInt();
			int end_y = sc.nextInt();
			for (int i = start_x; i < end_x; i++) {
				for (int j = start_y; j < end_y; j++) {
					visited[i][j] = true; // 직사각형이 칠해진 영역은 true로 바꿈
				}
			}
		}

		int cnt = 0; // 직사각형을 칠하고 구분되는 영역의 갯수

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) { // 전체 영역 순회
				if (!visited[i][j]) { // 만약 visted가 false인 i와 j이면 코드실행
					int S = 0; // 영역의 넓이
					Queue<int[]> q = new LinkedList<>(); // 큐를 여기서 선언
					q.add(new int[] { i, j }); // 방문하지 않은 흰색 영역의 어떤 곳에서부터든지 사방탐색을 시작해도 무관함, q에 i j추가
					visited[i][j] = true; // 방문체크

					while (!q.isEmpty()) {
						int[] cur = q.poll(); // 큐에서 cur 배열로 반환
						int x = cur[0];
						int y = cur[1];
						S++; // 넓이 +1

						for (int d = 0; d < 4; d++) {
							if (x + dx[d] >= 0 && x + dx[d] < N && y + dy[d] >= 0 && y + dy[d] < M
									&& !visited[x + dx[d]][y + dy[d]]) { // 사방탐색하여 아직 방문하지 않은 지점이 있는지 체크
								visited[x + dx[d]][y + dy[d]] = true;
								q.add(new int[] { x + dx[d], y + dy[d] }); // 있다면 방문체크하고 q에 해당 좌표 추가
							}
						}
					} // while문이 종료될 때 해당 영역의 S를 구했음

					L.add(S);
					cnt++; // S저장하고 영역의 갯수 +1;
				}
			}
		}
		Collections.sort(L);
		System.out.println(cnt);
		for (int i = 0; i < cnt; i++) {
			System.out.print(L.get(i) + " "); // 정렬해서 출력
		}
	}
}
