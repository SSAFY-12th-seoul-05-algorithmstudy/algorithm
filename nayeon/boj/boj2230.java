import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 원소의 개수
		int M = sc.nextInt(); // 차이
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		// 두 포인터하기 위해 배열 정렬
		Arrays.sort(arr);

		int right = 0; // 오른쪽 포인터
		int left = 0; // 왼쪽 포인터
		int result = Integer.MAX_VALUE;

		// 두 포인터를 이용하여 배열 순회
		while (right < N) {
			// 현재 차이
			int difference = arr[right] - arr[left];

			// 차이가 M보다 작은 경우 -> 오른쪽 포인터 증가
			if (difference < M) {
				right++;
				continue;
			}

			// 차이가 M인 경우 -> 최소 차이
			if (difference == M) {
				result = M;
				break; // M보다 작은 차이는 없으므로 반복문 종료
			}

			// 더 작은 차이로 업데이트
			result = Math.min(result, difference);

			// 왼쪽 포인터 증가 -> 더 작은 차이 찾기
			left++;

			// 왼쪽 포인터가 오른쪽 포인터를 초과하지 않도록 !
			if (left > right) {
				right++; // 필요할 경우 오른쪽 포인터를 앞으로 이동
			}
		}

		// 최소 차이
		System.out.println(result);
	} // main
} // class
