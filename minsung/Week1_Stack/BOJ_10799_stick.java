package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10799_stick {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Character> stick = new Stack<>();
		int result = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				// 막대 또는 레이저 시작
				stick.push(str.charAt(i));

			} else if (str.charAt(i) == ')' && str.charAt(i - 1) == '(') {
				// 레이저 -> 현재 막대 개수만큼 result 에 추가
				stick.pop();
				result += stick.size();
			} else if (str.charAt(i) == ')' && str.charAt(i - 1) == ')') {
				// 막대의 끝. 막대 개수 1개 추가.
				stick.pop();
				result += 1;
			}
		}

		System.out.println(result);

		br.close();
	}

}
