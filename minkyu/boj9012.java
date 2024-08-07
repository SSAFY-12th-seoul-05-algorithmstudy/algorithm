import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			String line = br.readLine();
			Stack<Character> stack = new Stack<>();
			boolean isOk = true;
			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i) == '(') {
					stack.push('(');
				}else {
					if (stack.size() == 0) {
						isOk = false;
						break;
					}else {
						stack.pop();
					}
				}
			}
			if (isOk && stack.size() == 0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}