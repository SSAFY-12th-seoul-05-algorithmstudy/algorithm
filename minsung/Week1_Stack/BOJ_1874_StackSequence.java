import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * N개의 수를 수열로 늘어놓으므로
 * N번 pop 해야함.
 * 넣어야 할 수가 현재 수보다 크다면 그 수까지 push
 * 넣어야 할 수가 현재 수보다 작다면 그냥 pop
 * 하지만 pop할 때, 내가 찾고자 하는 수열이 안나온다면 no
 *
 */
public class BOJ_1874_StackSequence {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Stack<Integer> stack = new Stack<>();

		int value = 0;
		// N번의 pop
		for (int i = 0; i < N; i++) {

			// 넣어야 할 수와 현재의 수를 비교 하는 과정.
			if (arr[i] > value) {

				int lastvalue = value;

				value = arr[i];
				// 현재 수 부터, 넣어야 하는 수 까지 push
				for (int j = lastvalue + 1; j <= value; j++) {
					stack.push(j);
					sb.append("+\n");
				}
			} else if (arr[i] != stack.peek()) {
				// 내가 원하는 수열이 안나오면 프로그램 종료
				System.out.println("NO");
				return;
			}

			stack.pop();
			sb.append("-\n");
		}

		System.out.println(sb.toString());

		br.close();

	}

}
