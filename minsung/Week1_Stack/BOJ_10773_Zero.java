package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10773_Zero {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();
		for (int t = 0; t < T; t++) {
			int k = Integer.parseInt(br.readLine());
			if (k == 0) {
				stack.pop();
			} else {
				stack.push(k);
			}
		}

		int sum = 0;
		for (int i = 0; i < stack.size(); i++) {
			sum += stack.get(i);
		}

		System.out.println(sum);

	}

}
