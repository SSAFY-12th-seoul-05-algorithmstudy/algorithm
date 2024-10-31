import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static List<Marble>[] adjList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// 인접 리스트 추가
		adjList = new ArrayList[N + 1];
		for (int i = 1; i<=N; i++)
			adjList[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int heavy = Integer.parseInt(st.nextToken());
			int light = Integer.parseInt(st.nextToken());
			adjList[heavy].add(new Marble(light, false));
			adjList[light].add(new Marble(heavy, true));
		}
		
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			int heavyCnt = bfs(i, true);
			int lightCnt = bfs(i, false);
			if (Math.max(heavyCnt, lightCnt) > (N / 2))
				cnt++;
		}
		System.out.println(cnt);
	}
	
	public static int bfs(int s, boolean finder) {
		int cnt = 0;
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(s);
		visited[s] = true;
		while(!q.isEmpty()) {
			int tmp = q.poll();
			for (int i = 0; i < adjList[tmp].size(); i++) {
				Marble m = adjList[tmp].get(i);
				if (visited[m.from] || m.isHeavy != finder) continue;
				q.offer(m.from);
				visited[m.from] = true;
				cnt++;
			}
		}
		return cnt;
	}
}

class Marble{
	int from;
	boolean isHeavy;
	public Marble(int from, boolean isHeavy) {
		this.from = from;
		this.isHeavy = isHeavy;
	}
}