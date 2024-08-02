package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_3986_GoodWord {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans = 0;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			String input = br.readLine();
			Stack<Character> stk = new Stack<>();

			for (int i = 0; i < input.length(); ++i) {
				if (stk.empty()) {
					stk.push(input.charAt(i));
				} else {
					if (stk.peek() == input.charAt(i)) {
						stk.pop();
					} else {
						stk.push(input.charAt(i));
					}
				}
			}

			if (stk.empty())
				ans++;

		}

		System.out.println(ans);
	}

}
