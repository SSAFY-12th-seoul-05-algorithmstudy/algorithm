import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static boolean visited[];
	
	public static void main(String[] args) {
		Scanner sc=  new Scanner(System.in);
		int N= sc.nextInt(); //총 사람 수 (1부터)(노드 번호)
		int M = sc.nextInt();//파티 수(간선 수)
		int K = sc.nextInt();//진실아는 사람 수
		
		visited = new boolean[N+1];
		ArrayList<Integer>[] graph = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		boolean[] knowT = new boolean[N+1];
		for(int i=0; i<K; i++) {
			int knowp = sc.nextInt();//아는 사람 번호
			knowT[knowp] = true;
		}
		
		
		ArrayList<Integer>[] parties = new ArrayList[M];
		for(int i=0; i<M; i++) {
			int partynum = sc.nextInt();//각 파티마다 오는 사람 수
			parties[i] = new ArrayList<>();
			for(int j=0; j<partynum; j++) {
				int p = sc.nextInt();
				parties[i].add(p); //각 파티에 오는사람들 추가
				
			}
			
			for(int j =0; j<parties[i].size(); j++) {
				for(int k=j+1; k<parties[i].size(); k++) {
					graph[parties[i].get(j)].add(parties[i].get(k));
					graph[parties[i].get(k)].add(parties[i].get(j));
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			if(knowT[i] && !visited[i]) {
				bfs(graph, i);
				
			}
		}
		
		int cnt =0;
		for(int i=0; i<M; i++) {
			boolean dontknow = true;
			for(int p :parties[i]) {
				if(visited[p])
					dontknow = false;
					break;
			}
			if(dontknow) {
				
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
		
	}//main
	
	static void bfs(ArrayList<Integer>[] graph, int num) {
		Queue<Integer>q = new LinkedList<>();
		q.add(num);
		visited[num] = true;
		
		while(!q.isEmpty()) {
			int curr =q.poll();//현재 사람
			for(int next: graph[curr]) { 
				if(!visited[next]) {
					visited[next] = true;
					q.add(next);
				}
			}
		}
		
	}

}
