import java.util.Scanner;
import java.util.Stack;

public class boj10773 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		Stack<Integer> stack = new Stack<>();

		int sum = 0;
		for (int tc = 0; tc < K; tc++) {
			int N = sc.nextInt();
			if (N != 0) {
				stack.push(N);
			} else {
				stack.pop();
			}
		}

		// 합 구하기
		while (!stack.isEmpty()) {
			sum += stack.pop();
		}
		System.out.println(sum);
	}
}
