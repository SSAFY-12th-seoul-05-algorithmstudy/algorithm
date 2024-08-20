import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_13335_Truck {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int W = sc.nextInt();
		int L = sc.nextInt();

		Queue<Integer> queue = new ArrayDeque<>();
		Queue<Integer> waitQueue = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			waitQueue.offer(sc.nextInt());

		}
		for (int i = 0; i < W; i++) {
			queue.offer(0);

		}

		int num = 0;
		int bridgeSum = 0;
		int time = 0;
		do {
			time++;
			int onTruck = waitQueue.peek();
			int outTruck = queue.peek();
			if (bridgeSum - outTruck + onTruck <= L) {
				if (queue.poll() != 0)
					num--;
				queue.offer(waitQueue.poll());
				bridgeSum = bridgeSum - outTruck + onTruck;
				num++;
			} else {
				if (queue.poll() != 0) {
					num--;
					bridgeSum -= outTruck;

				}
				queue.offer(0);
			}

		} while (waitQueue.size() != 0);

		while (num != 0) {
			time++;
			if (queue.poll() != 0) {
				num--;
			}
		}

		System.out.println(time);

	}

}
