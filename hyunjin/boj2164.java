package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// BOJ 2164 카드2
public class boj2164_khj {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			queue.add(i + 1);
		}

		//queue의 사이즈가 1이 될 때까지 반복
		while (!(queue.size() == 1)) {
			queue.poll(); // 가장 위 값 빼기
			queue.add(queue.poll()); // 다음 위의 값 빼서 아래로 다시 넣기
		}
		System.out.println(queue.poll());
	}
}
