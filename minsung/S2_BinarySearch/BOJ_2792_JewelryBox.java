import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2792_JewelryBox {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] jewelry = new int[M];
		for (int i = 0; i < M; i++) {
			jewelry[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(jewelry);

		// 나눠주는 최소 보석 갯수
		int left = 1;
		// 나눠주는 최대 보석 갯수
		int right = jewelry[M - 1];

		while (left <= right) {
			int mid = (left + right) / 2;
			// 몇명에게 나눠 주었나.
			int cnt = 0;

			for (int i = 0; i < M; i++) {
				if (jewelry[i] % mid == 0)
					cnt += jewelry[i] / mid;
				else
					cnt += 1 + jewelry[i] / mid;
			}

			if (cnt <= N)
				right = mid - 1;
			else
				left = mid + 1;

		}
		
		System.out.println(left);

	}

}
