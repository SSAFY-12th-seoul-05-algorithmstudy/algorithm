import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj1021 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 1. 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[m];

		for (int i = 0; i < m; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 1.1 초기 세팅
		Deque<Integer> front = new ArrayDeque<>();
		Deque<Integer> back = new ArrayDeque<>();

		for (int i = 1; i <= n; i++) {
			front.offer(i);
		}

		// 2. 계산
		int count = 0;
		
		for (int num : arr) {
			if (front.isEmpty()) {
                Deque<Integer> tmp = front;
				front = back;
				back = tmp;
			}
			
			// 2.1 빼고자 하는 숫자를 deque2의 맨 앞에 위치시키기
			while (true) {
				back.offerFirst(front.pollLast());
				if (back.peekFirst() == num) {
					break;
				}
			}

			// 2.2 어느 방향으로 이동시킬지 결정
			// 2번 이동
            int len;
			if (front.size() <= back.size()) { 
                len = front.size();
				count += len;
				for (int i = 0; i < len; i++) {
					back.offerLast(front.pollFirst());
				}
				back.pollFirst();    // 빼려고하는 숫자 제거
				continue;
			}
			// 3번 이동
            len = back.size();
			count += len;
			for (int i = 0; i < len; i++) {
				front.offerFirst(back.pollLast());
			}
			front.pollFirst();    // 빼려고하는 숫자 제거
		}

		// 3. 출력
		bw.write(String.valueOf(count));

		br.close();
		bw.close();
	}
}
