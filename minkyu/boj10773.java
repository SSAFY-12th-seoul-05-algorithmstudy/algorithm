import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		for (int tc = 0; tc < T; tc++) {
			int curVal = sc.nextInt();
			if (curVal == 0)
				stack.pop();
			else
				stack.push(curVal);
		}
		
		long sum = 0;
		for (int i : stack)
			sum += i;
		System.out.println(sum);
	}
}