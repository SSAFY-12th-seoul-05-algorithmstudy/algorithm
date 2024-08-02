import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
			String str = br.readLine(); // 문자열을 입력받음.
			Stack<Character> stack = new Stack<>(); // 스택 선언
			
			String str2 = str.replace("()","a");
			int sum = 0;
			
			for(int i=0;i<str2.length();i++) { // 문자의 길이만큼 반복
				if (str2.charAt(i) == 'a') { // 레이저를 만났다!
					sum += stack.size(); // 잘라서 왼쪽부분의 갯수를 더한다.
				}
				else {
					if (stack.empty()) { // 스택이 비어있으면
						stack.push(str2.charAt(i)); // 스택에 문자열을 push!
					}
					else {	// 스택이 비어있지 않으면
						if(stack.peek().equals(str2.charAt(i))){
							stack.push(str2.charAt(i));
						}
						else {
							stack.pop();
							sum += 1;
						}
					}
				}
			}
			System.out.println(sum);
	}
}