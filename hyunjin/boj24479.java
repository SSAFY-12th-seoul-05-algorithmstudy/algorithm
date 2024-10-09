package DFS;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// BOJ24479_알고리즘 수업 - 깊이 우선 탐색 1
public class boj24479 {
//	static int[][] adjArr;
	static List<Integer>[] adjList;
	static boolean[] visited;
	static int[] sequenceArr;
	static int cnt = 1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int R = sc.nextInt();

//		adjArr = new int[N + 1][N + 1];
		adjList = new LinkedList[N + 1];

		for (int i = 0; i < N + 1; i++) {
			adjList[i] = new LinkedList<>();
		}

		visited = new boolean[N + 1];
		sequenceArr = new int[N + 1];

		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			adjList[A].add(B);
			adjList[B].add(A);
		}

		// 오름차순 탐색을 위해 정렬
		for (int i = 1; i < N + 1; i++) {
			Collections.sort(adjList[i]);
		}

		dfs(N, M, R);

//		System.out.println(Arrays.toString(sequenceArr));
		for (int i = 1; i < N + 1; i++) {
			System.out.println(sequenceArr[i]);
		}

	}

	static void dfs(int V, int E, int R) {
		visited[R] = true;
		sequenceArr[R] = cnt++;

		for (int i : adjList[R]) {
			if (!visited[i] )
				dfs(V, E, i);
		}

	}
}