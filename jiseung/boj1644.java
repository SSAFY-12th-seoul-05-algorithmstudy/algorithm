import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = 0;
		int result = Integer.MAX_VALUE;
		int sum = 0;
		boolean possible = false;
		while (left < N && right <= N) {
			if (right == N) {
				if (sum < S) {
					break;
				} else {
					possible = true;
					result = Math.min(result, right - left);
					sum -= arr[left];
					left++;
				}
			} else {

				if (sum < S) {
					sum += arr[right];
					right++;
				} else {
					possible = true;
					result = Math.min(result, right - left);
					sum -= arr[left];
					left++;
				}
			}
		}

		if (possible) {
			System.out.println(result);
		} else {
			System.out.println(0);
		}
	}
}