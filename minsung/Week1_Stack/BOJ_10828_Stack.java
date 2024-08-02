package Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_10828_Stack {
	static int size = -1;

	static List<Integer> stack = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String opt = st.nextToken();
			switch (opt) {
			case "pop":
				System.out.println(pop());
				break;
			case "push":

				push(Integer.parseInt(st.nextToken()));
				break;
			case "size":
				System.out.println(size());
				break;
			case "empty":
				empty();
				break;
			case "top":
				top();
				break;

			}
		}

	}

	static void push(int input) {
		stack.add(input);
		size++;

	}

	static int pop() {

		if (size >= 0) {
			int result = stack.get(size);
			stack.remove(size);
			size--;
			return result;

		} else {
			return -1;
		}
	}

	static int size() {
		return size + 1;

	}

	static void empty() {
		if (size >= 0) {
			System.out.println("0");
		} else {
			System.out.println("1");
		}

	}

	static void top() {
		if (size >= 0) {
			System.out.println(stack.get(size));
		} else {
			System.out.println("-1");
		}
	}
}
