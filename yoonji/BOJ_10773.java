import java.util.Scanner;
import java.util.Stack;

public class BOJ_10773 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		
		// 스택 안에 숫자를 넣어준다.
		// 만약 0이라면 가장 위에 있는 숫자를 빼준다
		for(int i=0; i<K; i++) {
			int num = sc.nextInt();
			
			if(num == 0) {
				stack.pop();
			}else {
				stack.push(num);
			}
		} // for
		
		if(stack.isEmpty()) { // 스택이 비어있다면
			System.out.println(0); // 0 출력
		}else{ // 스택이 비어있지 않다면
			int sum = 0;
			// 스택 안에 있는 합을 구한다.
			while(!stack.isEmpty()) {
				sum += stack.pop();
			}
			System.out.println(sum);
		}
	}//main
}
