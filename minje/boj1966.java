package baekjoon;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class 프린터큐 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			Queue<Integer> q = new ArrayDeque<>();
			int N = sc.nextInt();
			int M = sc.nextInt();
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				q.add(sc.nextInt());
			}
			out: while (!(q.isEmpty())) {
				int max = 0;
				for (int value : q) {
					max = Math.max(max, value);
				}
				if (q.peek() != max) {
					q.add(q.poll());
					M--;
					if (M < 0) {
						M = q.size() - 1;
					}
				} else {
					cnt++;
					q.poll();
					if (M == 0) {
						break out;
					}
					M--;
				}
			}
			System.out.println(cnt);
			q.clear();
		}
		sc.close();
	}
}
