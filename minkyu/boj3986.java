import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int tc = 0; tc < T; tc++) {
			Stack<Character> stack = new Stack<>();
			String line = br.readLine();
			if (line.length() % 2 != 0)
				continue;
			for (int i = 0; i < line.length(); i++) {
				if (stack.size() == 0)
					stack.push(line.charAt(i));
				else {
					if (stack.peek() == line.charAt(i))
						stack.pop();
					else
						stack.push(line.charAt(i));
				}
			}
			if (stack.size() == 0)
				cnt++;
		}
		System.out.println(cnt);
	}
}