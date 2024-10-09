import java.io.*;
import java.util.*;

public class Main {
	static int N, M; // 정점의 개수, 간선의 개수
	static List<Integer>[] adjList; // 인접 리스트
	static boolean[] dfsvisited; // 방문 여부 체크
	static boolean result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 개수

		adjList = new ArrayList[N]; // 인접 리스트 생성
		dfsvisited = new boolean[N]; // 방문 여부 배열

		// 인접 리스트 초기화
		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<>();
		}

		// 간선 정보 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			adjList[A].add(B); // 인접 리스트에 간선 추가
			adjList[B].add(A); // 무향 그래프이므로 반대 방향도 추가
		}

		for (int i = 0; i < N; i++) {
			Collections.sort(adjList[i]);
		}
		for(int i=0;i<N;i++) {
			dfs(i,1);
			if(result) {
				break;
			}
		}
		if(result) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
	}

	// DFS 함수
	static void dfs(int V,int count) {
		if (result) {
			return;
		}
		if(count==5) {
			result=true;
			return;
		}
		dfsvisited[V] = true; // 현재 정점 방문 처리
		for (int neighbor : adjList[V]) {
            if (!dfsvisited[neighbor]) {
                dfs(neighbor,count+1);
            }
        }
		dfsvisited[V]=false; // 백트래킹
	}
}
