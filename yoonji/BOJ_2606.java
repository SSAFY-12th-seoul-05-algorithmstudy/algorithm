import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_2606 {
	static int N,M;
	static boolean[] visited;
	static List<Integer>[] graph;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정점 수
		M = sc.nextInt(); // 간선 수
		visited = new boolean[N+1];
		graph = new ArrayList[N+1]; // 정점 1부터 시작
		
		for(int i=1; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			graph[A].add(B);
			graph[B].add(A);
		} // 입력 완료
		
		dfs(1);
		int cnt = 0;
		for(int i=2; i<N+1; i++) { // 1번컴퓨터 제외해야하므로
			if(visited[i]) {
				cnt++;
			}
		}
		System.out.println(cnt);
		
	} // main

	private static void dfs(int r) {
		
		Stack<Integer> stack = new Stack<>();
		
		stack.push(r);
		
		while(!stack.isEmpty()) {
			// 노드 꺼내서 확인
			int node = stack.pop();
			// 방문체크
			visited[node] = true;
			
			// node의 인접 노드를 확인한다
			for(int i=0; i<graph[node].size(); i++) {
				int neighbor = graph[node].get(i);
				// 인접노드가 아직 방문체크 안되어있으면 스택에 넣어준다
				if(!visited[neighbor])
					stack.push(neighbor);
			}
			
		}//while
	}// dfs
	
} // class		
