import java.io.*;
import java.util.*;

public class Main {
	static boolean[][] visited;
	static int[] start, end;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				if (str.charAt(j) - '0' == 0) {
					visited[i][j] = true;
				}
			}
		}
		start = new int[] { 0, 0 };
		end = new int[] { N - 1, M - 1 };
		bfs(start);
	}

	static void bfs(int[] start) {
		Queue<Integer[]> queue = new ArrayDeque<>();
		
		// 방문 체크
		queue.offer(new Integer[] { start[0], start[1],1 });
		visited[start[0]][start[1]] = true;
		// 델타를 순회하며
		while (!queue.isEmpty()) {
			Integer[] current = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nextr = current[0]+dr[d];
				int nextc = current[1]+dc[d];
				int nextstep = current[2]+1;
				if (nextr >= N || nextr < 0 || nextc >= M || nextc < 0
						|| visited[nextr][nextc]) {
					continue;
				}
				if (nextr==end[0] && nextc==end[1]) {
					System.out.println(nextstep);
				}
				queue.add(new Integer[] {nextr,nextc,nextstep});
				visited[nextr][nextc]=true;
			}
		}

	}
}