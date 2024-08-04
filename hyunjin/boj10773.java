package BOJ_01_Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj10773 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 초기 들어오는 값 받
		int K = Integer.parseInt(br.readLine());

		// 빈 스택선
		Stack<Integer> stack = new Stack<>();

		// K번 돌
		for (int i = 0; i < K; i++) {
			// 값 입력 받
			int num = Integer.parseInt(br.readLine());
			// 스택이 비어 있으면 들어오는 값 추
			if (stack.isEmpty()) {
				stack.push(num);
			} else {
				// 들어오는 값이 0이면, 마지막 요소 빼내
				if (num == 0) {
					stack.pop();
					// 0이 아니면 들어오는 값 스택에 추
				} else {
					stack.push(num);
				}
			}
		} // i

		int cnt = 0;

		// 종료 후, 스택에 남아 있는 값 더하기
		// 스택이 빌 때까지, 해당 요소 빼내서 하나씩 더하기
		while (!stack.isEmpty()) {
			cnt += stack.pop();
		}

		System.out.println(cnt);
	} // main
}
