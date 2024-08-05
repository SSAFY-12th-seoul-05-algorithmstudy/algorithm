import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Boj3986 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int ans = 0;

		for (int tc = Integer.parseInt(br.readLine()); tc > 0; tc--) {
			String input = br.readLine();
			Stack<String> stack = new Stack<>();

			for (int i = 0; i < input.length(); i++) {
				String s = "" + input.charAt(i);
				// 1. 스택이 비었거나, 앞 요소와 다를 때
				if (stack.size() == 0 || !stack.peek().equals(s)) {
					stack.add(s);
					continue;
				}
				// 2. 스택의 마지막 요소와 같을 때
				stack.pop();
			}

			if (stack.size() == 0) {
				ans++;
			}
		}
		
		br.close();

		bw.write("" + ans);
		bw.flush();
		bw.close();
	}
}
