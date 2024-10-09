package 백준;

import java.util.*;

public class boj1260 {

	static List<Integer>[] graph;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();

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
		visited = new boolean[N + 1];
		dfs(V);
		System.out.println();
		visited = new boolean[N + 1];
		bfs(V);
		sc.close();
	}

	static void dfs(int v) {
		System.out.print(v + " ");
		visited[v] = true;
		for (int next : graph[v]) {
			if (!visited[next]) {
				dfs(next);
			}
		}
	}

	static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(v);
		visited[v] = true;
		System.out.print(v + " ");

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int next : graph[cur]) {
				if (!visited[next]) {
					visited[next] = true;
					queue.add(next);
					System.out.print(next + " ");
				}
			}
		}
	}
}
