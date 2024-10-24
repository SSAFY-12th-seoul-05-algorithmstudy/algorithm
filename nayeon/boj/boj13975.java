import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int K = sc.nextInt(); // 소설을 구성하는 장의 수
			PriorityQueue<Long> pq = new PriorityQueue<>();
			for (int j = 0; j < K; j++) {
				pq.add(sc.nextLong());
			}

			// K-1 번 반복
			long result = 0;
			for (int k = 0; k < K - 1; k++) {
				long first = pq.poll(); // 가장 작은 수 pq에서 빼기
				long second = pq.poll(); // 두번째로 작은 수 pq에서 빼기
				pq.add(first + second); // 더한 후 다시 pq에 넣기
				result += first + second; // 합은 결과값에 저장
			}

			System.out.println(result);
		} // T번 반복

	} // main
} // class
