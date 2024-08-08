
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 백준_스택수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// T번 반복
		int T = Integer.parseInt(br.readLine());
		
		// 빈 스택 만들기 -> 정수형 
		Stack<Integer> stack1 = new Stack<Integer>();
		int top = 0;
		// 시간 초과 문제로 builder 사용해야함 ... 이유는 아직 잘 모르겠음 -> 더 알아보기 **
		StringBuilder result = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			
			if(top < N) {
				for(int i = top + 1; i <=N; i++) {
					stack1.push(i);
//					System.out.println("+"); // -> 여기서 바로 출력하려고 하니 NO 일 때도 앞부분의 결과가 같이 출력됨
					result.append("+\n");
				}
				stack1.pop(); // 마지막 값 제외
//				System.out.println("-");
				result.append("-\n");
				top = N;

			} else if(stack1.peek() == N) {
				stack1.pop();
//				System.out.println("-");
				result.append("-\n");

			} else {
				System.out.println("NO"); // NO인 경우 출력되는 부분
				return;
			}
			
			
		} // T번 반복 
		
		// 결과 출력 : NO 아닌 경우만 출력되는 부분 
		System.out.println(result);
		br.close();
		
	} // main
} // class
