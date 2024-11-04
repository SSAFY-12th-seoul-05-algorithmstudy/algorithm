import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, D;
	static int[] parentsNode;
	static boolean[] visited;
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		parentsNode = new int[N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			parentsNode[i] = sc.nextInt();
		}

		D = sc.nextInt();

		// 노드 먼저 삭제 진행 (true로 표시 = 삭제 의미)
		dfs(D);

		// 리드노프 수 계산
		int count = 0;
		for (int i = 0; i < N; i++) {
			// 현재 노드가 리프 노드인지 확인 check
			boolean check = false;

			// 노드가 삭제되지 않은 경우에만 검사
			if (!visited[i]) {
				check = true; // 리프 노드라고 가정

				// 현재 노드가 삭제되지 않은 자식을 가지고 있는지 검사
				for (int j = 0; j < N; j++) {
					// 자식이 있는 경우
					if (!visited[j] && parentsNode[j] == i) {
						check = false; // 리프 노드 X
					}
				}
			}
			// 리프 노드일 경우 count 증가
			if (check)
				count++;
		}
		System.out.println(count);

	} // main

	public static void dfs(int num) {
		// 큐에는 삭제가 필요한 노드들이 들어오게 된다 !
		// 여기서는 true로 표시된 노드들이 확인할 필요가 없는 노드임을 의미
		q.add(num);

		while (!q.isEmpty()) {
			int cur = q.poll();
			visited[cur] = true;

			for (int i = 0; i < N; i++) {
				if (parentsNode[i] == cur) { // 부모 노드가 확인할 필요가 없다면 해당 자식 노드도 필요없음 !
					q.offer(i);
				}
			}
		}
	} // dfs
} // class
