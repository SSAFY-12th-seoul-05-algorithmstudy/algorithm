import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			pq.add(sc.nextInt());
		}

		int totalCost = 0; // 총합을 저장할 변수

		// 카드 묶음이 1개만 있을 경우 비교할 필요 X -> 0 출력
		if (pq.size() == 1) {
			System.out.println(0);
		} else {
			// 우선순위 큐에서 두 개씩 꺼내 합친 후 다시 큐에 넣음
			while (pq.size() > 1) {
				int one = pq.poll();
				int two = pq.poll();
				int sum = one + two;
				totalCost += sum; // 합을 총합에 더함
				pq.add(sum); // 합친 묶음을 다시 큐에 추가
			}
			System.out.println(totalCost); // 최종 비용 출력
		}

	} // main
} // class
