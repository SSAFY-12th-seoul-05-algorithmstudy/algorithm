import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj1197 {
	static int V, E;
	static int[] parents;
	static ArrayList<Node> nodeList;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		V = sc.nextInt();
		E = sc.nextInt();

		parents = new int[V + 1];
		nodeList = new ArrayList<>();

		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();
			nodeList.add(new Node(from, to, cost));
		}
		// 간선을 작은 순부터 해라
		Collections.sort(nodeList);
		
		
		//부모를 나로 만들고 시작해 
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
		
		int sum = 0;
		int cnt = 0;
		
		// 작은 간선부터 시작을 해보는거야 
		for (Node n : nodeList) {
			
			if (union(n.from, n.to)) {
				sum += n.cost;
				cnt++;

				if (cnt == E - 1)
					break;
			}
		}

		System.out.println(sum);
	}

	private static boolean union(int from, int to) {

		int fromRoot = findSet(from);
		int toRoot = findSet(to);
		if (fromRoot == toRoot)
			return false;
		else
			parents[toRoot] = fromRoot;
		return true;
	}

	private static int findSet(int v) {
		if (parents[v] == v)
			return v;
	
		else
			return parents[v] = findSet(parents[v]);
	}

	static class Node implements Comparable<Node> {
		int from;
		int to;
		int cost;

		public Node(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
}