import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static String[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		arr = new String[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(arr[i], "*");
		}
		star(N,0,0);
		for (int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder();
			for(int j=0;j<N;j++) {
				sb.append(arr[i][j]);
			}
			System.out.println(sb.toString());
		}
	}

	public static void star(int N, int r, int c) {
		int num = N / 3;
		if (num == 0) {
			return;
		} else {
			star(num, r, c);
			star(num, r + num, c);
			star(num, r + 2 * num, c);
			star(num, r, c + num);
			for (int i = num; i < 2 * num; i++) {
				for (int j = num; j < 2 * num; j++) {
					arr[r+i][c+j] = " ";
				}
			}
			star(num, r + 2 * num, c + num);
			star(num, r, c + 2 * num);
			star(num, r + num, c + 2 * num);
			star(num, r + 2 * num, c + 2 * num);
		}
	}
}
