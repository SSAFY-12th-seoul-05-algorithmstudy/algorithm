import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// 간선 정보 저장
class edge {
	int childNode; // 자식 노드 번호
	int weight; // 가중치

	public edge(int childNode, int weight) {
		this.childNode = childNode;
		this.weight = weight;
	}
}

public class Main {
	static int V;
	static ArrayList<edge>[] tree;
	static boolean[] visited; // 노드 방문 여부
	static int maxDistance = 0; // 트리의 지름 저장
	static int farthestNode = 0; // 가장 먼 노드 저장

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		// 노드 개수 입력
		V = sc.nextInt();
		tree = new ArrayList[V + 1]; // 노드 번호가 1부터 시작 -> N + 1 크기의 배열 생성

		// 인접 리스트 초기화
		for (int i = 1; i <= V; i++) {
			tree[i] = new ArrayList<>();
		}

//		// V이 1인 경우, 트리의 지름은 0으로 출력
//		if (V == 1) {
//			System.out.println(0);
//			return;
//		}

		// 트리의 간선 정보 입력
		for (int i = 1; i <= V; i++) {
			int p = sc.nextInt(); // 부모 노드
			while (true) {
				int c = sc.nextInt(); // 자식 노드
				if (c == -1) {
					break;
				}
				int w = sc.nextInt(); // 간선의 가중치

				// 무방향 그래프 : 양방향으로 간선 추가
				tree[p].add(new edge(c, w));
				tree[c].add(new edge(p, w));
			}

		}

		// 첫 번째 DFS : 1번 노드에서 가장 먼 노드 찾기
		visited = new boolean[V + 1];
		dfs(1, 0);

		// 두 번째 DFS : 첫 번째 DFS에서 찾은 가장 먼 노드에서 시작하여 트리의 지름 계산
		maxDistance = 0; // 최대 거리 초기화
		visited = new boolean[V + 1]; // 방문 배열 초기화
		dfs(farthestNode, 0);

		// 결과 출력
		System.out.println(maxDistance);

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
		for (edge edge : tree[node]) {
			int nextNode = edge.childNode;
			int weight = edge.weight;

			// 아직 방문하지 않은 노드라면 재귀 호출
			if (!visited[nextNode]) {
				dfs(nextNode, distance + weight);
			}
		}
	} // dfs

} // class
