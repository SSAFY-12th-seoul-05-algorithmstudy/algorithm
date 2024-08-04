package BOJ_01_Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj9012 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			Stack<Character> stack = new Stack<>();
			String str = br.readLine();

			for (int i = 0; i < str.length(); i++) {
				if (stack.isEmpty()) {
					stack.push(str.charAt(i));
				} else {
					// ( 와 )이 만났을 때, pop()
					// type이 Character이기 때문에 equals나 ""가 아닌 ''로 비교!!
					if ((stack.peek() == '(') && (str.charAt(i) == ')')) {
						stack.pop();
					} else {
						stack.push(str.charAt(i));
					}
				}
			}
			if (stack.isEmpty()) {
				sb.append("YES").append("\n");
			} else {
				sb.append("NO").append("\n");
			}
		} // tc
		System.out.println(sb.toString());
		br.close();
	} // main
}
