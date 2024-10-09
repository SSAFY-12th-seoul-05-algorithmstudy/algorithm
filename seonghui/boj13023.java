import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj13023 {
	static int n,m;
	static List<Integer>[] adj;
	static boolean[] visited;
	static boolean found;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		adj = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			adj[i] = new ArrayList<>();
		}
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adj[a].add(b);
			adj[b].add(a);
		}
		visited = new boolean[n];
		found = false;
		
		for(int i = 0; i < n; i++) {
			if(!found) {
				dfs(i,1);
			}
			
		}
		
		System.out.println(found?1:0);
	}
	
	static void dfs(int v, int depth) {
		
		visited[v] = true;
		
		if(depth == 5) {
			found = true;
			return;
		}
		
		for(int next : adj[v]) {
			if(!visited[next]) {
				dfs(next, depth+1);
				if(found) return;
			}
		}
		
		visited[v] = false;
	}

}
