import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1926_Grim {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		boolean[][] map = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (sc.nextInt() == 1)
					map[i][j] = true;

			}
		}

		boolean[][] visited = new boolean[N][M];

		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, -1, 0, 1 };

		Queue<int[]> queue = new ArrayDeque<>();

		int numGrim = 0;
		int maxGrim = 0;

		// 모든 요소 순회
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 그림 && 방문 안한 지점에서 BFS
				if (map[i][j] && !visited[i][j]) {
					numGrim++;
					int surface = 1;
					int[] info = new int[2];
					info[0] = i;
					info[1] = j;
					visited[i][j] = true;

					queue.offer(info);

					while (!queue.isEmpty()) {

						int[] tmp = new int[2];
						tmp = queue.poll();
						int r = tmp[0];
						int c = tmp[1];

						for (int k = 0; k < 4; k++) {
							int nr = r + dr[k];
							int nc = c + dc[k];

							if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && map[nr][nc]) {
								int[] newInfo = new int[3];
								newInfo[0] = nr;
								newInfo[1] = nc;
								visited[nr][nc] = true;

								queue.offer(newInfo);
								surface++;
							}
						}
					}
					maxGrim = Math.max(maxGrim, surface);

				}
			}
		}

		System.out.println(numGrim);
		System.out.println(maxGrim);

	}

}
