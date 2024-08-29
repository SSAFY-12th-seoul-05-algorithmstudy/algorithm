package 백준;

import java.util.*;

public class a를k로만들기재귀 {

	public class Main {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int A = sc.nextInt();
			int K = sc.nextInt();

			Queue<int[]> queue = new LinkedList<>();

			boolean[] visited = new boolean[K + 1]; // K인덱스까지 방문체크를 하기 위해 k+1짜리 배열

			queue.add(new int[] { A, 0 });// A는 시작지점, 0은 연산 횟수
			visited[A] = true; // 시작지점 방문 체크

			while (!queue.isEmpty()) {
				int[] cur = queue.poll();
				int val = cur[0];
				int cnt = cur[1];
				if (val == K) { // 값이 K가 되면 종료
					System.out.println(cnt);
					break;
				}

				if (val + 1 <= K && !visited[val + 1]) { // +1 연산
					visited[val + 1] = true;
					queue.add(new int[] { val + 1, cnt + 1 });
				} // 방문한 지점이 아니면서 아직 k보다 작으면 => 방문체크, 큐에 더하기

				if (val * 2 <= K && !visited[val * 2]) { // *2 연산
					visited[val * 2] = true;
					queue.add(new int[] { val * 2, cnt + 1 });
				} // 방문한 지점이 아니면서 아직 k보다 작으면 => 방문체크, 큐에 더하기
			}
			sc.close();
		}
	}
}
