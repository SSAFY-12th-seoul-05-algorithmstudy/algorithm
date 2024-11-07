import java.util.*;

public class boj1774 {
	static int[] parent;
	static ArrayList<Edge> edgeList;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		// 부모를 만들어
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		Point[] points = new Point[N + 1];
		for (int i = 1; i <= N; i++) {
			double x = sc.nextDouble();
			double y = sc.nextDouble();
			points[i] = new Point(i, x, y);
		}
		
		// 사전에 연결된 간선을 미리 합집합 연산함.
		for (int i = 0; i < M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			union(start, end);
		}
		
		
		// 모든 통로들 간의 간선과 비용 정보를 edgeList에 넣어 둔다.
		edgeList = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				double weight = distance(points[i], points[j]);
				edgeList.add(new Edge(points[i].num, points[j].num, weight));
			}
		}
		Collections.sort(edgeList); // 간선의 비용을 기준으로 오름차순 정렬.
		double ans = 0;

		for (int i = 0; i < edgeList.size(); i++) {
			Edge edge = edgeList.get(i);
			if (find(edge.start) != find(edge.end)) {
				ans += edge.weight;
				union(edge.start, edge.end);
			}
		}
		
		System.out.println(String.format("%.2f", ans))
		;
		
		
	}

	public static double distance(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
	}

	public static int find(int x) {
		if (x == parent[x])
			return x;
		return parent[x] = find(parent[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x != y) {
			parent[y] = x;
		}
	}
}

class Point {
	int num;
	double x;
	double y;

	Point(int num, double x, double y) {
		this.num = num;
		this.x = x;
		this.y = y;
	}
}

class Edge implements Comparable<Edge> {
	int start;
	int end;
	double weight;

	Edge(int start, int end, double weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		if (weight < o.weight) {
			return -1;
		}
		return 1;
	}
}
