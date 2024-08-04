import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 10773번_제로
public class Main {
	public static void main(String[] args) throws IOException {
	// BufferedReader의 readLine() 메서드가 IOException을 발생시킬 수 있기 때문에 예외 처리 강제 
	// IOException : checked exception
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 반복할 T 입력 
		int T = Integer.parseInt(br.readLine());
		// 빈 스택 만들기 
		Stack<Integer> stack1 = new Stack<>();
		
		for (int tc = 0; tc < T; tc++) {
			// 입력받기 
			int n = Integer.parseInt(br.readLine());
			// 스택이 비어있다면 값 넣기
			if (n == 0) {
				if (!stack1.isEmpty()) {
                  stack1.pop(); // 0이 입력되면 스택에서 가장 최근 값을 제거
				}
			} else {
				stack1.push(n); // 0이 아닌 수인 경우, 스택에 넣기 
			}	
		} // T번 반복
		
		// 스택이 비어있지 않으면 들어있는 값 더하기
		int result = 0;
		// 스택이 비어있을 때까지 스택에서 값을 꺼내서 합산
		while (!stack1.empty()) {
            result += stack1.pop(); 
        }
		
		System.out.println(result);
	} // main
} // class
