import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj10026 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n;
	static Character[][] arr;
	static boolean[][] visited;

	static Queue<int[]> que;
	static int[] dr = { -1, 0, 1, 0 }; // 상우하좌
	static int[] dc = { 0, 1, 0, -1 };
	static int[] tmp;
	static int nr;
	static int nc;

	static void input() throws IOException {
		n = Integer.parseInt(br.readLine().trim());

		String str;
		arr = new Character[n][n];

		for (int i = 0; i < n; i++) {
			str = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// 1. 입력 및 초기화
		input();

		// 2. 로직
		visited = new boolean[n][n];
		int count = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					nonBfs(i, j);
					count++;
				}
			}
		}

		sb.append(count).append(" ");

		visited = new boolean[n][n];
		count = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					bfs(i, j);
					count++;
				}
			}
		}

		sb.append(count);

		// 3. 출력
		bw.write(sb.toString());

		br.close();
		bw.close();
	}

	static void nonBfs(int r, int c) {
		que = new ArrayDeque<>();
		que.offer(new int[] { r, c });
		visited[r][c] = true;
		char ch = arr[r][c];

		while (!que.isEmpty()) {
			tmp = que.poll();
			r = tmp[0];
			c = tmp[1];
			for (int i = 0; i < 4; i++) {
				nr = r + dr[i];
				nc = c + dc[i];
				if (isValid(nr, nc) && !visited[nr][nc] && arr[nr][nc] == ch) {
					visited[nr][nc] = true;
					que.offer(new int[] { nr, nc });
				}
			}
		}
	}

	static void bfs(int r, int c) {
		que = new ArrayDeque<>();
		que.offer(new int[] { r, c });
		visited[r][c] = true;
		boolean isBlue = (arr[r][c] == 'B');

		while (!que.isEmpty()) {
			tmp = que.poll();
			r = tmp[0];
			c = tmp[1];
			for (int i = 0; i < 4; i++) {
				nr = r + dr[i];
				nc = c + dc[i];
				if (isValid(nr, nc) && !visited[nr][nc]) {
					if ((!isBlue && arr[nr][nc] == 'B') || isBlue && (arr[nr][nc] == 'R' || arr[nr][nc] == 'G')) {
						continue;
					}
					visited[nr][nc] = true;
					que.offer(new int[] { nr, nc });
				}
			}
		}
	}

	static boolean isValid(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < n;
	}
}
