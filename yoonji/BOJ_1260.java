import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_1260 {
	static int N,M,V;
	static int [][] graph;
	static boolean[] visited;
	static List<Integer> seq = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 정점 개수
		M = sc.nextInt(); // 간선 개수
		V = sc.nextInt(); // 시작할 정점 번호
		graph = new int[N+1][N+1]; // 정점 1부터 시작하므로
		
		for(int m=0; m<M; m++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			graph[A][B] = graph[B][A] = 1; // 양방향이므로
		}
		
		// dfs : 깊이우선탐색, stack
		dfs(V);
		for(int i=0; i<seq.size(); i++) {
			System.out.printf("%d ", seq.get(i));
		}
		System.out.println();
		
		seq.clear(); // 리스트 비워주기
		
		// bfs : 너비우선탐색, queue
		bfs(V);
		for(int i=0; i<seq.size(); i++) {
			System.out.printf("%d ", seq.get(i));
		}
		
		
	}//main

	private static void bfs(int v) {
		// 방문 초기화
		visited = new boolean[N+1];
		
		Queue<Integer> queue = new ArrayDeque<>();
		
		// 1. 시작 정점을 queue에 넣어준다
		queue.add(v);
		
		// 2. 큐가 빌때까지 반복
		while(!queue.isEmpty()) {
			// 큐 값 꺼내서 확인
			int node = queue.poll();
			// 이미 방문했으면 건너띈다
			if(visited[node]) continue;
			
			// 방문체크
			visited[node] = true;
			// 리스트 삽입
			seq.add(node);
			
			// 열 순회
			for(int i=1; i<N+1; i++) {
				// 아직 방문하지 않았고 node와 연결되어 있는 것
				if(!visited[i] && graph[node][i] == 1) {
					// 순서대로 전부 넣어준다
					queue.add(i);
				}
			}
		}
		
	}

	private static void dfs(int v) {
		// 방문 초기화
		visited = new boolean[N+1];
		
		Stack<Integer> stack = new Stack<>();
		
		// 1. 시작 정점을 스택에 넣어준다
		stack.add(v);
		
		// 2. 스택이 빌때까지
		while(!stack.isEmpty()) {
			// 스택 값 꺼내서 확인
			int node = stack.pop();
			// 이미 방문한 곳이면 넘겨
			if(visited[node]) continue;
			
			// 방문체크
			visited[node] = true;
			// list 삽입 (먼저 방문한 노드 순으로 들어간다)
			seq.add(node);
			
			// 열 순회
			for(int i=N; i>=1; i--) {
				// 아직 방문하지 않았고 node와 연결되어있는 것
				if(!visited[i] && graph[node][i] == 1) {
					// 스택에 넣어준다
					stack.push(i);
				}
			}
		} //while
	} // dfs
} // class		
