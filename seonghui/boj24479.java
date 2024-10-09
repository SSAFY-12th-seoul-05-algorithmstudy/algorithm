import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class boj24479 {
	static int n,m,r;
	static List<Integer>[] adj; 
	static boolean[] visited; // 무향 -> 방문쳌
	static int[] res; // 방문 순서 배열 -> 방문x는 0으로 그대로 출력
	static int currOrder;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력받기
		n = sc.nextInt(); // 정점의 수
		m = sc.nextInt(); // 간선의 수
		r = sc.nextInt(); // 시작 정점
		
		adj = new ArrayList[n+1]; // 인접 리스트 배열 초기화
		for(int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<>(); // 각 정점을 리스트로 초기화
		}
		
		for(int i = 0; i < m; i++) {
			int from = sc.nextInt(); 
			int to = sc.nextInt(); 
			adj[from].add(to);
			adj[to].add(from);
		}
		// 인접 정점은 오름차순으로 방문
		for(int i = 1; i <= n; i++) {
			Collections.sort(adj[i]);
		}
		
		visited = new boolean[n+1];
		res = new int[n+1];
		currOrder = 1;
		dfs(r);
		
		// 결과 출력
		for(int i = 1; i <= n; i++) {
			System.out.println(res[i]);
		}
			
		
	}// tc
	
	static void dfs(int r) {
		visited[r] = true;
		res[r] = currOrder++;
		
		for(int x : adj[r]) {
			if(!visited[x]) {
				dfs(x);
			}
		}
	}
}
