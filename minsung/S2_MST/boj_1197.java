import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;

	static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		List<int[]> edges = new ArrayList<>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			edges.add(new int[] { a, b, c });

		}

		Collections.sort(edges, (a, b) ->Integer.compare(a[2],b[2]));

		// Union-Find 초기화
		parent = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}

		long totalWeight = 0;
		int count = 0; // 선택한 간선의 개수

		for (int[] edge : edges) {
			int a = edge[0];
			int b = edge[1];
			int cost = edge[2];

			// 사이클이 생기지 않으면 선택
			if (find(a) != find(b)) {
				union(a, b);
				totalWeight += cost;
				count++;
			}

			// V-1개의 간선을 선택하면 종료
			if (count == V - 1)
				break;
		}

		System.out.println(totalWeight);
	}

}