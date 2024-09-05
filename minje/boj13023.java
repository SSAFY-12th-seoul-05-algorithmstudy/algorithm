package 백준;

import java.util.*;

public class boj13023 {

	static List<Integer>[] graph;
	static boolean[] visited;
	static int N;
	static boolean isPossible;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		graph = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			graph[A].add(B);
			graph[B].add(A);
		}
		isPossible = false;
		visited = new boolean[N];

		for (int v = 0; v < N; v++) {
			dfs(v, 0);
			if (isPossible) {
				System.out.println(1);
				break;
			}
		}
		if (!isPossible) {
			System.out.println(0);
		}
		sc.close();
	}

	static void dfs(int v, int cnt) {
		if (cnt == 4) {
			isPossible = true;
			return;
		}
		visited[v] = true;
		for (int next : graph[v]) {
			if (!visited[next]) {
				dfs(next, cnt + 1);
			}
		}
		 visited[v] = false;
	}
}