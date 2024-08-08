import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 9012번_괄호
public class Main {
	public static void main(String[] args) throws IOException {
	// BufferedReader의 readLine() 메서드가 IOException을 발생시킬 수 있기 때문에 예외 처리 강제 
	// IOException : checked exception
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 반복할 T 입력 
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			
			// 빈 스택 만들기 
			Stack<Character> stack1 = new Stack<Character>();
			// 결과 값 미리 초기화 
			String result = "YES";
			// 1줄 씩 입력받기 
			String str = br.readLine();
			
			for (int i =0; i < str.length(); i++) {
				// 입력받은 값 하나씩 체크 
				char c = str.charAt(i);
			    
				// 여는 괄호일 경우 -> 스택에 넣기 
				if(c == '(') {
					stack1.push(c);
				} else if(c == ')') { // 닫는 괄호인 경우 -> 1. 스택이 비어있으면 NO 출력 2. 스택 차있다면 이전에 들어있던 여는 괄호 빼내기 
					if(stack1.empty()) {
						result = "NO";
						break;
					}
					stack1.pop();
				}
				
				
			}
			// 스택이 비어있지 않으면 올바른 괄호 문자열이 아님
            if (!stack1.empty()) {
                result = "NO";
            }
			System.out.println(result);
		} // T번 반복문 
	} // main
} // class
