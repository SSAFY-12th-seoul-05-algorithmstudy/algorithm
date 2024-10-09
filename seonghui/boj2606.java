import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class boj2606 {
	static int n,m;
	static List<Integer>[] adj;
	static boolean[] visited;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); // 컴퓨터 수
		m = sc.nextInt(); // 간선 수
		
		adj = new ArrayList[n+1];
		for(int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adj[from].add(to);
			adj[to].add(from);
		}
		
		visited = new boolean[n+1];
		cnt = 0;
		dfs(1); // 1번 컴퓨터 시작
		System.out.println(cnt);
	}
	
	static void dfs(int v) {
		visited[v] = true;
		
		for(int next : adj[v]) {
			if(!visited[next]) {
				cnt++; // 방문 컴퓨터 수 카운트
				dfs(next);
			}
		}
	}
}
