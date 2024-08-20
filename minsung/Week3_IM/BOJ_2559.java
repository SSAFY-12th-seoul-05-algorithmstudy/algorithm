import java.util.Scanner;

public class BOJ_2559 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		int[] tarr = new int[N];
		int[] sum = new int[N - K + 1];

		for (int i = 0; i < N; i++) {
			tarr[i] = sc.nextInt();
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N - K + 1; i++) {
			for (int j = 0; j < K; j++) {
				sum[i] += tarr[i + j];
			}
			if (max < sum[i])
				max = sum[i];
		}
		System.out.println(max);
	}

}
