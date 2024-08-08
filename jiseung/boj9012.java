import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc=1;tc<=T;tc++) {
			String str = br.readLine(); // 문자열을 입력받음.
			Stack<Character> stack = new Stack<>(); // 스택 선언
			
			for(int i=0;i<str.length();i++) { // 문자의 길이만큼 반복
				if (stack.empty()) { // 스택이 비어있으면
					stack.push(str.charAt(i)); // 스택에 문자열을 push!
					continue;
				}
				if(stack.peek().equals(str.charAt(i))){ // 비어있지 않고 같은문자면
					stack.push(str.charAt(i));	//push
					continue;
				}
				// 이게 포인트인 것 같은데 ')('를 다른문자라고 판단해서 pop하면 문제가 생깁니다.
				if(stack.peek().equals('(')&&str.charAt(i) ==(')'))
				stack.pop();
			}
			if (stack.isEmpty()) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
	}
}