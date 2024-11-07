import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1707_BipartiteGraph {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            
            // LinkedList -> ArrayList로 변경
            List<List<Integer>> adjList = new ArrayList<>();
            
            for (int i = 0; i <= V; i++) {
                adjList.add(new ArrayList<>());
            }
            
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adjList.get(a).add(b);
                adjList.get(b).add(a);
            }
            
            Queue<Integer> queue = new LinkedList<>();
            int[] colors = new int[V + 1];
            boolean flag = false;
            
            out: for (int i = 1; i <= V; i++) {
                if (colors[i] == 0) {
                    colors[i] = 1;
                    queue.add(i);
                    
                    while (!queue.isEmpty()) {
                        int tmp = queue.poll();
                        
                        for (int vertex : adjList.get(tmp)) {
                            if (colors[vertex] == 0) {
                                colors[vertex] = -colors[tmp];
                                queue.add(vertex);
                            } else if (colors[vertex] == colors[tmp]) {
                                flag = true;
                                break out;
                            }
                        }
                    }
                }
            }
            
            // println 대신 StringBuilder 사용
            sb.append(flag ? "NO" : "YES").append("\n");
        }
        
        // 한 번에 출력
        System.out.print(sb);
    }
}