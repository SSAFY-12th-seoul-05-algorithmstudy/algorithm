import java.util.Scanner;
import java.util.Stack;

public class boj9012 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int tc = 0; tc < N; tc++) {
			String s = sc.next();
			System.out.println(chk(s));
		}

	}

	public static String chk(String s) {

		Stack<Character> stack = new Stack<>();
		String ans = "YES";

		for (int i = 0; i < s.length(); i++) {

			// '(' => 스택에 추가
			if (s.charAt(i) == '(') {
				stack.push(s.charAt(i));
			}
			// ')'경우
			else {
				if (stack.isEmpty()) {
					ans = "NO";
					break;
				}
				stack.pop();
			}
		}
		// '('가 남아 있을 경우
		if (!stack.isEmpty()) {
			ans = "NO";
		}
		return ans;
	}
}
