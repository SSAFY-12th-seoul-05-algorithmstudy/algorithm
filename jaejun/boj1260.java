package boj;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class boj1260 {
	static int N, M, V;
	static boolean[] visited;
	static int[][] graph;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정점의 개수
		M = sc.nextInt(); // 간선의 개수
		V = sc.nextInt(); // 탐색 시작할 번호 V

		graph = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			graph[u][v] = graph[v][u] = 1; // 양방향
		}
		// DFS
		dfs(V);
		System.out.println();
		
		// BFS 배열 초기화
		visited = new boolean[N + 1];
		bfs(V);

	}

	static void dfs(int V) {
		visited[V] = true; // 시작지점
		System.out.print(V + " "); // DFS 돌때마다 시작지점 확인

		for (int i = 0; i <= N; i++) {
			if (!visited[i] && graph[V][i] != 0) { // V 정점과 연결된 간선 확인
				dfs(i); // 재귀를 통해 계속 돌기.
			}
		}
	}

	static void bfs(int V) {
		Queue<Integer> q = new ArrayDeque<>(); // 큐 생성(여기서는 각 정점만 확인해서 Integer)
		q.add(V); // 첫 노드 확인
		visited[V] = true;

		while (!q.isEmpty()) {
			V = q.poll(); 
			System.out.print(V+" ");
			for (int i = 1; i <= N; i++) {
				if (graph[V][i] != 0 && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}

			}
		}
	}

}
