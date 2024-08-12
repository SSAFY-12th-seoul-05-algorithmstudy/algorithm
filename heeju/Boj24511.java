import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj24511 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 1. 입력
		int n = Integer.parseInt(br.readLine());
		
		// 1.1 스택인지 큐인지 확인
		int[] isStack = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			isStack[i] = Integer.parseInt(st.nextToken());
		}
		
		// 1.2 큐만 초기화
		Deque<String> deque = new ArrayDeque<>();
		
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			String tmp = st.nextToken();
			if (isStack[i] == 0) {
				deque.offerLast(tmp);
			}
		}

		// 2. 계산
		StringBuilder sb = new StringBuilder();
		int m = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < m; i++) {
			deque.offerFirst(st.nextToken());
			sb.append(deque.pollLast()).append(" ");
		}

		// 3. 출력
		bw.write(sb.toString());

		br.close();
		bw.close();
	}
}
