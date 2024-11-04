import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj1967 {
	
	static class Node {
		int num;
		int cost;
		
		public Node(int num, int cost) {
			this.num = num;//번호
			this.cost = cost;//가중치
		}
		
		
	}
	
	static boolean visited[];
	static int sum;
	static List<Node>[] tree;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());//노드 ㅅ서
		
		tree = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			tree[i] = new ArrayList<>();
		}//트리 초기화
		
		
		for(int i=1; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			
			tree[start].add(new Node(end, cost));
			tree[end].add(new Node(start, cost));//무망향인까
		}
		sum =0;
		
		for(int i=1; i<=N; i++) {
			visited = new boolean[N+1];
			visited[i] = true;
			dfs(i,0);
		}
		
		System.out.println(sum);
		
	}//main
	
	
	static void dfs(int num, int s) {
		
		for(Node node: tree[num]) {
			if(!visited[node.num]) {
				visited[node.num] = true;
				dfs(node.num, s+node.cost);
			}
		}
		
		sum = sum<s? s: sum;
	}


}
