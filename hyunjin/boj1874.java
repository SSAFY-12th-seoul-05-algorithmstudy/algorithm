package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class boj1874 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();

		Stack<Integer> stack = new Stack<>();

		int[] sortArray = new int[n];

		int cnt = 1;
		for (int i = 0; i < n; i++) {
			sortArray[i] = cnt++;
		}

		int max = 0;
		List<Integer> inputArray = new ArrayList<>();
		List<Integer> outputArray = new ArrayList<>();

		while (outputArray.size() < n) {
			int num = sc.nextInt();
			inputArray.add(num);

			// 입력한 숫자가 빼낸 숫자의 최댓값보다 클 경우,
			if (num > max) {
				for (int i = max; i < num; i++) {
					stack.push(sortArray[i]);
					sb.append("+").append("\n");
				}
			}

			if (stack.peek() == num) {
				max = Math.max(max, stack.peek());
				outputArray.add(stack.pop());
				sb.append("-").append("\n");
			} else {
				sb.append("NO");
				break;
			}
		}

		if (sb.toString().contains("NO")) {
			System.out.println("NO");
		}else {
		System.out.println(sb.toString());
		}
	}
}
