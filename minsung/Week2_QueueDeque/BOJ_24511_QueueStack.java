import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_24511_QueueStack {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {

			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if (arr[i] == 0) {
				// 스택은 아무 의미 없음 큐만 챙겨라!
				queue.offerFirst(tmp);
			}
		}
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			// 순서대로 queue 에서 뽑기
			queue.offer(Integer.parseInt(st.nextToken()));
			sb.append(queue.poll()).append(" ");
		}
		System.out.println(sb.toString().trim());

	}

}
