package 백준;

import java.util.*;

public class boj24479 {

	static List<Integer>[] graph;
	static int[] visited;
	static int cnt = 1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int R = sc.nextInt();

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			graph[A].add(B);
			graph[B].add(A);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}
		visited = new int[N + 1];
		dfs(R);
		for (int i = 1; i <= N; i++) {
			System.out.println(visited[i]);
		}
//		System.out.println();
//		visited = new boolean[N + 1];
//		bfs(V);
		sc.close();
	}

	static void dfs(int v) {

		visited[v] = cnt++;
		for (int next : graph[v]) {
			if (visited[next] == 0) {
				dfs(next);
			}
		}
	}

}
