import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 이분그래프 {
	
	static int visited[];
	static int V, E;
	static boolean isgraph;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		
		
		
		for(int i=0; i<K; i++) {
			isgraph = true;
			 V = sc.nextInt();//정점 개수(1부터 시작)
			 E = sc.nextInt();//간선ㄱ ㅐ수
			 visited =  new int[V+1];
			 ArrayList<Integer>[] graph = new ArrayList[V+1];
			for(int j=1; j<=V; j++) {
				graph[j] = new ArrayList<>();
			}
			 
			for(int j=0; j<E; j++) {
				int num1 = sc.nextInt();
				int num2 = sc.nextInt();
				graph[num1].add(num2);
				graph[num2].add(num1);
			}
			
			for(int k=1; k<=V; k++) {
				if(visited[k]==0) {
					if(!bfs(graph, k)) {
						isgraph= false;
						break;
					}
				}
				
			}
			
			if(isgraph)
				System.out.println("YES");
			else 
				System.out.println("NO");
			
		}//k줄
	}//main
	
	
	static boolean bfs(ArrayList<Integer>[] graph, int num) {
		Queue<Integer> q = new LinkedList<>();
		q.add(num);
		visited[num]=1;
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for(int next: graph[curr]) {
				if(visited[next]==0) {
					visited[next] =(visited[curr]==1)? 2:1; 
					q.add(next);
				}else if(visited[next]==visited[curr]) {
					return false;
				}
			}
		}
		
		return true;
		
	}

}
