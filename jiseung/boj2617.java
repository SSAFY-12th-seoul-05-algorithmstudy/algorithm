import java.io.*;
import java.util.*;

public class Main {
	static int[][] adj;
	static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        adj = new int[N + 1][N + 1];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a][b] = 1;
        }
        
        int result = 0;
        int limit = N / 2 + 1;
        
        for (int i = 1; i <= N; i++) {
            int heavyCount = bfs(i, true);
            int lightCount = bfs(i, false);
            if (heavyCount >= limit || lightCount >= limit) {
                result++;
            }
        }
        
        System.out.println(result);
    }

    private static int bfs(int start, boolean heavier) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        queue.offer(start);
        visited[start] = true;
        int count = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next = 1; next <= N; next++) {
                if (heavier && adj[next][current] == 1 && !visited[next]) { // 무거운 구슬 찾기
                    visited[next] = true;
                    queue.offer(next);
                    count++;
                } else if (!heavier && adj[current][next] == 1 && !visited[next]) { // 가벼운 구슬 찾기
                    visited[next] = true;
                    queue.offer(next);
                    count++;
                }
            }
        }
        
        return count;
    }
}