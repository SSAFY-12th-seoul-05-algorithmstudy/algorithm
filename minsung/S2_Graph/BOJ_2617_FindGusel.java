import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2617_FindGusel {
    static List<List<Integer>> leAdjList = new ArrayList<>();
    static List<List<Integer>> grAdjList = new ArrayList<>();
    static int V, E;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i <= V; i++) {
            grAdjList.add(new ArrayList<>());
            leAdjList.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            grAdjList.get(b).add(a);
            leAdjList.get(a).add(b);
        }

        int mid = (V + 1) / 2;
        int ans = 0;
        int bigger, less;
        
        for (int i = 1; i <= V; i++) {
            less = bfs(i, leAdjList);
            bigger = bfs(i, grAdjList);
            if (bigger >= mid || less >= mid)
                ans++;
        }

        System.out.println(ans);
    }

    static int bfs(int start, List<List<Integer>> adjList) {
        boolean[] visited = new boolean[V + 1];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int i : adjList.get(curr)) {
                if (!visited[i]) {
                    visited[i] = true;
                    count++;
                    queue.offer(i); 
                }
            }
        }

		return count;
	}
}