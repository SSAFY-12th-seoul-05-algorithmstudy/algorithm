import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class boj1197 {

	static int[] parents;
	static List<graph> graphs ;
	static int E;
	
	static class graph implements Comparable<graph>{
		int one, two, weight;

		public graph(int one, int two, int weight) {
			super();
			this.one = one;
			this.two = two;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(graph o) {
			// TODO Auto-generated method stub
			return this.weight-o.weight;
		}
		
	}
	static int answer=0; 
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
	
		int V = sc.nextInt();
		E = sc.nextInt();
		
		graphs = new ArrayList<>();
		parents = new int[V+1];
		
		
		for(int i=1; i<V+1 ; i++) {
			parents[i]=i;
					
		}
		
		for(int i=0; i<E ; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int w = sc.nextInt();
			graphs.add(new graph(A,B,w));
					
		}
		
		Collections.sort(graphs);
		goGraph();
		
		System.out.println(answer);
		
		
	}
	public static void goGraph() {
		
		for(int i=0 ;i<E; i++ ) {
			if(find(graphs.get(i).one)!=find(graphs.get(i).two)) {
				answer +=graphs.get(i).weight;
				union(graphs.get(i).one, graphs.get(i).two);
			}
		}
		
	}
	
	
	public static int find(int x) {
		if(parents[x]==x) return x;
		return parents[x]=find(parents[x]);
	}
	
	

	public static void union(int i, int j) {
		i=find(i);
		j=find(j);
		if(i!=j) parents[i]= parents[j];
	}
	
}