import java.util.Scanner;

// 수열에서 연속된 수들의 부분합 중에 그 합이 S 이상이 되는 것 중 가장 짧은 것의 길이를 구하기
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 수열 길이
		int S = sc.nextInt(); // 부분합이 되어야 할 값

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int start = 0;
		int end = 0;
		int sum = 0;
		int minLength = Integer.MAX_VALUE;

		while (end < N) {
			sum += arr[end];// end 포인터 값 추가
			end++;

			// sum이 S 이상인 경우
			while (sum >= S) {
				minLength = Math.min(minLength, end - start); // 길이 업데이트
				sum -= arr[start]; // start 포인터 이동
				start++;
			}
		}

		// 결과
		if (minLength == Integer.MAX_VALUE) {
			System.out.println(0); // 조건을 만족하는 부분 수열이 없는 경우
		} else {
			System.out.println(minLength);
		}

	} // main
} // class
