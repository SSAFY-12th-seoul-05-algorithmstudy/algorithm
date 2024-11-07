import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node> {
        int end;
        int w;

        Node(int end, int w) {
            this.end = end;
            this.w = w;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.w, other.w);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Node>[] list = new ArrayList[N + 1];
        boolean[] visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, w));
            list[end].add(new Node(start, w));

        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        int result = 0;
        int max = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int end = now.end;
            int w = now.w;

            if (visited[end]) continue;

            result += w;
            max = Math.max(max, w);
            visited[end] = true;

            for (Node node : list[end]) {
                if (!visited[node.end]) {
                    pq.add(node);
                }
            }
        }

        System.out.println(result-max);
    }
}
