import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static List<Node>[] map = null;
	static boolean[] visited = null;
	static int[] dist = null;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		map = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			map[i] = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int U = Integer.parseInt(st.nextToken());
			while(true) {
				int V = Integer.parseInt(st.nextToken());
				if (V == - 1) break;
				int dist = Integer.parseInt(st.nextToken());
				map[U].add(new Node(V, dist));
				map[V].add(new Node(U, dist));
			}
		}

		visited = new boolean[N + 1];
		dist = new int[N + 1];
		// 임의의 지점에서 가장 먼 노드를 찾음
		bfs(1);
		int node = 1;
		for (int i = 2; i <= N; i++) {
			if (dist[node] < dist[i])
				node = i;
		}

		visited = new boolean[N + 1];
		dist = new int[N + 1]; 
		bfs(node);
		int diameter = Arrays.stream(dist).max().getAsInt();
		System.out.println(diameter);
	}

	public static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		visited[start] = true;
		q.add(start);

		while (!q.isEmpty()) {
			int tmp = q.poll();
			for (Node p : map[tmp]) {
				if (!visited[p.no]) {
					visited[p.no] = true;
					dist[p.no] = dist[tmp] + p.dist;
					q.add(p.no);
				}
			}
		}
	}
	
	static class Node {
		int no;
		int dist;

		public Node(int node, int dist) {
			this.no = node;
			this.dist = dist;
		}
	}
}