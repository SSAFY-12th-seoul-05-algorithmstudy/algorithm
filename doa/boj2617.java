package 알고리즘;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class boj2617 {

    static int V;
    //가벼운게 0 무거운게 1
    static List<List<Integer>> lighter;
    static List<List<Integer>> heavyer;
    static int[] color;
    static String answer;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

            V = sc.nextInt();
            int E = sc.nextInt();
            lighter = new ArrayList<>();
            heavyer = new ArrayList<>();
            // Initialize the adjacency list
            
            int standard = V/2;
            
            for (int i = 0; i <= V; i++) {
                lighter.add(new ArrayList<>());
                heavyer.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int A = sc.nextInt();
                int B = sc.nextInt();
                
                lighter.get(A).add(B);
                heavyer.get(B).add(A);
                //나보다 가벼운 애를 담기
              
            }
            
        	 
         int answer =0;
    for(int i=1 ; i<=V; i++) {
    	
    	// i보다 가벼운 애들을 담기
    	if(bfs(i, lighter)>standard) answer ++;
    	if(bfs(i, heavyer)>standard) answer ++;
    	//i보다 무거운 애들의 수를 담기
    }
            
            System.out.println(answer);
        }
    
    public static int bfs(int i, List<List<Integer>> list) {
    	
    	int count=0;
    	Queue<Integer> queue = new LinkedList<>();
    	boolean visited[] = new boolean[V+1];
    	visited[i]=true;
    	queue.add(i);
    	
    		while(!queue.isEmpty()) {
    			int now = queue.poll();
    			
    				for(int  a : list.get(now)) {
    					if(!visited[a]) {
    						queue.add(a);
    						count++;
    						visited[a]=true;
    					}
    					}
    					
    				}

    			return count;
    	
        	}
  
}
