import java.util.Scanner;
import java.util.Stack;

public class boj3986 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.nextLine(); // 개행문자 제거용
		int cnt = 0; // '좋은 단어'개수

		for (int tc = 0; tc < N; tc++) {
			// ABAB
			Stack<Character> stack = new Stack<>();

			// scanner nextInt()를 호출한 후 nextLine()을 호출하니 입력받지 못하는 문제 발생
			// nextInt()는 개행문자(\n) 입력 전의 숫자만 입력 받음
			// nextLine()을 사용하면 개행문자까지 입력 받기 때문에, 앞서 버퍼에 남아있는 개행문자 한 개만 입력받고 종료됨
			// 해결방법 : 입력 버퍼를 비워주는 작업 필요 sc.nextLine() 한번 더 호출
			String s = sc.nextLine();

			for (int i = 0; i < s.length(); i++) {

				// 처음과 비었을 경우
				if (stack.empty()) {
					stack.push(s.charAt(i));
				} else {
					// stack의 top이 들어오는 문자와 같을 경우
					if (stack.peek() == s.charAt(i)) {
						stack.pop();
					} else {
						stack.push(s.charAt(i));
					}
				}
			}
			if (stack.empty()) {
				cnt++;
			}
			
		} // tc
		System.out.println(cnt);
		sc.close();
	}
}
