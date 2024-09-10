import java.io.*;
import java.util.*;

public class Main {
	static char[][] map;
	static boolean[] visited;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int R, C, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[26];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		result=0;
		dfs(0,0,1);
		System.out.println(result);
	}

	public static void dfs(int r, int c,int count) {
		if(visited[map[r][c]-'A']) {
			return;
		}
		visited[map[r][c]-'A']=true;
		result=Math.max(result, count);
		for (int d = 0; d < 4; d++) {
            int nextr = r + dr[d];
            int nextc = c + dc[d];
            if (nextr>=0 && nextr<R && nextc >=0 && nextc<C) {
            	dfs(nextr, nextc,count+1);
            }
        }
		visited[map[r][c]-'A']=false;
	}

}
