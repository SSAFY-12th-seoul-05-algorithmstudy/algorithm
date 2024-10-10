import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = 5;
		int[][] arr = new int[N][N];
		int[] row = new int[N];
		int[] col = new int[N];
		int[] diagonal = new int[2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				row[i] += arr[i][j];
				col[j] += arr[i][j];
				if (i == j) {
					diagonal[0] += arr[i][j];
				}
				if (i + j == 4) {
					diagonal[1] += arr[i][j];
				}
			}
		}
		boolean check = false;
		int result = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int a = Integer.parseInt(st.nextToken());
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if (arr[r][c] == a) {
							row[r] -= a;
							col[c] -= a;
							if (r == c) {
								diagonal[0] -= a;
							}
							if (r + c == 4) {
								diagonal[1] -= a;
							}
						}
					}
				}
				if (5 * i + j + 1 >= 12) {
					int count = 0;
					for (int n = 0; n < N; n++) {
						if (row[n] == 0) {
							count++;
						}
						if (col[n] == 0) {
							count++;
						}
					}
					if (diagonal[0] == 0) {
						count++;
					}
					if (diagonal[1] == 0) {
						count++;
					}
					if (count >= 3) {
						result = 5 * i + j + 1;
						check = true;
						break;
					}
				}
			}
			if (check) {
				break;
			}
		}
		System.out.println(result);
	}
}