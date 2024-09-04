import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_10026_RedGreen {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[][] map = new int[N][N];
		// R : 1 G: 2 B :3
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				if (str.charAt(j) == 'R')
					map[i][j] = 1;
				else if (str.charAt(j) == 'G')
					map[i][j] = 2;
				else if (str.charAt(j) == 'B')
					map[i][j] = 3;
			}
		}

		// 일반인 BFS
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[][] visitedNormal = new boolean[N][N];

		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		int normalcnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visitedNormal[i][j]) {
					normalcnt++;
					// 0 : row 1 :col
					int[] tmp = new int[2];
					tmp[0] = i;
					tmp[1] = j;

					visitedNormal[i][j] = true;

					queue.offer(tmp);

					while (!queue.isEmpty()) {
						int[] nowP = new int[2];

						nowP = queue.poll();

						int r = nowP[0];
						int c = nowP[1];
						int color = map[r][c];

						for (int k = 0; k < 4; k++) {
							int nr = r + dr[k];
							int nc = c + dc[k];
							// 인덱스체크 && visited 체크 && 내 색상인지 체크
							if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visitedNormal[nr][nc]
									&& map[nr][nc] == color) {

								visitedNormal[nr][nc] = true;
								int[] next = new int[2];

								next[0] = nr;
								next[1] = nc;

								queue.offer(next);

							}
						}

					}
				}
			}
		}

		// 적록인 BFS
		Queue<int[]> queue2 = new ArrayDeque<>();
		boolean[][] visitedRedGreen = new boolean[N][N];
		int redGreenCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visitedRedGreen[i][j]) {
					redGreenCnt++;
					// 0 : row 1 :col
					int[] tmp = new int[2];
					tmp[0] = i;
					tmp[1] = j;

					visitedRedGreen[i][j] = true;

					queue2.offer(tmp);

					while (!queue2.isEmpty()) {
						int[] nowP = new int[2];

						nowP = queue2.poll();

						int r = nowP[0];
						int c = nowP[1];
						int color = map[r][c];

						for (int k = 0; k < 4; k++) {
							int nr = r + dr[k];
							int nc = c + dc[k];
							// 인덱스체크 && visited 체크 && 내 색상인지 체크
							if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visitedRedGreen[nr][nc]) {

								if (color == 1 || color == 2) {
									if (map[nr][nc] == 1 || map[nr][nc] == 2) {
										visitedRedGreen[nr][nc] = true;
										int[] next = new int[2];

										next[0] = nr;
										next[1] = nc;

										queue2.offer(next);
									}
								} else if (color == 3) {
									if (map[nr][nc] == 3) {
										visitedRedGreen[nr][nc] = true;
										int[] next = new int[2];

										next[0] = nr;
										next[1] = nc;

										queue2.offer(next);
									}
								}

							}
						}

					}
				}
			}
		}
		System.out.println(normalcnt + " " + redGreenCnt);

		sc.close();

	}

}
