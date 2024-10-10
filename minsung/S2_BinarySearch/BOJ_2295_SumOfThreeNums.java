import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class BOJ_2295_SumOfThreeNums {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());

		}

		Arrays.sort(arr);

		HashSet<Integer> hashset = new HashSet<>();

		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				hashset.add(arr[i] + arr[j]);
			}
		}
		int ans = 01;
		out: for (int i = N - 1; i >= 0; i--) {
			for (int j = i; j >= 0; j--) {
				if (hashset.contains(arr[i] - arr[j])) {
					ans = i;

					break out;
				}
			}
		}

		System.out.println(arr[ans]);

		br.close();

	}

}