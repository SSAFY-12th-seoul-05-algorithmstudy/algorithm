import java.io.*;
import java.util.*;

public class Main {
	static int N,M; // 정점의 갯수, 간선의 갯수
	static int[][] dfsadj; // 인접행렬
	static List<Integer>[] bfsadj;
	static boolean[] dfsvisited,bfsvisited; // 방문쳌

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 개수
		int V = Integer.parseInt(st.nextToken());

		dfsadj = new int[N+1][N+1];
		dfsvisited = new boolean[N+1];
		bfsadj = new ArrayList[N+1]; // 시작 정점의 번호가 1번부터 시작한다.
		bfsvisited = new boolean[N+1]; // 방문체크 초기화
		for (int i = 1; i <= N; i++) {
			bfsadj[i] = new ArrayList<>();
		}
		// 간선 정보
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			dfsadj[A][B] = dfsadj[B][A] = 1; // 무향
			bfsadj[A].add(B);
			bfsadj[B].add(A); //무향이니까
		}
		
		dfs(V);
		System.out.println();
        for (int i = 1; i <= N; i++) {
            Collections.sort(bfsadj[i]);
        }

		bfs(V);
	}

	// v : 현재 내가 있는 정점
	static void dfs(int V) {
		dfsvisited[V] = true;
		System.out.print(V+" ");

		// 나와 인접하면서 방문하지 않은 정점을 방문하겠다.
		for (int i = 1; i <= N; i++) {
			// 방문한적 인접
			if (!dfsvisited[i] && dfsadj[V][i] == 1) {
				dfs(i);
			}
		}
	}
	static void bfs(int V) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(V); //시작정점을 큐에 넣는다.
		bfsvisited[V] = true; //시작 정점을 방문쳌 
		
		while(!q.isEmpty()) {
			int curr = q.poll(); 
			System.out.print(curr+" "); 
			
			for(int w : bfsadj[curr]) {
				if(!bfsvisited[w]) {
					q.add(w);
					bfsvisited[w] = true;
				}
			}
		}
	}
}