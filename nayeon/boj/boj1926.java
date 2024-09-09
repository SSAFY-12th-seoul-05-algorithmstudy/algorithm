import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 1926_그림
public class Main {
	// 그림 저장할 배열
	static int[][] arr;
	// 방문 여부를 저장할 배열
	static boolean[][] check;
	// 방향 배열
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	// 그림의 크기
	static int N, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		check = new boolean[N][M];

		// 그림 입력 받기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int numPictures = 0; // 총 그림의 수
		int maxSize = 0; // 가장 큰 그림의 크기

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1 && !check[i][j]) {
					numPictures++;
					int size = bfs(i, j);
					if (size > maxSize) {
						maxSize = size;
					}
				}
			}
		}

		System.out.println(numPictures);
		System.out.println(maxSize);
	}

	public static int bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] { x, y });

		check[x][y] = true;
		int size = 1; // 현재 그림의 크기

		while (!que.isEmpty()) {
			int[] current = que.poll();
			int cx = current[0];
			int cy = current[1];

			// 4방향 탐색
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				// 범위 내에 있는지 확인
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					// 그림이고 방문하지 않은 곳이라면
					if (arr[nx][ny] == 1 && !check[nx][ny]) {
						check[nx][ny] = true;
						que.add(new int[] { nx, ny });
						size++;
					}
				}
			}
		}

		return size;
	}
}
