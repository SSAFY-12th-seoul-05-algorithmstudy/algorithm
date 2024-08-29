package Deque_Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BOJ_1021 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] arr = new int[M];
		Deque<Integer> deque1 = new ArrayDeque<>();
		Deque<Integer> deque2 = new ArrayDeque<>();
		for(int i=0; i<M; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=1; i<N+1; i++) {
			deque1.add(i);
			deque2.add(i);
		}
		
		int cnt = 0;
		for(int i=0; i<M; i++) {
			int first = 0;
			int last = 0;
			while(deque1.peekFirst() != arr[i]) {
				deque1.addLast(deque1.pollFirst());
				first++;
			}
			deque1.pollFirst();
			
			while(deque2.peekLast() != arr[i]) {
				deque2.addFirst(deque2.pollLast());
				last++;
			}
			deque2.addFirst(deque2.pollLast());
			last++;
			deque2.pollFirst();
			
			cnt += Math.min(first, last);
		}
		
		System.out.println(cnt);
	} //main
}

