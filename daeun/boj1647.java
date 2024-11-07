import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 도시분할계획 {
	
	static int N, M; //마을(정점), 길(간선)
	
	
	static class Edge implements Comparable<Edge> {
		
		int to;
		int cost;
		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost; //가중치 기준 오름차순 정렬할 것 
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		List<Edge> graph[] = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			graph[A].add(new Edge(B, C));
			graph[B].add(new Edge(A, C));
			
		}
		
		
		int total = prim(graph);
		
		System.out.println(total);
		
		
	}//main


	//프림
	private static int prim(List<Edge>[] graph) {
		boolean visited[] = new boolean[N+1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		int total =0;
		int maxcost =0;
		pq.add(new Edge(1,0));
		
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			int currNode = edge.to;
			int cost = edge.cost;
			
			if(visited[currNode]) {
				continue;
			}
			
			visited[currNode] = true;
			total+=cost;
			
			maxcost = Math.max(maxcost, cost);
			
			for(Edge e: graph[currNode]) {
				if(!visited[e.to]) {
					pq.add(new Edge(e.to, e.cost));
				}
			}
			
					
		}
		
		return total-maxcost;
	}	

}
