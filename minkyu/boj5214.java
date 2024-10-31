import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Set<Integer>[] tubes = new HashSet[M];
		for (int i = 0; i < M; i++)
			tubes[i] = new HashSet<>();
		
		// 하이퍼 튜브를 하나의 노드로 생성
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < K; j++) {
				int curVal = Integer.parseInt(st.nextToken());
				tubes[i].add(curVal);
			}
		}
		
		
		int minWay = -1;
		// 추가가 완료된 행렬에서 bfs를 통해 1번역에서 N번역으로 갈 수 있는 역의 개수 최솟값을 출력할 것
		boolean[] visitedTube = new boolean[M];
		boolean[] visited = new boolean[N + 1];
		
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {1,1});
		visited[1] = true;
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			if (tmp[0] == N) {
				minWay = tmp[1];
				break;
			}
			for (int i = 0; i < M; i++) {
				if (visitedTube[i]) continue;
				if (tubes[i].contains(tmp[0])) {
					// 갈 수 있는 곳 지정
					for (int k : tubes[i]) {
						if (visited[k]) continue;
						q.offer(new int[] {k,tmp[1] + 1});
						visited[k] = true;
					}
					visitedTube[i] = true;
				}
			}
		}
		
		System.out.println(minWay);
	}
}