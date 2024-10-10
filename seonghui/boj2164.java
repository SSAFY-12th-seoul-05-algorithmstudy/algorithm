import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj2164 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		// 1~N 큐에 추가
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}

		while (queue.size() > 1) { // 1개 남을때까지 반복
			// 제일 앞 카드 버리고, 그 다음 카드를 큐 뒷쪽으로 추가
			queue.remove();
			queue.add(queue.remove());
		}
		System.out.println(queue.peek());
	}// main
}
