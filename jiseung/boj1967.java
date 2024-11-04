import java.util.*;
import java.io.*;

public class Main {

    static class Edge {
        int num;
        int w;

        Edge(int num, int w) {
            this.num = num;
            this.w = w;
        }
    }

    static List<Edge>[] list;
    static boolean[] visited;
    static int maxDistance;
    static int farthestNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[start].add(new Edge(end, w));
            list[end].add(new Edge(start,w));
        }

        // Step 1: 임의의 노드(1번 노드)에서 가장 먼 노드를 찾음
        visited = new boolean[N + 1];
        maxDistance = 0;
        DFS(1, 0);

        // Step 2: 가장 먼 노드에서 다시 DFS를 수행하여 트리의 지름 구하기
        visited = new boolean[N + 1];
        maxDistance = 0;
        DFS(farthestNode, 0);

        System.out.println(maxDistance);
    }

    static void DFS(int num, int sum) {
        if (sum > maxDistance) {
            maxDistance = sum;
            farthestNode = num;
        }
        visited[num] = true;
        for (Edge edge : list[num]) {
            if (!visited[edge.num]) {
                DFS(edge.num, sum + edge.w);
            }
        }
    }
}