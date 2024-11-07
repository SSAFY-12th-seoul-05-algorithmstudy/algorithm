import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소스패닝트리 {
	
	static int V, E;
	
	
	static class Edge implements Comparable<Edge> {
		
		int to; //방문 정점
		int cost; //가중치
		
		public Edge(int to, int cost) {
			this.to =to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		List<Edge>[] graph= new ArrayList[V+1]; //간선들을 리스트로 저장하니까
		
		for(int i=1; i<=V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++)  {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			
			graph[a].add(new Edge(b, cost));
			graph[b].add(new Edge(a, cost));
			
			
		}
		int total = prim(graph);
		
		
		System.out.println(total);
	}//main

	
	private static int prim(List<Edge>[] graph) {
		int total =0;
		PriorityQueue<Edge>  pq = new PriorityQueue<>();
		boolean visited[] = new boolean [V+1];
		
		pq.add(new Edge(1, 0));
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			int currNode = edge.to;
			int cost = edge.cost;
			
			if(visited[currNode]) {
				continue;
			}
			
			
			total+= cost;
			visited[currNode] = true;
			
			
			for(Edge e: graph[currNode]) {
				if(!visited[e.to]) {
					pq.add(e);
				}
			}
			
		}
		
		return total;
		
	}
	
	
	


}
