import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 우주신과의교감 {

	static int N, M; // 우주신개수(정점), 통로(간선)
	static int[] parent;

	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		double cost;

		public Edge(int start, int end, double cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override // 통로 길이 오름차순 정렬
		public int compareTo(Edge o) {
			return Double.compare(this.cost, o.cost);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// make
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		// 신 위치 정보 저장
		double[][] point = new double[N + 1][2]; // x,y
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			point[i][0] = Double.parseDouble(st.nextToken());
			point[i][1] = Double.parseDouble(st.nextToken());

		}

		//이미 연결되있는 선 넣음
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			union(start, end);
		}
			
		List<Edge> edges = new ArrayList<>();
		for(int i=1; i<=N; i++) {
			for(int j=i+1; j<=N; j++) {
				double cost = dis(point[i], point[j]);
				edges.add(new Edge(i, j, cost));
			}
		}
		
		Collections.sort(edges);
		double ans =0;
		for(Edge e: edges) {
			if(find(e.start) != find(e.end)) {
				 ans += e.cost;
				union(e.start, e.end);
			}
		}
		System.out.printf("%.2f\n", ans);

	}// main

	// 모든 간선간의 거리 곘산
	public static double dis(double[] a, double[] b) {
		return Math.sqrt((Math.pow(a[0]-b[0], 2))+ (Math.pow(a[1]-b[1], 2)));
	}

	// find
	public static int find(int x) {
		if (x == parent[x]) {
			return x;
		}

		return x = find(parent[x]);

	}

	// union
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			parent[y] = x;
		}
	}

}
