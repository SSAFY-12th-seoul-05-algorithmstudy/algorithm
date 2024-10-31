import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class boj1707 {

    static List<List<Integer>> graph;
    static String answer;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int times = sc.nextInt();

        for(int t = 0 ; t < times; t++) {
            answer = "YES";
            int V = sc.nextInt();
            int E = sc.nextInt();
            graph = new ArrayList();
            for(int i = 0 ; i < V ; i++) {
                graph.add(new ArrayList<>());
            }

            for(int i = 0 ; i < E ; i++) {
                int p1 = sc.nextInt() - 1;
                int p2 = sc.nextInt() - 1;

                graph.get(p1).add(p2);
                graph.get(p2).add(p1);
            }
            set = new int[V];
            for(int i = 0 ; i < V ; i++) {
                if(set[i] == 0) {
                    if(!bfs(i)) break;
                }
            }
            System.out.println(answer);
        }
    }
    static int[] set;
    public static boolean bfs(int n) {
        Queue<Integer> que = new LinkedList<>();

        que.add(n);
        set[n] = 1;

        while(!que.isEmpty()) {
            n = que.poll();
            for(Integer i : graph.get(n)) {
                if(set[n] == set[i]) {
                    answer = "NO";
                    return false;
                }
                if(set[i] == 0) {
                    set[i] = set[n]* -1;
                    que.add(i);
                }
            }
        }
        return true;
    }
}
