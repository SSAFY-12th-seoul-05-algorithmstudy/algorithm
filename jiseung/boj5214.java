import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<List<Integer>> nodeAdjList = new ArrayList<>(); 
        List<List<Integer>> tubeAdjList = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            nodeAdjList.add(new ArrayList<>());
        }
        for (int i = 0; i < K; i++) {
            tubeAdjList.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int node = Integer.parseInt(st.nextToken());
                nodeAdjList.get(node).add(i); 
                tubeAdjList.get(i).add(node); 
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] visitedNode = new boolean[N + 1];
        boolean[] visitedTube = new boolean[K];
        int result = -1;

        queue.add(new int[] {1, 1});
        visitedNode[1] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int distance = current[1];

            if (node == N) {
                result = distance;
                break;
            }

            for (int tube : nodeAdjList.get(node)) {
                if (visitedTube[tube]) continue;
                visitedTube[tube] = true;

                for (int nextNode : tubeAdjList.get(tube)) {
                    if (!visitedNode[nextNode]) {
                        queue.add(new int[] {nextNode, distance + 1});
                        visitedNode[nextNode] = true;
                    }
                }
            }
        }

        System.out.println(result);
    }
}