package 알고리즘;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class boj1707 {

    static int V;
    static List<List<Integer>> graph;
    static int[] color;
    static String answer;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 0; tc < T; tc++) {
            V = sc.nextInt();
            int E = sc.nextInt();
            answer = "YES";
            graph = new ArrayList<>();
            color = new int[V+1];

            for (int i = 0; i <= V; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                int A = sc.nextInt();
                int B = sc.nextInt();

                graph.get(A).add(B);
                graph.get(B).add(A);
            }
            
         bfs();

            System.out.println(answer);
        }
    }
    public static void bfs() {
    	
    	Queue<Integer> queue = new LinkedList<>();
    	queue.add(1);
    	
    	
    	for(int i=1; i<=V ;i++) {
    		
    		if(queue.isEmpty()) {
    			for(int j=2; j<=V ;j++) {
    				if(color[j]==0) {
    					queue.add(j);
    					break;
    				}
    			}
    			
    		}
    		
    		int now = queue.poll();
    		if(color[now]==0) color[now]=1;
    		
        	for(int a : graph.get(now)) {

        		if(color[a]==color[now]) {
        			answer ="NO";
        			return;
        		}
        		
        		if(color[a]==0 &&color[now]==1 ) {
        			color[a]=2;
        			queue.add(a);
        		}
        		else if(color[a]==0 &&color[now]==2) {
        			color[a]=1;
        			queue.add(a);
        		}

        	}
        }
    }

  
}
