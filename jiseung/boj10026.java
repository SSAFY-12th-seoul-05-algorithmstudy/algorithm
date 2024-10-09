import java.io.*;
import java.util.*;

public class Main {
	static Character[][] grid;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static boolean[][] visited,redgreenvisited;
	static int N;
	static int normalcount=0;
	static int redgreencount=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        grid = new Character[N][N];
        visited = new boolean[N][N];
        redgreenvisited = new boolean[N][N];
        for(int i=0;i<N;i++) {
        	String str = br.readLine();
        	for(int j=0;j<N;j++){
        		grid[i][j]=str.charAt(j);
        	}
        }
        for(int i=0;i<N;i++) {
        	for(int j=0;j<N;j++) {
        		if(!visited[i][j]) {
        			normalBFS(i,j);
        		}
        		if(!redgreenvisited[i][j]) {
        			redgreenBFS(i,j);
        		}
        	}
        }
        System.out.println(normalcount+" "+redgreencount);
    }
    
    static void normalBFS(int r,int c) {
    	visited[r][c]=true;
    	Queue<int[]> queue = new ArrayDeque<>();
    	queue.offer(new int[] {r,c});
    	while(!queue.isEmpty()) {
    		int[] current = queue.poll();
    		Character currentchar = grid[current[0]][current[1]];
    		for(int i=0;i<dr.length;i++) {
    			int nextr = current[0] +dr[i];
    			int nextc = current[1] +dc[i];
    			if(nextr>=0 && nextr<N && nextc >=0 && nextc <N && !visited[nextr][nextc] && grid[nextr][nextc]==currentchar) {
    				queue.offer(new int[] {nextr, nextc});
    				visited[nextr][nextc]=true;
    			}
    		}
    	}
    	normalcount++;
    }
    
    static void redgreenBFS(int r,int c) {
    	redgreenvisited[r][c]=true;
    	Queue<int[]> queue = new ArrayDeque<>();
    	queue.offer(new int[] {r,c});
    	while(!queue.isEmpty()) {
    		int[] current = queue.poll();
    		Character currentchar = grid[current[0]][current[1]];
    		if(currentchar=='R'||currentchar=='G') {
    			for(int i=0;i<dr.length;i++) {
    				int nextr = current[0] +dr[i];
    				int nextc = current[1] +dc[i];
    				if(nextr>=0 && nextr<N && nextc >=0 && nextc <N && !redgreenvisited[nextr][nextc] && grid[nextr][nextc]!='B') {
    					queue.offer(new int[] {nextr, nextc});
    					redgreenvisited[nextr][nextc]=true;
    				}
    			}
    		}
    		else {
    			for(int i=0;i<dr.length;i++) {
    				int nextr = current[0] +dr[i];
    				int nextc = current[1] +dc[i];
    				if(nextr>=0 && nextr<N && nextc >=0 && nextc <N && !redgreenvisited[nextr][nextc] && grid[nextr][nextc]==currentchar) {
    					queue.offer(new int[] {nextr, nextc});
    					redgreenvisited[nextr][nextc]=true;
    				}
    			}
    		}
    	}
    	redgreencount++;
    }
}