import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine()); // K번 반복
		
		Stack<Integer> stack = new Stack<>(); // 정수형 스택 선언
		int sum = 0; // 스택의 합
		for(int i=0;i<K;i++) {
			int a = Integer.parseInt(br.readLine()); // 입력받은 정수 저장
			if (a!=0) { // 들어온 정수가 0이아니면
				stack.push(a);
				continue;
			}
			if (stack.isEmpty()) {
				continue;
			}
			stack.pop();		
		}
		while (!stack.isEmpty()) {
            sum += stack.pop();  // 스택에서 요소를 꺼내어 합산
        }
		System.out.println(sum);
	}
}