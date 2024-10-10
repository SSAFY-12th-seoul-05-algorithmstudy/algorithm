import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1260_DFSBFS {
	static int N, V, start;
	static int[][] adjArr;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		V = sc.nextInt();
		start = sc.nextInt();

		adjArr = new int[N + 1][N + 1];

		for (int i = 0; i < V; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			adjArr[A][B] = adjArr[B][A] = 1;
		}

		visited = new boolean[N + 1];
		dfs(start, 0);
		System.out.println();

		visited = new boolean[N + 1];
		bfs(start);
		sc.close();
	}

	static void dfs(int idx, int cnt) {

		visited[idx] = true;
		System.out.print(idx + " ");
		if (cnt == N)
			return;

		for (int i = 1; i <= N; i++) {
			if (adjArr[idx][i] == 1 && !visited[i]) {
				dfs(i, cnt + 1);
			}
		}
	}

	static void bfs(int idx) {
		StringBuilder sb = new StringBuilder();
		visited[idx] = true;

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(idx);

		while (!queue.isEmpty()) {
			int curr = queue.poll();
			sb.append(curr).append(" ");

			for (int i = 1; i <= N; i++) {
				if (adjArr[curr][i] == 1 && !visited[i]) {
					visited[i] = true;
					queue.offer(i);
				}
			}

		}
		System.out.println(sb.toString());

	}

}
