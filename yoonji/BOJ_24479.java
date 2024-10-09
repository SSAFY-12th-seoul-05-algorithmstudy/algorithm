import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_24479 {
	static int N,M,R;
	static int[] visited;
	static List<Integer>[] graph;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정점 수
		M = sc.nextInt(); // 간선 수
		R = sc.nextInt(); // 시작 정점
		visited = new int[N+1];
		graph = new ArrayList[N+1]; // 정점 1부터 시작하므로
		
		for(int i=1; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			graph[A].add(B);
			graph[B].add(A);
		} // 입력 완료
		
		dfs(R);
		
		for(int i=1; i<N+1; i++) {
			System.out.println(visited[i]);
		}
		
	} // main

	private static void dfs(int r) {
		
		int cnt = 1;
		Stack<Integer> stack = new Stack<>();
		
		stack.push(r);
		
		while(!stack.isEmpty()) {
			// 스택 값 꺼내서 확인
			int node = stack.pop();
			// 이미 방문했던 곳이면 넘어가
			if(visited[node] != 0) continue;
			
			// 방문 안했으면
			// 방문 표시 남기고 cnt 커지게
			visited[node] = cnt;
			cnt++;
			
			int[] arr = new int[graph[node].size()];
			// 주변 노드 확인
			for(int i=0; i<graph[node].size(); i++) {
				arr[i] = graph[node].get(i);
			}
			
			Arrays.sort(arr);
			for(int i=arr.length-1; i>=0; i--) { // 작은 값이 가장 마지막에 들어가야하므로
				// 스택에 넣어줄 값 = 아직 방문안했고, 노드와 관련있는 값(리스트에 들어있다는 것만으로도 이미 관련있다는 뜻)
				int nextNode = arr[i];
				if(visited[nextNode] == 0) {
					stack.push(nextNode);
				}
			}
		} // while
	}
	
} // class		
