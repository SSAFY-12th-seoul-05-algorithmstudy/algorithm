import java.util.*;
import java.io.*;

public class Main {

	static class Edge implements Comparable<Edge> {
		int num;
		int w;

		Edge(int num, int w) {
			this.num = num;
			this.w = w;
		}

		@Override
		public int compareTo(Edge other) {
			return Integer.compare(this.w, other.w);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		List<Edge>[] list = new ArrayList[V + 1];
		boolean[] visited = new boolean[V + 1];
		
		for(int i=1;i<=V;i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[a].add(new Edge(b, w));
			list[b].add(new Edge(a, w));
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>();

		pq.add(new Edge(1, 0));
		int result = 0;
		
		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			int num = now.num;
			int w = now.w;
			
			if(!visited[num]) {
				visited[num]=true;
				result +=w;
				for(Edge next : list[num]) {
					if(!visited[next.num]) {
						pq.add(next);
					}
				}
			}
		}
		System.out.println(result);
	}
}