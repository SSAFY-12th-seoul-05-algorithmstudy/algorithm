package baekjoon;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class 회전하는큐 {
	public static void main(String[] args) {
		Queue<Integer> q = new ArrayDeque<>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int res = 0;
		int[] arr = new int[M];
		for (int i = 0; i < M; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		for (int i = 0; i < M; i++) {
			int cnt = 0;
			while (q.peek() != arr[i]) {
				q.add(q.poll());
				cnt++;
			}
			res += Math.min(q.size() - cnt, cnt);
			q.poll();
		}
		System.out.println(res);
		sc.close();
	}

}
