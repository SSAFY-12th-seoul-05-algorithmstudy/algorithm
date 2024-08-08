import java.util.Scanner;
import java.util.Stack;

public class boj1874 {
	// 1~N 오름차순으로 stack에 넣으면서 필요한 값을 차례로 빼고 추가하며 수열 만들기
	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder(); // +,- 출력결과 저장용
		int now = 1; // stack에 넣어야할 숫자 체크용
		boolean chk = true; // 수열 만들 수 있는 여부

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) { // N개 숫자 반복 처리
			int num = sc.nextInt();

			if (num >= now) { // 4 >= 1
				// num 될때까지 stack에 추가
				while (num >= now) {
					stack.push(now++);
					sb.append("+\n");
				}
			}

			// stack last와 num일치 => pop
			if (stack.peek() == num) {
				stack.pop();
				sb.append("-\n");
			} else { // 수열 만들 수 없는 경우
				chk = false;
				break;
			}
		}

		if (chk) {
			System.out.println(sb.toString());
		} else {
			System.out.println("NO");
		}
	}
}
