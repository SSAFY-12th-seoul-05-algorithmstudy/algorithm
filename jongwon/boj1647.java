import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class boj1647 {
	static int[] parents;
	static int n, m;
	static List<Node> arrayList;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arrayList = new ArrayList<>();
		parents = new int[n+1];
		for (int i = 0; i < m; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();
			arrayList.add(new Node(from,to,cost));
		}
		
		Collections.sort(arrayList);
		
		for(int i = 1 ; i <= n ; i++) {
			parents[i] = i;
		}
		
		int sum = 0; 
		int cnt = 0;
		int maxCost = 0; 
		//엄마가 같은지 찾아야지 
		for(Node node : arrayList) {
			if(!union(node.from,node.to)) continue;
			sum += node.cost;
			maxCost = Math.max(maxCost, node.cost);
			cnt++;
			if(cnt == n-1) break;
		}
		System.out.println(sum - maxCost);
	}

	static boolean union(int from, int to) {
		if(findSet(from) == findSet(to)) return false;
		parents[findSet(to)] = findSet(from);
		return true;
	}
	
	
	static int findSet(int v) {
		//만약 부모가 나라면 그냥 날 뱉어~
		if(parents[v] == v) return v;
		// 아니면 재귀적으로 들어가서 압축 셋팅 해줘~
		return parents[v] = findSet(parents[v]);
	}
}









class Node implements Comparable<Node> {
	int from;
	int to;
	int cost;

	public Node(int from, int to, int cost) {
		this.from = from;
		this.to = to;
		this.cost = cost;
	}

	public int compareTo(Node o) {
		return this.cost - o.cost;
	}

}

//원숭이 한 마리가 세상구경을 하고 있다.
//N개의 집과 M개의 길로 이루어져 있다.
