package stack_3986;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_3986 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			String word = br.readLine();
			Stack<Character> st = new Stack<>();

			for (int j = 0; j < word.length(); j++) {
				if (st.size() > 0 && st.peek() == word.charAt(j)) {
					st.pop();
				} else {
					st.push(word.charAt(j));
				}
			}
			if (st.size() == 0)
				cnt++;
		}
		System.out.println(cnt);
	}

}
