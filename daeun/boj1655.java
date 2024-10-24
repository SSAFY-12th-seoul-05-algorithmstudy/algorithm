import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());// 외치는 정수의 개수

		PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순
		PriorityQueue<Integer> right = new PriorityQueue<>(); // 오룸차순

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine()); // 외치는 정수들

			if (left.isEmpty()|| num <= left.peek()) {
				left.add(num);
			} else {
				right.add(num);
			}

//			while (left.peek() < right.peek()) {
//
			if (left.size() > right.size() + 1) {
				right.add(left.poll());

			} else if (right.size() > left.size()) {
				left.add(right.poll());
			}

			sb.append(left.peek()).append("\n");
		} // for

		System.out.println(sb);
	}// main

}
