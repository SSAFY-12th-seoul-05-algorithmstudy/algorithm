import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

// boj_1021번_회전하는 큐
public class boj_1021 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 큐의 크기 N
		int N = sc.nextInt();
		// 뽑아내려고 하는 수의 개수 M
		int M = sc.nextInt();
		// M개 값을 가진 배열 생성
		int[] arr = new int[M];
		for (int i = 0; i < M; i++) {
			arr[i] = sc.nextInt();
		}

		// 덱에는 1 ~ N까지의 값 넣기
		Deque<Integer> deq = new LinkedList<>();
		for (int d = 1; d <= N; d++) {
			deq.add(d);
		}

		// deq 확인
//		System.out.println(deq);

		// count : 2번, 3번 연산의 최솟값
		int count = 0;
		// M개 뽑을 동안 반복
		for (int i = 0; i < M; i++) {

			// 뽑아내려고 하는 수의 위치인 경우 제거
			if (arr[i] == deq.peekFirst()) {
				deq.pollFirst();
				// 만약 마지막 요소였다면 반복 종료
				if (i == M - 1) {
					break;
				}
			}

			// 뽑아내려고 하는 수의 위치와 동일하지 않을 경우
			else {
				while (deq.peekFirst() != arr[i]) {
					// 인덱스가 가운데 기준으로 뒷쪽에 위치 -> 맨 뒤의 값을 맨 앞으로 이동
					if (deq.size() / 2 < ((LinkedList<Integer>) deq).indexOf(arr[i])) { // 가운데 < 인덱스 번호
						int val = deq.pollLast(); // 마지막 값 제거
						deq.offerFirst(val); // 마지막 값 처음으로 추가
						count++; // 3번 연산
					}
					// 인덱스가 가운데 기준으로 앞쪽에 위치 -> 맨 앞의 값을 맨 뒤로 이동
					else {
						int val = deq.pollFirst();
						deq.offerLast(val);
						count++; // 2번 연산
					}
				}
				// 올바른 위치에 도달했으면 요소 제거
				deq.pollFirst();
			}
		}
		// 결과 출력
		System.out.println(count);

	}
}
