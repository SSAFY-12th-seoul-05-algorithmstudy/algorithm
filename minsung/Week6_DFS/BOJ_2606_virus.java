import java.util.Scanner;

public class BOJ_2606_virus {
	static int N, V, start;
	static int[][] adjArr;
	static boolean[] visited;
	static int cnt;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		V = sc.nextInt();

		adjArr = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		for (int i = 0; i < V; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			adjArr[A][B] = adjArr[B][A] = 1;
		}
		cnt = 0;
		dfs(1);

		System.out.println(cnt - 1);

	}

	static void dfs(int idx) {
		cnt++;
		visited[idx] = true;

		for (int i = 1; i <= N; i++) {
			if (adjArr[idx][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}

	}
}
