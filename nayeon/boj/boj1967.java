import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 간선 정보 저장
class Edge {
	int childNode; // 자식 노드 번호
	int weight; // 가중치

	public Edge(int childNode, int weight) {
		this.childNode = childNode;
		this.weight = weight;
	}
}

public class Main {
	static int N;
	static ArrayList<Edge>[] tree;
	static boolean[] visited; // 노드 방문 여부
	static int maxDistance = 0; // 트리의 지름 저장
	static int farthestNode = 0; // 가장 먼 노드 저장

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 노드 개수 입력
		N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N + 1]; // 노드 번호가 1부터 시작 -> N + 1 크기의 배열 생성

		// 인접 리스트 초기화
		for (int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}

		// N이 1인 경우, 트리의 지름은 0으로 출력
		if (N == 1) {
			bw.write("0\n");
			bw.flush();
			bw.close();
			return;
		}

		// 트리의 간선 정보 입력
		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken()); // 부모 노드
			int c = Integer.parseInt(st.nextToken()); // 자식 노드
			int w = Integer.parseInt(st.nextToken()); // 간선의 가중치

			// 무방향 그래프 : 양방향으로 간선 추가
			tree[p].add(new Edge(c, w));
			tree[c].add(new Edge(p, w));
		}

		// 첫 번째 DFS : 1번 노드에서 가장 먼 노드 찾기
		visited = new boolean[N + 1];
		dfs(1, 0);

		// 두 번째 DFS : 첫 번째 DFS에서 찾은 가장 먼 노드에서 시작하여 트리의 지름 계산
		maxDistance = 0; // 최대 거리 초기화
		visited = new boolean[N + 1]; // 방문 배열 초기화
		dfs(farthestNode, 0);

		// 결과 출력
		bw.write(maxDistance + "\n");
		bw.flush();
		bw.close();

	} // main

	// 현재 노드에서 최대 거리와 가장 먼 노드를 찾기
	public static void dfs(int node, int distance) {
		visited[node] = true; // 현재 노드 방문 처리

		// 최대 거리와 가장 먼 노드 갱신
		if (distance > maxDistance) {
			maxDistance = distance;
			farthestNode = node;
		}

		// 현재 노드에 연결된 모든 간선을 탐색
		for (Edge edge : tree[node]) {
			int nextNode = edge.childNode;
			int weight = edge.weight;

			// 아직 방문하지 않은 노드라면 재귀 호출
			if (!visited[nextNode]) {
				dfs(nextNode, distance + weight);
			}
		}
	} // dfs

} // class
