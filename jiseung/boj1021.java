import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken()); // 원소의 갯수
		int M = Integer.parseInt(st1.nextToken()); // 뽑아낼 갯수

		StringTokenizer st2 = new StringTokenizer(br.readLine());
		Deque<Integer> deque = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {
			deque.addLast(i);
		}

		int cnt = 0;
		// deque.peek()==a -> 뽑기
		// 2번연산 , 3번연산 판단

		for (int i = 0; i < M; i++) {
			// 찾을원소
			int a = Integer.parseInt(st2.nextToken());
			
			// peek해서 a이면 cnt++없이 poll
			if (deque.peek() == a) {
				deque.poll();
			} 
			// peek했을때 a 아니면
			else {
				int clockwise = 0;	// 시계방향
				int counterclockwise = 0;	// 반시계방향
				
				// 첫번째 원소가 a 될때까지 반시계방향으로 돌리고 몇번돌리는지 확인
				while (deque.peek() != a) {
					deque.addFirst(deque.pollLast());
					counterclockwise++;
				}
				
				// 다시 원상태로 복구
				for (int j=1;j<=counterclockwise;j++) {
					deque.addLast(deque.pollFirst());
				}
				
				// 첫번째 원소가 a 될때까지 시계방향으로 돌리고 몇번돌리는지 확인
				while (deque.peek() != a) {
					deque.addLast(deque.pollFirst());
					clockwise++;
				}
				// 첫번째 원소 a니까 poll 
				deque.poll();
				
				// 시계방향, 반시계방향중에 최소값을 더함.
				cnt += Math.min(clockwise,counterclockwise);
			}
		}
		System.out.println(cnt);
	}
}