import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1966_PrinterQueue {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			Queue<Paper> queue = new ArrayDeque<>();
			int[] priArr = new int[N];
			// 입력 받기, 이때 우선순위 배열을 만들어서 최댓값 비교 쉽게
			for (int i = 0; i < N; i++) {
				int tmp = sc.nextInt();
				queue.offer(new Paper(tmp, i));
				priArr[i] = tmp;
			}

			Arrays.sort(priArr);
			int index = N - 1;
			int ans = 0;

			while (true) {
				// 우선순위 가장 높은 paper 탐색
				while (queue.peek().priority < priArr[index]) {
					queue.offer(queue.poll());
				}
				// 우선 순위 가장 높은 paper 의 num 확인
				Paper paper = queue.poll();
				index--;
				ans++;
				if (paper.num == M) {
					System.out.println(ans);
					break;
				}
			}

		}

	}

}

class Paper {
	int priority;
	int num;

	public Paper(int priority, int num) {
		super();
		this.priority = priority;
		this.num = num;
	}

}
