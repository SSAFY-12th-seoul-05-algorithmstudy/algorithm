import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2178 {

	static boolean[][] arr;
	static boolean[][] visited;
	static Queue<int[]> que;
	static int n;
	static int m;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 1. 입력 및 초기화
		n = Integer.parseInt(st.nextToken()); // 행 길이
		m = Integer.parseInt(st.nextToken()); // 열 길이

		arr = new boolean[n][m];
		visited = new boolean[n][m];

		String str;

		for (int i = 0; i < n; i++) {
			str = br.readLine();
			for (int j = 0; j < m; j++) {
				if (str.charAt(j) == '1') {
					arr[i][j] = true;
				}
			}
		}

		// 2. 계산
		bfs(0, 0);

		// 3. 출력
		bw.write(String.valueOf(count));

		br.close();
		bw.close();
	}

	static void bfs(int r, int c) {
		que = new ArrayDeque<>();
		count = n * m;
		int[] point;
		int tmp;

		que.offer(new int[] { r, c, 0 });

		while (!que.isEmpty()) {
			point = que.poll();
			r = point[0];
			c = point[1];
			tmp = point[2];

			if (visited[r][c]) {
				continue;
			}

			if (r == n - 1 && c == m - 1) {
				if ((tmp + 1) < count) {
					count = tmp + 1;
					return;
				}
			}

			visited[r][c] = true;

			if (r - 1 >= 0 && !visited[r - 1][c] && arr[r - 1][c]) {
				que.offer(new int[] { r - 1, c, tmp + 1 });
			}
			if (r + 1 < n && !visited[r + 1][c] && arr[r + 1][c]) {
				que.offer(new int[] { r + 1, c, tmp + 1 });
			}
			if (c - 1 >= 0 && !visited[r][c - 1] && arr[r][c - 1]) {
				que.offer(new int[] { r, c - 1, tmp + 1 });
			}
			if (c + 1 < m && !visited[r][c + 1] && arr[r][c + 1]) {
				que.offer(new int[] { r, c + 1, tmp + 1 });
			}
		}
	}
}
