import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1926 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n;
	static int m;
	static boolean[][] arr;
	static Queue<int[]> que;
	static int max;
	static int[] dr = { -1, 0, 1, 0 }; // 상우하좌
	static int[] dc = { 0, 1, 0, -1 };

	static void input() throws IOException {

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				if ("1".equals(st.nextToken())) {
					arr[i][j] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		// 1. 입력 및 초기화
		input();

		// 2. 로직
		int count = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j]) {
					count++;
					bfs(i, j);
				}
			}
		}

		// 3. 출력
		sb.append(count).append("\n").append(max);
		bw.write(sb.toString());
		
		br.close();
		bw.close();
	}

	static void bfs(int r, int c) {
		que = new ArrayDeque<>();
		que.offer(new int[] { r, c });
		arr[r][c] = false;

		int[] tmp;
		int nr;
		int nc;
		int cnt = 0;

		while (!que.isEmpty()) {
			tmp = que.poll();
			r = tmp[0];
			c = tmp[1];
			cnt++;
			
			for (int i = 0; i < 4; i++) {
				nr = r + dr[i];
				nc = c + dc[i];
				if (isValid(nr, nc) && arr[nr][nc]) {
					que.offer(new int[] { nr, nc });
					arr[nr][nc] = false;
				}
			}
		}

		if (cnt > max) {
			max = cnt;
		}
	}

	static boolean isValid(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < m;
	}
}
