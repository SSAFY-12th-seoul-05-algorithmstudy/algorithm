package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// BOJ13023_ABCDE
public class boj13023 {
	static int N, M, ans, cnt; // N : 그래프 정점의 개수, M : 그래프 간선의 개수
	static List<Integer>[] adjList; // 인접 리스트
	static boolean[] visited; // 방문 체크

	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adjList = new ArrayList[N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			adjList[A].add(B);
			adjList[B].add(A);
		} // 입력 완료

		ans = 0;

		for (int i = 0; i < N; i++) {
			visited = new boolean[N]; // 매 방문마다 배열 초기화
			dfs(i, 1);

			if (ans == 1)
				break;
		}

		System.out.println(ans);

	}

	// v : 현재 내가 위치한 정점
	// length : 친구 사이 길이 => 5가 되면 stop
	static void dfs(int v, int length) {
		if (length == 5) {
			ans = 1;
			return;
		}

		visited[v] = true;

		// 현재 노드 v와 인접한 노드만 탐색
		for (int i : adjList[v]) {
			if (!visited[i]) {
				dfs(i, length + 1);
				if (ans == 1)
					return;
			}
		}
		visited[v] = false;
	}
}
