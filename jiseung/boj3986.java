import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // Test케이스의 갯수
		int cnt = 0;
		
		for(int tc=0; tc<T; tc++) { // Testcase만큼 반복
			String str = br.readLine(); // 문자열을 입력받음.
			Stack<Character> stack = new Stack<>();
			
			// 문자열을 첫번째부터 스택에 넣는식으로 반복
			for(int i=0; i<str.length();i++) {
				if (stack.empty()) { // 스택이 비어있으면
					stack.push(str.charAt(i)); // 첫번째문자열을 push
				}
				else { // 스택이 비어있지 않으면
					if(stack.peek()==str.charAt(i)) { //가장 윗값과 넣는값이 같으면 
						stack.pop(); // pop
					}
					else { // 다르면
						stack.push(str.charAt(i)); // push
					}
				}
			} 
			
			// 종료된 이후 좋은단어는 스택이 비워져있고 나쁜단어는 남아있다.
			if (stack.empty()) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}