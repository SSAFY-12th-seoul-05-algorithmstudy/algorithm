import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_2617 {
	static int N, M;
    static int[] compare;
    static ArrayList<int[]>[] arr;
    static boolean[][] visited;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        
        arr = new ArrayList[N+1];
        
        for(int i=0 ; i<=N ; i++) {
            
            arr[i] = new ArrayList<>();
        }
        
        for(int i=0 ; i<M ; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            arr[a].add(new int[] {b,0});
            arr[b].add(new int[] {a,1});
        }
        
        
        int ans = 0;
        for(int i=1 ; i<=N ; i++) {
        	compare = new int[2];
            
            visited = new boolean[N+1][2];
            visited[i][0] = true;
            visited[i][1] = true;
            
            for(int[] node : arr[i]) {
            	if(node[1]==1 && !visited[node[0]][1]) {
                	visited[node[0]][1] = true;
                    compare[1]++;
                    dfs(node);
                    
                } else if(node[1]==0 && !visited[node[0]][0]) {
                	visited[node[0]][0] = true;
                	compare[0]++;
                    dfs(node);
                }
            }
            
            if(compare[0]>N/2 || compare[1]>N/2) ans++;
        }
        
        System.out.println(ans);
        
    }
    
    static void dfs(int[] node) {
    	for(int[] next : arr[node[0]]) {
            if(next[1]==node[1] && !visited[next[0]][node[1]]) {
            	visited[next[0]][node[1]] = true;
            	compare[node[1]]++;
            	if(compare[node[1]]>N/2) return;
                dfs(next);
            }
            
        }
    }
}
