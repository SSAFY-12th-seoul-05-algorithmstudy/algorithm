package firstWeekInSep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class dfs2 {

	static boolean[] visited;
    static List<Integer>[] graph;
    static int N, M, R;
    static int[] arr;
    static int order;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];
        arr = new int[N + 1];
        order = 1;

        // Initialize adjacency list
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // Read edges and populate adjacency list
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[r].add(c);
            graph[c].add(r);
        }

        // Sort adjacency list to ensure consistent order of traversal
        for (int i = 1; i <= N; i++) {
            graph[i].sort(null);
        }

        // DFS
        dfs(R);

        // Output the result
        for (int i = 1; i <= N; i++) {
            System.out.println(arr[i]);
        }
    }

    static void dfs(int start) {
        visited[start] = true;
        arr[start] = order++;
        
        for (int next : graph[start]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
