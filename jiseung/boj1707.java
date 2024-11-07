import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<ArrayList<Integer>> adjList;
	static int[] color;
	static boolean bipartite;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());

			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			adjList = new ArrayList<>();
            color = new int[V + 1]; // 각 정점의 색을 구분
            bipartite = true; // 초기: 이분 그래프이다.
			
            for(int i=0;i<=V;i++) {
            	adjList.add(new ArrayList<>());
            	color[i]=0;
            }
            
            
			for(int i=0;i<E;i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				
				adjList.get(v1).add(v2);
				adjList.get(v2).add(v1);
			}
			
			for(int i=1;i<=V;i++) {
				if(!bipartite) {
					break;
				}
				if(color[i]==0) {
					bfs(i,1);
				}
			}
			
			if(bipartite) {
				sb.append("YES\n");
			}
			else {
				sb.append("NO\n");
			}
		}
		System.out.println(sb);
	}
	static void bfs(int start,int nextColor) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(start);
		color[start]=nextColor;
		
		while(!queue.isEmpty()) {
			int v = queue.poll();
			for(int adjV : adjList.get(v)) {
				if(color[adjV]==0) {
					queue.offer(adjV);
					color[adjV]= -color[v];
				}
				else if(color[v]+color[adjV]!=0) {
					bipartite=false;
					return;
				}
			}
		}
	}
}