import java.util.Scanner;
import java.util.Stack;

public class BOJ_9012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 0; tc<T; tc++) {
			String s = sc.next();
			char[] arr = s.toCharArray();
			Stack<Character> stack = new Stack<>();
			for(int i=0; i<arr.length; i++) {
				if(stack.isEmpty()) {
					stack.push(arr[i]);
				} else {
					if(stack.peek() == '(' && arr[i] == ')') {
						stack.pop();
					}else {
						stack.push(arr[i]);
					}
				}
			
			}
			if(stack.isEmpty()) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		} // tc
	} //main
}
