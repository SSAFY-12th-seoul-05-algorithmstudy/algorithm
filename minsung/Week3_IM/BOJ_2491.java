import java.util.Scanner;

public class BOJ_2491 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int max = 1;
		int cnt = 1;
		for (int i = 0; i < N - 1; i++) {
			if (arr[i] <= arr[i + 1]) {
				cnt++;
				if (cnt > max) {
					max = cnt;

				}
			} else {
				cnt = 1;
			}
		}
		cnt = 1;
		for (int i = 0; i < N - 1; i++) {
			if (arr[i] >= arr[i + 1]) {
				cnt++;
				if (cnt > max) {
					max = cnt;

				}
			} else {
				cnt = 1;
			}
		}

		System.out.println(max);

	}

}
