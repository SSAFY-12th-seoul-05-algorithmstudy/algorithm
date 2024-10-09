import java.util.Scanner;
// 4963 섬의 개수
public class Main {
	static int W, H, count; // 지도의 너비 w, 높이 h, 섬의 개수 count
	static int[][] arr; // 섬
	static boolean[][] visited; // 방문여부 체크
	static int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 }; // 상하좌우, 대각선 좌상 우상 좌하 우하
	static int[] dy = { 0, 0, -1, 1, -1, 1, -1, 1 }; // 상하좌우, 대각선 좌상 우상 좌하 우하

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {

			W = sc.nextInt();
			H = sc.nextInt();

			// 입력의 마지막 줄에는 0이 두 개 주어짐.
			if (W == 0 && H == 0) {
				break;
			}

			arr = new int[H][W];
			visited = new boolean[H][W];

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			// 입력 끝

			count = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (arr[i][j] == 1 && !visited[i][j]) {
						dfs(i, j);
						count++;
					}
				}
			}

			System.out.println(count);
		} // while
	} // main

	static void dfs(int x, int y) {
		visited[x][y] = true;
		int nx = x;
		int ny = y;
		// 상하좌우, 대각선 좌상 우상 좌하 우하
		for (int i = 0; i < 8; i++) {
			int nc = nx + dx[i];
			int nr = ny + dy[i];
			// 방문 X, 연결된 섬이라면
			if (nc >= 0 && nr >= 0 && nc < H && nr < W) {
				if (!visited[nc][nr] && arr[nc][nr] == 1) {
					visited[nc][nr] = true;
					dfs(nc, nr);
				}
			}
		}

	} // dfs

} // class
