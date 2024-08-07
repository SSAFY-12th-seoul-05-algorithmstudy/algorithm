import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Boj2164 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 1. 입력
		int t = Integer.parseInt(br.readLine());

		// 2.
		// 2.1 초기 세팅
		Deque<Integer> deque = new LinkedList<>();
		for (int i = 1; i <= t; i++) {
			deque.offer(i);
		}

		// 2.2 계산
		while (deque.size() > 1) {
			deque.pollFirst();
			deque.addLast(deque.pollFirst());
		}

		// 3. 출력
		bw.write("" + deque.peek());

		br.close();
		bw.close();
	}

}
