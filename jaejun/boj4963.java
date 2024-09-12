package boj;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class boj4963 {
	static int[][] map;
	static boolean[][] checked;
	static int[] dr = { -1, 1, 0, 0, 1, 1, -1, -1 };
	static int[] dc = { 0, 0, -1, 1, 1, -1, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int w = sc.nextInt(); // 너비
			int h = sc.nextInt(); // 높이
			map = new int[h][w];
			checked = new boolean[h][w];

			if (w == 0 && h == 0)
				break;

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int count = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1) {
						if (checked[i][j]) {
							continue;
						} else {
							bfs(i, j, h, w);
							count++;
						}
//					} else {
////						checked[i][j] = true;
//						continue;
					}
				}
			}
			System.out.println(count);

		}
	}

	static void bfs(int r, int c, int h, int w) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { r, c });
		checked[r][c] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int nr = curr[0];
			int nc = curr[1];

			for (int d = 0; d < 8; d++) {
				int or = nr + dr[d];
				int oc = nc + dc[d];

				if (or >= h || oc >= w || or < 0 || oc < 0) {
					continue;
				}
				if (!checked[or][oc] && map[or][oc] == 1) {
					q.add(new int[] { or, oc });
					checked[or][oc] = true;
				}

			}
		}
	}
	 static void dfs(int r, int c, int h, int w) {
	        // 현재 위치를 체크된 것으로 설정
	        checked[r][c] = true;

	        // 8방향 탐색
	        for (int d = 0; d < 8; d++) {
	            int nr = r + dr[d];
	            int nc = c + dc[d];

	            // 새로운 위치가 맵의 경계를 넘어가지 않는지 확인
	            if (nr >= 0 && nc >= 0 && nr < h && nc < w) {
	                if (!checked[nr][nc] && map[nr][nc] == 1) {
	                    // 인접한 육지인 경우 재귀 호출
	                    dfs(nr, nc, h, w);
	                }
	            }
	        }
	    }
}
