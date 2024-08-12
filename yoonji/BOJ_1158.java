package Deque_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1158 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=1; i<N+1; i++) {
			queue.add(i);
		}
		
		String answer = "";
		while(queue.size() != 1) {
			for(int i=1; i<K; i++) { // 1~K-1까지는 안나감
				queue.add(queue.poll());
			}
			// K번째 사람은 나간다.
			int num = queue.poll();
			sb.append(num).append(", ");
		}
		// 출력 형식에 맞게 출력
		System.out.println(sb.append(queue.poll()).append(">"));
	}
}
