package baekjoon;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class 트럭 {
	public static void main(String[] args) {
		Queue<Integer> onBridge = new ArrayDeque<>();
		Queue<Integer> toStart = new ArrayDeque<>();

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int w = sc.nextInt();
		int L = sc.nextInt();
		int res = 0;
		int weight = 0;
		for (int i = 0; i < n; i++) {
			toStart.add(sc.nextInt());
		}
		while (!toStart.isEmpty()) {

			res++;

			if (weight + toStart.peek() <= L) {
				weight += toStart.peek();
				onBridge.add(toStart.poll());
			}
			else {
				onBridge.add(0);
			}

			if (onBridge.size() == w) {
				weight -= onBridge.poll();
			}

		}
		System.out.println(res + w);
	}
}
