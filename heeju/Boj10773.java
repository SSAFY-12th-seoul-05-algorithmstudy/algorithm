import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Boj10773 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 1. 입력
		int t = Integer.parseInt(br.readLine());

		// 2. 계산
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < t; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if (tmp == 0) {
				st.pop();
				continue;
			}
			st.add(tmp);
		}
		int sum = 0;
		while (!st.isEmpty()) {
			sum += st.pop();
		}

		// 3. 출력
		bw.write(String.valueOf(sum));

		br.close();
		bw.close();
	}

}
