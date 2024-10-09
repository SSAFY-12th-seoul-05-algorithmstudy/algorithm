package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class boj13023 {
	static int people, relationship, ans;
	static ArrayList<Integer>[] edge;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		people = sc.nextInt(); // 사람의 수(정점)
		relationship = sc.nextInt(); // (친구 관계의 수)

		edge = new ArrayList[people];
		for (int i = 0; i < people; i++) {
			edge[i] = new ArrayList<>();
		}
		visited = new boolean[people];

		for (int i = 0; i < relationship; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			edge[a].add(b);
			edge[b].add(a);
		}
		ans = 0;
		for (int i = 0; i < people; i++) {
			if (ans == 0)
				dfs(i, 1);
		}
		System.out.println(ans);
	}

	static void dfs(int start, int depth) {
		if (depth == 5) {
			ans = 1;
			return;
		}
		visited[start] = true;
		for (int i : edge[start]) {
			int next = i;
			if (!visited[next]) {
				dfs(next, depth + 1);
			}
		}
		visited[start] = false;
	}
}
