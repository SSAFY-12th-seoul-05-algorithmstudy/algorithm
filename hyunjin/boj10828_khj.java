import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_10828_khj {
	static int[] stack;
	static int size = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // br 선언 

		// String은 변경 불가능한 문자열을 생성하지만, StringBuilder는 변경 가능한 문자열을 만들 수 있게 해준다.
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		stack = new int[N]; // 스택 배열 생성

		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			switch (st.nextToken()) {
			case "push":
				push(Integer.parseInt(st.nextToken()));
				break;

			case "pop":
				sb.append(pop()).append('\n');
				break;

			case "size":
				sb.append(size()).append('\n');
				break;

			case "empty":
				sb.append(empty()).append('\n');
				break;

			case "top":
				sb.append(top()).append('\n');
				break;
			}
		}
		System.out.println(sb);
		br.close();

	}

	private static void push(int item) {
		stack[size] = item;
		size++;
	}

	private static int pop() {
		if (size == 0) {
			return -1;
		} else {
			int popNum = stack[size - 1];
			stack[size - 1] = 0;
			size--;
			return popNum;

		}
	}

	private static int size() {
		return size;
	}

	private static int top() {
		if (size == 0) {
			return -1;
		} else {
			return stack[size - 1];
		}
	}

	private static int empty() {
		if (size == 0) {
			return 1;
		} else {
			return 0;
		}
	}

}
