package DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// BOJ1260_DFS와 BFS
public class boj1260 {
	static int N, M, V;
	static int[][] adjArr; // 인접 행렬
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 정점의 개수
		M = sc.nextInt(); // 간선의 개수
		V = sc.nextInt(); // 탐색을 시작할 정점

		adjArr = new int[N + 1][N + 1]; // 정점의 시작이 1이기 때문
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			adjArr[A][B] = adjArr[B][A] = 1;
		}

		// DFS / BFS 차례로 돌기

		dfs(V); // 1번 정점부터 dfs 시작

		System.out.println();

		// dfs를 돌고 나서 TRUE로 바껴있는 visited 배열 초기화하기
		visited = new boolean[N + 1];
		bfs(V); // 1번 정점부터 bfs 시작

	}

	static void dfs(int v) {
		visited[v] = true; // 시작 지점 or 방문한 지점 true로 변경
		System.out.print(v + " ");

		for (int i = 1; i < N + 1; i++) {
			if (!visited[i] && adjArr[v][i] == 1)
				dfs(i);
		}
	}

	private static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();

		q.add(v);
		visited[v] = true;

		while (!q.isEmpty()) {
			v = q.poll();
			System.out.print(v + " ");

			for (int i = 1; i < N + 1; i++) {
				if (!visited[i] && adjArr[v][i] == 1) {
					q.add(i);
					visited[i] = true;
				}
			}
		}

	}
}