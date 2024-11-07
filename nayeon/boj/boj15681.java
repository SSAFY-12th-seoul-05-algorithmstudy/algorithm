import java.util.*;

public class Main {

	static int N, R, Q;
	static ArrayList<Integer>[] tree;
	static boolean[] visited;
	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		Q = sc.nextInt();

		tree = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			// 무방향
			tree[a].add(b);
			tree[b].add(a);
		}

		dp = new int[N + 1];

		visited = new boolean[N + 1];

		// 루트 노드 R에서 서브트리 크기 계산
		find(R);

		// 쿼리 수 만큼 반복
		for (int i = 0; i < Q; i++) {
			int t = sc.nextInt();
			System.out.println(dp[t]);
		}
	} // main

	static int find(int v) {
		visited[v] = true; // 현재 정점 v를 방문 처리
		int ret = 1; // 현재 정점을 포함하여 서브트리 크기 초기화

		// 현재 정점과 연결된 모든 자식 노드에 대해 반복
		for (int child : tree[v]) {
			// 아직 방문하지 않은 자식 노드인 경우
			if (!visited[child]) {
				ret += find(child); // 자식 노드의 서브트리 크기 추가
			}
		}

		dp[v] = ret; // 현재 정점 v의 서브트리 크기를 dp에 저장
		return ret; // 서브트리 크기 반환
	} // find
} // class
