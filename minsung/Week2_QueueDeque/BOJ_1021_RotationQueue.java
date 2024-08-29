import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BOJ_1021_RotationQueue {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		Deque<Integer> deque = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {
			deque.offer(i);
		}

		int ans = 0;
		// 왼쪽으로 이동하는게 횟수가 적을지
		// 오른쪽으로 이동하는게 횟수가 적을지 비교

		for (int t = 0; t < M; t++) {
			int element = sc.nextInt();
			int leftcnt = 0;
			// 왼쪽으로 해보고
			while (deque.peek() != element) {
				deque.offerLast(deque.pollFirst());
				leftcnt++;
			}
			// 원상복구
			for (int i = 0; i < leftcnt; i++) {
				deque.offerFirst(deque.pollLast());
			}
			int rightcnt = 0;
			// 오른쪽으로 해보고
			while (deque.peek() != element) {
				deque.offerFirst(deque.pollLast());
				rightcnt++;
			}
			// 원상복구
			for (int i = 0; i < rightcnt; i++) {
				deque.offerLast(deque.pollFirst());
			}

			// 횟수 비교후 카운팅
			if (leftcnt < rightcnt) {
				while (deque.peek() != element) {
					deque.offerLast(deque.pollFirst());
				}
				deque.poll();
				ans += leftcnt;
			} else {
				while (deque.peek() != element) {
					deque.offerFirst(deque.pollLast());
				}
				deque.poll();
				ans += rightcnt;

			}

		}

		System.out.println(ans);

	}

}
