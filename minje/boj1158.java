package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 요세푸스 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();
		int N = sc.nextInt();
		int K = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		while (!queue.isEmpty()) {
			for (int i = 1; i < K; i++) {
				queue.add(queue.poll());
			}
			list.add(queue.poll());
		}
		System.out.print("<");
		for (int i = 0; i < N-1; i++) {
			System.out.print(list.get(i));
			System.out.print(", ");
		}
		System.out.print(list.get(N-1));
		System.out.print(">");


		sc.close();
	}

}
