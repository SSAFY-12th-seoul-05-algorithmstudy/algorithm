package BOJ_01_Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_3986_khj {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 입력 받은 단어의 수 = tc
		int cnt = 0;

		for (int tc = 0; tc < N; tc++) {
			Stack<Character> stack = new Stack<>();
			String str = br.readLine(); // 한 줄 씩 String 으로 읽어 오겠다.

			for (int i = 0; i < str.length(); i++) {
				if (stack.isEmpty()) {
					stack.push(str.charAt(i)); // stack이 비어 있으면,

					// 넣으려는 문자 == 스택 가장 위 문자 -> 기존 문자열 pop
					// 같지 않으면, 문자열 push
					// 반복할 경우, 같은 문자 끼리 만나서 짝을 지어서 다 빠져 나가면 == stack.isEmpty
					// 좋은 단어 생성 => cnt++
				} else {
					if (str.charAt(i) == stack.peek()) { // 이미 있는 문자와 들어가는 문자가 같으면,
						stack.pop(); // 짝 지어서 나감
					} else {
						stack.push(str.charAt(i)); // 같지 않으면, 스택에 집어 넣어

					}
				}
			}
			// 모든 문자가 짝을 지어 나가면, 스택은 empty => 좋은 단어 수 ++
			if (stack.isEmpty()) {
				cnt++;
			}

		} // tc
		System.out.println(cnt);
		br.close();
	}
}
