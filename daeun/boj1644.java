import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj1644 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// 자연슈 N

		boolean[] prime = new boolean[N + 1];

		
		//에라토스네스의 체 
		for (int i = 0; i < N + 1; i++) {

			prime[i] = true;
		}

		prime[1] = false;
		List<Integer> list = new ArrayList<>();

		for (int i = 2; i <= Math.sqrt(N); i++) {
			if (prime[i]) {
				for (int j = i * i; j <= N; j += i) {
					prime[j] = false;
				}
			}
		}

		for (int i = 2; i <= N; i++) {

			
			if (prime[i]) { //소수맞으면 리스트에 추가
				list.add(i);
			}
		}

		int count = 0;
		int sum = 0;
		int left = 0;
		int right = 0;

		while (right < list.size()) {

			sum += list.get(right);
			
			right++;

			while (sum > N && left < right) {
				sum -= list.get(left);
				left++;
			}

			if (sum == N) {
				count++;
			}
		}

		// while

		System.out.println(count);

	}// main

}
