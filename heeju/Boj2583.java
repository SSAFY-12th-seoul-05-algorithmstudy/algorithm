import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2583 {

	static boolean[][] arr;
	static boolean[][] visited;
	static Queue<int[]> que;
	static int n;
	static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 1. 입력 및 초기화
		m = Integer.parseInt(st.nextToken()); // 열 길이
		n = Integer.parseInt(st.nextToken()); // 행 길이
		int k = Integer.parseInt(st.nextToken());

		arr = new boolean[n][m];
		visited = new boolean[n][m];
		int r;
		int c;
		int nr;
		int nc;

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			nr = Integer.parseInt(st.nextToken());
			nc = Integer.parseInt(st.nextToken());
			for (int x = r; x < nr; x++) {
				for (int y = c; y < nc; y++) {
					arr[x][y] = true; // 직사각형 존재함
				}
			}
		}

		// 2. 계산
		List<Integer> ans = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!arr[i][j] && !visited[i][j]) {
					ans.add(bfs(i, j, 0));
				}
			}
		}

		// 3. 출력
		Collections.sort(ans);

		sb.append(ans.size()).append("\n");

		for (int i = 0; i < ans.size(); i++) {
			sb.append(ans.get(i)).append(" ");
		}

		bw.write(sb.toString());

		br.close();
		bw.close();
	}

	static int bfs(int r, int c, int count) {
		que = new ArrayDeque<>();
		int[] point;

		que.offer(new int[] { r, c });

		while (!que.isEmpty()) {
			point = que.poll();
			r = point[0];
			c = point[1];
			
			if (visited[r][c] == true) {
				continue;
			}
			visited[r][c] = true;
			count++;
			
			if (r - 1 >= 0 && !visited[r - 1][c] && !arr[r - 1][c]) {
				que.offer(new int[] { r - 1, c });
			}
			if (r + 1 < n && !visited[r + 1][c] && !arr[r + 1][c]) {
				que.offer(new int[] { r + 1, c });
			}
			if (c - 1 >= 0 && !visited[r][c - 1] && !arr[r][c - 1]) {
				que.offer(new int[] { r, c - 1 });
			}
			if (c + 1 < m && !visited[r][c + 1] && !arr[r][c + 1]) {
				que.offer(new int[] { r, c + 1 });
			}
		}

		return count;
	}
}
