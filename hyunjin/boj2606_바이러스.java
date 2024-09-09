package DFS;

import java.util.Scanner;

public class BOJ2606_바이러스 {
	public static class Edge {
		int A, B;

		public Edge(int a, int b) {
			super();
			A = a;
			B = b;
		}
	}

	static int[] p; // 대표(부모)를 저장하는 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt(); // 정점의 개수
		int E = sc.nextInt(); // 간선의 개수

		Edge[] edges = new Edge[E];

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			edges[i] = new Edge(A, B);
		} // 정점과 간선 입력 완료

		p = new int[V + 1]; // 정점이 1번부터 시작하므로

		// 1. 각 노드 자신을 대표로 만들기
		for (int i = 1; i < V + 1; i++) {
			makeSet(i);
		}

		// 2. findSet을 통해 간선 연결하면서 union 구하기
		for (int i = 0; i < E; i++) {
			int px = findSet(edges[i].A);
			int py = findSet(edges[i].B);

			// px, py 값이 다를 경우, union 진행
			if (px != py) {
				union(px, py);
			}
		}

		int ans = 0;
		for (int i = 1; i < V + 1; i++) {
			if (findSet(p[i]) == findSet(p[1]))
				ans++;
		}
		System.out.println(ans - 1); // 1번 노드는 개수에 포함 X
	}

	static void makeSet(int x) {
		p[x] = x;
	}

	static int findSet(int x) {
		if (p[x] != x) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}

	static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}
}
