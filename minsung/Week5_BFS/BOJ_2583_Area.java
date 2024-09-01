import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2583_Area {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt();
		int N = sc.nextInt();
		int K = sc.nextInt();

		boolean[][] map = new boolean[N][M];
		for (int i = 0; i < K; i++) {

			int r1 = sc.nextInt();
			int c1 = sc.nextInt();
			int r2 = sc.nextInt();
			int c2 = sc.nextInt();

			for (int r = r1; r < r2; r++) {
				for (int c = c1; c < c2; c++) {

					map[r][c] = true;
				}
			}
		}

		int[] info = new int[2];
		Queue<int[]> queue = new ArrayDeque<>();

		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };

		List<Integer> list = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				if (map[i][j] == true)
					continue;

				info[0] = i;
				info[1] = j;
				queue.offer(info);

				map[i][j] = true;
				int area = 1;
				while (!queue.isEmpty()) {
					int[] tmp = queue.poll();

					int nowX = tmp[0];
					int nowY = tmp[1];

					for (int m = 0; m < 4; m++) {
						int nx = nowX + dx[m];
						int ny = nowY + dy[m];

						if (nx >= 0 && nx < N && ny >= 0 && ny < M && !map[nx][ny]) {
							area++;
							map[nx][ny] = true;
							int[] newInfo = { nx, ny };
							queue.offer(newInfo);

						}
					}

				}
				if (area != 0)
					list.add(area);

			}
		}

		System.out.println(list.size());
		list.sort(null);

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}

}
