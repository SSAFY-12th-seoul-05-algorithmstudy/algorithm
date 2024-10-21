import java.io.*;
import java.util.*;

public class Main {
	static int N,M,max;
	static int[] dr = {0,1,0,-1,1,1,-1,-1};
	static int[] dc = {1,0,-1,0,1,-1,1,-1};
	static Map<String,Integer> map;
	static char[][] world;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		world = new char[N][M];
		map = new HashMap<>();
		
		String[] stringArray = new String[K];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				world[i][j] = str.charAt(j);
			}
		}
		
		
		for(int i=0;i<K;i++) {
			String next = br.readLine();
			map.put(next, 0);
			stringArray[i]=next;
			max = Math.max(max, next.length());
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				DFS(i,j,""+world[i][j]);
			}
		}
		
		for(String key: stringArray) {
			sb.append(map.get(key)).append("\n");
		}
		
		System.out.println(sb);
    }
	
	static void DFS(int r, int c,String word) {
		if(map.containsKey(word)) {
			map.put(word, map.get(word) + 1);
		}
		
		if(word.length()==max) {
			return;
		}
		for(int d=0;d<8;d++) {
			int nextr = (r+dr[d]+N)%N;
			int nextc = (c+dc[d]+M)%M;
			DFS(nextr,nextc,word+world[nextr][nextc]); 
		}
	}
}