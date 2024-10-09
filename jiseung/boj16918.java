import java.io.*;
import java.util.*;

public class Main {
	static int R, C, N;
	static int[][] map;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); // 행의 개수
		C = Integer.parseInt(st.nextToken()); // 열의 개수
		N = Integer.parseInt(st.nextToken()); // 시간

		if (N == 0) {
			for (int i = 0; i < R; i++) {
				System.out.println(br.readLine());
			}
			return;
		} else if (N != 0 && N % 2 == 0) {
			String str = "O".repeat(C);
			for (int i = 0; i < R; i++) {
				sb.append(str).append("\n");
			}
			System.out.println(sb);
		} else {
			map = new int[R][C];
			for (int i = 0; i < R; i++) {
				String input = br.readLine();
				for (int j = 0; j < C; j++) {
					if (input.charAt(j) == 'O') {
						map[i][j] = 2;
					}
				}
			}
			start(1);
		}
	}

	static void start(int time) {
		if (time == N) {
			// 출력
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(map[i][j] > 0 ? 'O' : '.');
				}
				System.out.println();
			}
			return;
		}
		// 배열을 돌며 1씩증가
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j]++;
			}
		}
		bomb();
		start(time + 1);
	}

	static void bomb() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 4) {
					// 델타돌면서 3이아닌거 다 0만듬.
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != 4 && map[nr][nc] != 0) {
							map[nr][nc] = 0;
						}
					}
					map[i][j] = 0;
				}
			}
		}
	}
}