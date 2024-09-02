import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7569_tomato {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// N행 M열 처리
		int M = sc.nextInt();
		int N = sc.nextInt();
		int H = sc.nextInt();

		int[][][] map = new int[N][M][H];
		boolean[][][] visited = new boolean[N][M][H];
		Queue<int[]> queue = new ArrayDeque<>();

		int unripe = 0;

		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j][k] = sc.nextInt();
					// 이미 익은 토마토를 저장하고, 큐에 넣어야 함
					if (map[i][j][k] == 1) {
						// 익은토마토에 또 방문할 일은 없으므로,
						visited[i][j][k] = true;

						// r,c,z, 좌표와 day 정보
						int[] tmp = new int[4];
						tmp[0] = i;
						tmp[1] = j;
						tmp[2] = k;
						tmp[3] = 0;

						queue.offer(tmp);

					} else if (map[i][j][k] == 0)
						unripe++;
				}
			}
		}

		int[] dr = { 0, 1, 0, -1, 0, 0 };
		int[] dc = { 1, 0, -1, 0, 0, 0 };
		int[] dz = { 0, 0, 0, 0, 1, -1 };
		// queue를 list로 초기화
		int lastDay = 0;
		while (!queue.isEmpty()) {

			int[] tmp = queue.poll();
			int r = tmp[0];
			int c = tmp[1];
			int z = tmp[2];
			int day = tmp[3];

			for (int i = 0; i < 6; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				int nz = z + dz[i];

				// 인덱스 체크 && 안익은 토마토인지 빈 공간인지 체크 && 방문을 했었는지
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && nz >= 0 && nz < H && map[nr][nc][nz] == 0
						&& !visited[nr][nc][nz]) {

					// if 문에 들어왔다 -> 안익은 토마토다
					map[nr][nc][nz] = 1; // 익힘
					visited[nr][nc][nz] = true; // 방문
					unripe--; // 안익은거 -1

					int[] newTomato = new int[4];
					newTomato[0] = nr;
					newTomato[1] = nc;
					newTomato[2] = nz;
					newTomato[3] = day + 1;

					if (lastDay < day + 1)
						lastDay = day + 1;

					queue.offer(newTomato);

				}
			}

		}

		if (unripe == 0) {
			System.out.println(lastDay);
		} else
			System.out.println(-1);

	}

}
