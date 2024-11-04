import java.util.*;

public class BOJ_1987_Alphabet {
	private static final int[] dx = { -1, 1, 0, 0 }; // 상하좌우 이동
	private static final int[] dy = { 0, 0, -1, 1 }; // 상하좌우 이동
	private static int R, C;
	private static char[][] board;
	private static boolean[] visited;
	private static int maxCount = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		R = scanner.nextInt();
		C = scanner.nextInt();
		board = new char[R][C];
		scanner.nextLine();

		for (int i = 0; i < R; i++) {
			board[i] = scanner.nextLine().toCharArray();
		}

		visited = new boolean[26]; // A-Z

		visited[board[0][0] - 'A'] = true;
		dfs(0, 0, 1);

		System.out.println(maxCount);
	}

	private static void dfs(int x, int y, int count) {
		maxCount = Math.max(maxCount, count);

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
				char nextChar = board[nx][ny];
				if (!visited[nextChar - 'A']) {
					visited[nextChar - 'A'] = true;
					dfs(nx, ny, count + 1);
					visited[nextChar - 'A'] = false;
				}
			}
		}
	}
}
