package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// BOJ25418_정수 a를 k로 만들기

public class boj25418 {
	static int A, K;
	static boolean[] isChecked;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		A = sc.nextInt();
		K = sc.nextInt();

		bfs(A);

	} // main

	static void bfs(int A) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { A, 0 });
		isChecked = new boolean[K + 1]; // 방문했는지 체크해야하는데, 최대 K까지
		isChecked[A] = true;

		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int currentValue = tmp[0];
			int operationCnt = tmp[1];

			if (currentValue == K) {
				System.out.println(operationCnt);
				return;
			}

			// A+1 연산보다 A*2 연산을 시행하는 것이 횟수 최소로 만들 수 있다.
			if (currentValue * 2 <= K) {
				isChecked[currentValue * 2] = true;
				queue.offer(new int[] { currentValue * 2, operationCnt + 1 });
			}

			if (!isChecked[currentValue + 1]) {
				isChecked[currentValue + 1] = true;
				queue.offer(new int[] { currentValue + 1, operationCnt + 1 });
			}
		}

	}
}
