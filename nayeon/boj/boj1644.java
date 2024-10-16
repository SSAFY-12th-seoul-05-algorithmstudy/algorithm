import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		// 에라토스테네스의 체로 소수 구하기
		boolean[] arr = new boolean[N + 1];
		Arrays.fill(arr, true);

		// 소수 구하기: 에라토스테네스의 체
		arr[0] = false; // 0은 소수가 아님
		arr[1] = false; // 1은 소수가 아님
		for (int i = 2; i * i <= N; i++) {
			if (arr[i]) {
				for (int j = i * i; j <= N; j += i) {
					arr[j] = false;
				}
			}
		}

		// 소수를 리스트로 저장
		List<Integer> primeList = new ArrayList<>();
		for (int i = 2; i <= N; i++) {
			if (arr[i]) {
				primeList.add(i);
			}
		}

		// 투 포인터 알고리즘
		int left = 0;
		int right = 0;
		int count = 0;
		int sum = 0;

		// 소수의 합이 N이 되는 경우 찾기
		while (true) {
			if (sum >= N) {
				sum -= primeList.get(left);
				left++;
			} else if (right == primeList.size()) {
				break;
			} else {
				sum += primeList.get(right);
				right++;
			}

			if (sum == N) {
				count++;
			}
		}

		System.out.println(count);
		
	} // main 
} // class 
