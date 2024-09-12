import java.io.*;
import java.util.*;

public class Main {
    static int N, M; // 정점의 개수, 간선의 개수
    static List<Integer>[] adjList; // 인접 리스트
    static boolean[] dfsvisited; // 방문 여부 체크
    static int[] order; // 방문 순서 기록
    static int visitCount = 0; // 방문 순서 카운터

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        M = Integer.parseInt(st.nextToken()); // 간선의 개수
        int V = Integer.parseInt(st.nextToken()); // 시작 정점

        adjList = new ArrayList[N + 1]; // 인접 리스트 생성
        dfsvisited = new boolean[N + 1]; // 방문 여부 배열
        order = new int[N + 1]; // 방문 순서 기록 배열

        // 인접 리스트 초기화
        for (int i = 1; i <= N; i++) {
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
        
        for(int i=1;i<N+1;i++) {
        	Collections.sort(adjList[i]);
        }
        // DFS 수행
        dfs(V);

        // 각 정점의 방문 순서 출력 (방문하지 않은 노드는 0)
        for (int i = 1; i <= N; i++) {
            System.out.println(order[i]);
        }
    }

    // DFS 함수
    static void dfs(int V) {
        dfsvisited[V] = true; // 현재 정점 방문 처리
        visitCount++;
        order[V] = visitCount; // 방문 순서를 기록

        // 인접한 정점 중에서 방문하지 않은 정점 방문
        for (int neighbor : adjList[V]) {
            if (!dfsvisited[neighbor]) {
                dfs(neighbor);
            }
        }
    }
}
