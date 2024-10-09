package boj;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class boj24479 {
	static int N, M, start, order;
	static boolean[] visited;
	static int[] visitedN;
//	static int[][] arr;
	static ArrayList<Integer>[] edges;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		start = sc.nextInt();

		// edges 리스트 선언
		edges = new ArrayList[N + 1]; // 시간초과떄문에 arr -> List 사용
		for (int i = 1; i <= N; i++) {
			edges[i] = new ArrayList<>();
		}
//		arr = new int[N + 1][N + 1]; // 1부터 N개의 정점

		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
//			arr[u][v] = arr[v][u] = W; // 시간초과 때문에 사용 x
			edges[u].add(v);
			edges[v].add(u);// 양방향 설정
		}
		for (int i = 1; i <= N; i++) {
			Collections.sort(edges[i]);
		}
		visited = new boolean[N + 1]; // 위와 같음
		visitedN = new int[N + 1];
		order = 1;

		dfs(start);
		for (int i = 1; i <= N; i++) {
			if (visitedN[i] == 0) {
				System.out.println(0);
			} else {
				System.out.println(visitedN[i]);
			}
		}

	}

	static void dfs(int start) {
		visited[start] = true;
		visitedN[start] = order++;

		for (int next : edges[start]) {
			if (!visited[next]) {
				dfs(next);
			}
		}
	}
}
