import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13300 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] arr = new int[6][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st2.nextToken());
			int Y = Integer.parseInt(st2.nextToken());
			arr[Y - 1][S]++;
		}
		int ans = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 2; j++) {
				while (arr[i][j] != 0) {
					if (arr[i][j] >= K) {
						arr[i][j] -= K;
						ans++;
					} else if (arr[i][j] < K) {
						arr[i][j] = 0;
						ans++;
					}
				}
			}
		}

		System.out.println(ans);
		br.close();

	}

}
