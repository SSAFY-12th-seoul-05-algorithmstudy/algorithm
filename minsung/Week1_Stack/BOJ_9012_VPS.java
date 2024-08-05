package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012_VPS {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		out: for (int t = 0; t < N; t++) {
			String str = br.readLine();

			Stack<Character> VPS = new Stack<>();
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(') {
					VPS.push(str.charAt(i));
				} else {
					if (VPS.empty()) {
						System.out.println("NO");
						continue out;
					}
					VPS.pop();
				}
			}
			if (VPS.empty()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

		br.close();
	}

}
