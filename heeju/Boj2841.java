import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Boj2841 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 1. 입력
		int t = Integer.parseInt(br.readLine().split(" ")[0]);

		// 1.1 초기 세팅
		final int LINE = 6;
		Map<Integer, Stack<Integer>> map = new HashMap<>();

		for (int i = 1; i <= LINE; i++) {
			map.put(i, new Stack<Integer>());
		}

		// 2. 계산
		int count = 0;
		
		for (int i = 0; i < t; i++) {
			String[] tmp = br.readLine().split(" ");
			int line = Integer.parseInt(tmp[0]);
			int pret = Integer.parseInt(tmp[1]);
			Stack<Integer> st = map.get(line); 
			
			// 2.1
			if (!st.isEmpty() && st.peek() > pret) {
				while(!st.isEmpty() && st.peek() > pret) {
					st.pop();
					count++;
				}
			}
			
			// 2.2
			if (st.isEmpty() || st.peek() < pret) {
				st.add(pret);
				count++;
			}
		}

		// 3. 출력
		bw.write(String.valueOf(count));

		br.close();
		bw.close();
	}

}
