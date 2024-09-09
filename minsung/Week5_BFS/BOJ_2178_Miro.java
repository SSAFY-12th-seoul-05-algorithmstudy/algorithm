import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2178_Miro {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] map = new int[N][M];
		boolean[][] visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		// 6시 9시 12시 3시
		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, -1, 0, 1 };
		// queue 에 현재 방문 지점의 row, col , 이동 횟수를 넣음
		Queue<int[]> queue = new LinkedList<>();

		int[] info = new int[3];
		info[0] = 0;
		info[1] = 0;
		visited[0][0] = true;
		info[2] = 1;

		queue.add(info);

		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();

			int r = tmp[0];
			int c = tmp[1];
			int cnt = tmp[2];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && map[nr][nc] == 1) {
					int[] newInfo = new int[3];
					newInfo[0] = nr;
					newInfo[1] = nc;
					newInfo[2] = cnt + 1;
					visited[nr][nc] = true;

					if (nr == N - 1 && nc == M - 1) {
						System.out.println(cnt + 1);
						return;
					}

					queue.offer(newInfo);
				}

			}

		}

	}

}
