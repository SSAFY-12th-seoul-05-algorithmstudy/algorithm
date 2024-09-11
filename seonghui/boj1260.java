import java.util.*;

public class boj1260 {
    static int N, M, start;
    static List<Integer>[] adj;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 정점의 개수
        M = sc.nextInt(); // 간선의 개수
        start = sc.nextInt(); // 시작 정점
        
        adj = new ArrayList[N + 1]; // 정점 1부터 시작함으로
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            adj[from].add(to);
            adj[to].add(from);
        }
        
        //단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문
        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
        }
        
        // DFS
        visited = new boolean[N + 1];
        dfs(start);
        System.out.println();
        
        // BFS
        visited = new boolean[N + 1];
        bfs(start);
    }
    
    static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");
        
        for (int next : adj[v]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
    
    static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");
            
            for (int next : adj[curr]) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
