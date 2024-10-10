package Deque_Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BOJ_2164 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // N장의 카드 입력받기
		Deque<Integer> deque = new ArrayDeque<>();
		
		for(int i=1; i<N+1; i++) {
			deque.add(i); // 1~N까지 (1이 가장 위에 오게) deque에 삽입
		}
		
		// 카드가 한장 남을 때까지 반복
		while(deque.size() > 1) {
			// 1. 제일 위(앞)에 있는 카드를 버린다
			deque.pollFirst();
			
			// 2. 제일 위(앞)에 있는 카드를 제일 아래(뒤)로 옮긴다
			deque.addLast(deque.pollFirst());
		}
		
		System.out.println(deque.peek());
	}
}
