package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj1158_khj {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();
		int K = sc.nextInt();

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			queue.offer(i + 1);
		}


		// queue가 빌 때까지 반복문 돌기
		while (!(queue.isEmpty())) {
			// K-1번 앞에 두개 빼서 뒤로 넣기
			for (int i = 0; i < K - 1; i++) {
				int data = queue.poll();
				queue.offer(data);
			}
			// 제일 앞으로 온 원소부터 빼기
			sb.append(queue.poll()).append(", ");
		}
		
		// 마지막 숫자 뒤에 붙은 ,과 " " 공백 제거하기
		sb.delete(sb.length()-2, sb.length());
		System.out.println("<" + sb.toString() + ">");
	} // main
}
