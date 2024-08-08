package Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// BOJ 2346 풍선 터뜨리기
public class boj2346_khj {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();

		Deque<Integer> deque = new ArrayDeque<>();

		// 1. 입력값 deque에 넣기
		// 2. Map을 활용하여 입력받은 num과 풍선 번호 매칭하기

		// 처음 Map으로 매팅하려고 했는데, key가 중복되는 경우 불가
		// => 클래스 만들기
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();

			deque.offer(num);
			map.put(num, i + 1);
		}
		System.out.println(map);

		// 3. 첫 번째 풍선 떠뜨리기
		int data = deque.poll();

		sb.append(map.get(data)).append(" ");

		// 4. deque이 빌 때까지 반복
		while (!(deque.isEmpty())) {

			// 양수이면,
			if (data > 0) {
				for (int i = 0; i < Math.abs(data) - 1; i++) {
					deque.offerLast(deque.pollFirst());
				}
				data = deque.pollFirst();
				sb.append(map.get(data)).append(" ");
				// 음수이면,
			} else {
				for (int i = 0; i < Math.abs(data) - 1; i++) {
					deque.offerFirst(deque.pollLast());
				}
				data = deque.pollLast();
				sb.append(map.get(data)).append(" ");
			}
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());
	} // main

}
