import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1244 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[] arr = new boolean[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt() == 1 ? true : false;
		}
		int M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			int G = sc.nextInt();
			// 남학생
			if (G == 1) {
				int k = sc.nextInt();

				for (int j = 0; j < N; j++) {
					if ((j + 1) % k == 0) {
						arr[j] = !arr[j];
					}
				}

			} else if (G == 2) {
				// 여학생
				int k = sc.nextInt();
				int index = 1;
				while (true) {
					if (k - 1 - index >= 0 && k - 1 + index < N && arr[k - 1 - index] == arr[k - 1 + index]) {
						arr[k - 1 - index] = !arr[k - 1 - index];
						arr[k - 1 + index] = !arr[k - 1 + index];

						index++;
					} else {

						arr[k - 1] = !arr[k - 1];
						break;

					}

				}

			}
		} // 학생입력끝
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			if (arr[i]) {
				sb.append(1).append(" ");
			} else {
				sb.append(0).append(" ");
			}
			if (i % 20 == 19) {
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());

	}

}
