import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7569 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static StringTokenizer st;

	static int n;
	static int m;
	static int h;
	static int[][][] arr;
	static int tomato;

	static Queue<int[]> que;
	static Queue<int[]> newQue;
	static int count;
	static int[] dr = { -1, 0, 1, 0 }; // 상우하좌
	static int[] dc = { 0, 1, 0, -1 };
	static int[] dh = { -1, 1 };

	static void input() throws IOException {

		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		arr = new int[h][n][m];
		que = new ArrayDeque<>();

		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					arr[k][i][j] = Integer.parseInt(st.nextToken());
					if (arr[k][i][j] == 0) {
						tomato++;
					} else if (arr[k][i][j] == 1) {
						que.offer(new int[] { k, i, j });
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// 1. 입력 및 초기화
		input();

		// 2. 로직
		while (!que.isEmpty() && tomato != 0) {
			bfs();
			count++;
			if (tomato == 0) {
				break;
			}
		}

		// 3. 출력
		count = (tomato > 0) ? -1 : count;

		bw.write(String.valueOf(count));

		br.close();
		bw.close();
	}

	static void bfs() {
		newQue = new ArrayDeque<>();
		
		int[] tmp;
		int x;
		int r;
		int c;
		int nx;
		int nr;
		int nc;
		
		while (!que.isEmpty()) {
			tmp = que.poll();
			x = tmp[0];
			r = tmp[1];
			c = tmp[2];
			for (int i = 0; i < 4; i++) { // 상하좌우 검사
				nr = r + dr[i];
				nc = c + dc[i];
				if (isValid(x, nr, nc) && arr[x][nr][nc] == 0) {
					arr[x][nr][nc] = -1;
					tomato--;
					newQue.offer(new int[] { x, nr, nc });
				}
			}
			
			for (int i = 0; i < 2; i++) { // 윗판, 아랫판 검사
				nx = x + dh[i];
				if (isValid(nx, r, c) && arr[nx][r][c] == 0) {
					arr[nx][r][c] = -1;
					tomato--;
					newQue.offer(new int[] { nx, r, c });
				}
			}
		}
		
		que = newQue;
	}

	static boolean isValid(int x, int r, int c) {
		return 0 <= x && x < h && 0 <= r && r < n && 0 <= c && c < m;
	}
}
