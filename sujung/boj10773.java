package study_스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj10773 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스 수 입력
		int T = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();

		// 테스트 케이스 처리
		for (int tc = 0; tc < T; tc++) {
			int num = Integer.parseInt(br.readLine());

			if (num == 0) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.push(num);
			}
		}

		// 모든 테스트 케이스 입력 처리 후 스택의 합계 계산
		int sum = 0;
		while (!stack.empty()) {
			sum += stack.pop();
		}

		// 결과 출력
		System.out.println(sum);

	}

}
