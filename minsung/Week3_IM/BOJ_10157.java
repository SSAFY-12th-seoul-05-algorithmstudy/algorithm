import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10157 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		if (K > r * c) {
			System.out.println(0);
			br.close();
			return;
		}

		boolean[][] map = new boolean[r][c];

		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		int nr = 0;
		int nc = 0;
		int x = 0;
		int y = 0;
		int k = 1;
		int index = 0;
		while (k < K) {
			map[nr][nc] = true;
			nr = x + dr[index];
			nc = y + dc[index];

			k++;

			if (nr < 0 || nr >= r || nc < 0 || nc >= c || map[nr][nc]) {
				index = (index + 1) % 4;
				nr = x + dr[index];
				nc = y + dc[index];
			}

			x = nr;
			y = nc;
		}

		StringBuilder sb = new StringBuilder();
		sb.append(nr + 1).append(" ").append(nc + 1);
		System.out.println(sb.toString());

		br.close();

	}

}