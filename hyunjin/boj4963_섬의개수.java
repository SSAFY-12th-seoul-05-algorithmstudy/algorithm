package DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ4963_섬의개수 {

	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };
	static int w, h, ans;
	static int[][] arr;
	static boolean[][] visited;
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		while (sc.hasNext()) {
			w = sc.nextInt();
			h = sc.nextInt();

			if (w == 0 && h == 0)
				break;

			// w <-> h 값 그대로 작성 X
			arr = new int[h][w];
			visited = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					arr[i][j] = sc.nextInt();
					if (arr[i][j] == 0)
						visited[i][j] = true;
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (arr[i][j] == 1 && !visited[i][j]) {
						ans = 0;
						dfs(i, j);
						list.add(ans);

					}
				}
			}
//			System.out.println(ans);
			System.out.println(list.size());
			list.clear();

		}
	}

	static void dfs(int i, int j) {
		visited[i][j] = true;

		for (int dir = 0; dir < 8; dir++) {
			int nr = i + dr[dir];
			int nc = j + dc[dir];

			if (nr < 0 || nr >= h || nc < 0 || nc >= w || visited[nr][nc])
				continue;

			dfs(nr, nc);
		}
		ans++;
	} // dfs

}
