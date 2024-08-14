import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Boj1874 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 1. 입력
		int t = Integer.parseInt(br.readLine());
		int[] arr = new int[t];
		for (int i = 0; i < t; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// 2. 계산
		StringBuilder sb = new StringBuilder();
		Stack<Integer> st = new Stack<>();
		
		int arrIdx = 0;
		int num = 1;
		boolean isPossible = true;

		while (arrIdx < t) {
			// 2.1 스택이 비었을 때
			if (st.isEmpty() || st.peek() < arr[arrIdx]) {
				for (; num <= arr[arrIdx]; num++) {
					st.add(num);
					sb.append("+").append("\n");
				}
			}
			// 2.2 스택 마지마 요소가 배열 요소와 일치할 때
			if (st.peek() == arr[arrIdx]) {
				st.pop();
				sb.append("-").append("\n");
				arrIdx++;
				continue;
			}
			// 2.3 스택 마지막 요소 > 배열 요소
			if (st.peek() > arr[arrIdx]) {
				isPossible = false;
				break;
			}
		}

		// 3. 출력
		String ans = isPossible ? sb.toString() : "NO";
		
		bw.write(ans);
		
		br.close();
		bw.close();
	}

}
