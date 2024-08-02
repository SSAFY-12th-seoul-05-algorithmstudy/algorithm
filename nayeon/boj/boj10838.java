
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// N : 명령의 수
		int N;
		N = sc.nextInt();
		
		Stack<Integer> stackInt = new Stack<>();
		
		for (int test_case = 0; test_case <= N; test_case++) {
			String test = sc.nextLine();
			
			if(test.startsWith("push")) {
				// push 뒤의 숫자 value로 표시 
				String[] num = test.split(" ");
				int value = Integer.parseInt(num[1]);
//				System.out.println(value);
				stackInt.push(value);
			} else if(test.startsWith("pop")) {
				int result = (stackInt.size() != 0) ? stackInt.pop() : -1;
				System.out.println(result);
			} else if(test.startsWith("size")) {
				System.out.println(stackInt.size());
			} else if(test.startsWith("empty")) {
				int result = (stackInt.size() != 0) ? 0 : 1;
				System.out.println(result);
			} else if(test.startsWith("top")) {
				int result1 = (stackInt.size() != 0) ? stackInt.peek() : -1;
				System.out.println(result1);
			} 
			

		} // 1st for(test_case)
	}
}
