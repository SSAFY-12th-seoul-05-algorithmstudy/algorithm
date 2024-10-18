import java.util.HashMap;
import java.util.Scanner;

public class BOJ_20166 {
	static int N, M, K;
	static String[][] world;
	static String[] words;
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,1,1,1,0,-1,-1,-1};
	static HashMap<String, Integer> dic;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		world = new String[N][];
		
		for(int i=0 ; i<N ; i++) {
			world[i] = sc.next().split("");
		}
		
		words = new String[K];
		dic = new HashMap<>();
		
		for(int i=0 ; i<K ; i++) {
			words[i] = sc.next();
			dic.put(words[i], 0);
		}
		
		
		for(int r=0 ; r<N ; r++) {
			for(int c=0 ; c<M ; c++) {
				dfs(r,c,world[r][c]);
			}
		}
		
		for(int i=0 ; i<K ; i++) {
			System.out.println(dic.get(words[i]));
		}
	}
	
	static void dfs(int r, int c, String s) {
		if(s.length()>5) {
				return;
			}
		if(dic.containsKey(s)) {
			dic.put(s, dic.get(s)+1);
		}
		
		for(int d=0 ; d<8 ; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			dfs((N+nr)%N,(M+nc)%M,s+world[(N+nr)%N][(M+nc)%M]);
		}
	}
}
