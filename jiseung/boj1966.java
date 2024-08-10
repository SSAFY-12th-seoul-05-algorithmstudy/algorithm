import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테스트케이스

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st1.nextToken()); // 문서의 개수
			int index = Integer.parseInt(st1.nextToken()); // 몇번째 문서인지

			StringTokenizer st2 = new StringTokenizer(br.readLine());
			Queue<Integer> queue = new LinkedList<>();

			int[] count = new int[10]; // 중요도 카운트배열

			int num = 0; // 문서 중요도
			int order = 0; // 카운트배열에서 몇번째인지
			for (int i = 0; i < N; i++) {
				if (i == index) {
					int a = Integer.parseInt(st2.nextToken());
					count[a]++;
					queue.add(a);
					num = a;
					order = count[a];
				} else {
					int a = Integer.parseInt(st2.nextToken());
					queue.add(a);
					count[a]++;
				}
			}
			int cnt = 0;

			int cycle = count[num];

			for (int i = 9; i >= 0; i--) { // 문서 우선순위 높은것 우선

				// i == num일때
				if (i == num) {
					cnt += order;
					break;
				} else { // i > num 일때 i==num 될때까지
					while (count[i] != 0) { // count[i]개만큼 반복
						while (queue.peek() != i) { // i가아니면 뒤로
							if (queue.peek() == num) {// peek이 num이면,
								order = (order > 1) ? order - 1 : cycle;
								queue.add(queue.poll());
							}
							else {
							queue.add(queue.poll());
							}
						}
						// i이면
						queue.poll();
						count[i]--;
						cnt++;
					}
					continue; // 다음반복으로
				}
			}
			System.out.println(cnt);
		}
	}
}