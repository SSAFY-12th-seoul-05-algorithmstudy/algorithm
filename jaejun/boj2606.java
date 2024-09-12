package boj;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class boj2606 {
	static int[][] arr;
	static boolean[] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();

		arr = new int[V + 1][V + 1];
		check = new boolean[V + 1];

		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			arr[a][b] = arr[b][a] = 1;
		}
		dfs(1);
	}

	static void dfs(int idx) {
		Queue<Integer> q = new ArrayDeque<>();
		check[idx] = true;
		q.offer(idx);
		int cnt = 0; // 감염된 컴퓨터의 수

		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int i = 1; i < arr.length; i++) {
				if (arr[curr][i] == 1 && !check[i]) {
					q.offer(i);
					check[i] = true;
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
