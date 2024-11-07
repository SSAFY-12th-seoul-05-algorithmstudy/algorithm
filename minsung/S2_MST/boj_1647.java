import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	static List<int[]> edges;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		edges = new ArrayList<>();
		for (int i = 0; i < M; i++) {

		}

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			edges.add(new int[] { a, b, c });

		}
		ans = 0;

		Collections.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		int maxCost = 0;
		for (int[] edge : edges) {

			int a = edge[0];
			int b = edge[1];
			int c = edge[2];

			if (find(a) != find(b)) {
				union(a, b);
				ans += c;
				maxCost = c;
			}

		}

		System.out.println(ans - maxCost);

	}

	static int find(int x) {

		if (x != parent[x]) {
			return find(parent[x]);
		}

		return x;

	}

	static void union(int a, int b) {

		a = find(a);
		b = find(b);

		if (a < b)
			parent[b] = a;
		else
			parent[a] = b;

	}

	static int ans;

	static int[] parent;

}