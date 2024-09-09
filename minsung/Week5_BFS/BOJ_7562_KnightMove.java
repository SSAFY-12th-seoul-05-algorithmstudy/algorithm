import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7562_KnightMove {

	static int N;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			// 0 : row 1: col 2: cnt
			int[] info = new int[3];
			Queue<int[]> queue = new ArrayDeque<>();

			N = sc.nextInt();
			boolean[][] visited = new boolean[N][N];
			info[0] = sc.nextInt();
			info[1] = sc.nextInt();

			int destR = sc.nextInt();
			int destC = sc.nextInt();
			queue.offer(info);

			int[] dr = { 2, 2, 1, 1, -2, -2, -1, -1 };
			int[] dc = { 1, -1, 2, -2, -1, 1, 2, -2 };

			while (!queue.isEmpty()) {
				int[] tmp = queue.poll();
				int nowR = tmp[0];
				int nowC = tmp[1];
				int cnt = tmp[2];

				if (destR == nowR && destC == nowC) {
					System.out.println(cnt);
					break;
				}

				for (int i = 0; i < 8; i++) {
					if (canMove(nowR + dr[i], nowC + dc[i]) && !visited[nowR + dr[i]][nowC + dc[i]]) {
						visited[nowR + dr[i]][nowC + dc[i]] = true;
						queue.offer(new int[] { nowR + dr[i], nowC + dc[i], cnt + 1 });
					}
				}

			}

		}
	}

	static boolean canMove(int r, int c) {

		return r < N && r >= 0 && c < N && c >= 0;
	}

}
