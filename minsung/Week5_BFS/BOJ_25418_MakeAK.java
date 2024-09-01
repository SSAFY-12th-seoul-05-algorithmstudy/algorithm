import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_25418_MakeAK {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
		//bfs 탐색을 위한 queue 와 boolean 배열
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[K + 1];

		int cnt = 0;
		int[] arr = { N, cnt };
		queue.offer(arr);
		visited[N] = true;

		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();

			if (tmp[0] == K) {
				System.out.println(tmp[1]);
				return;
			}
			if (tmp[0] * 2 <= K && !visited[tmp[0] * 2]) {
				visited[tmp[0] * 2] = true;
				queue.offer(new int[] { tmp[0] * 2, tmp[1] + 1 });
			}
			if (tmp[0] + 1 <= K && !visited[tmp[0] + 1]) {
				visited[tmp[0] + 1] = true;
				queue.offer(new int[] { tmp[0] + 1, tmp[1] + 1 });
			}

		}

	}

}
