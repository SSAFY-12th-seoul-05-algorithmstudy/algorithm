import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj10828 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		// 시간 제한 0.5초로 ButterReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 입력으로 주어지는 명령 수

		// 배열로 풀어보기
		int[] stack = new int[N]; // 최대 N개 명령어가 들어오므로 N크기 배열 생성
		int pos = -1; // 스택에 들어있는 정수가 없는 경우에는 -1 => 문제 출력 조건

		for (int i = 0; i < N; i++) {

			String s = br.readLine(); // 명령어 입력

			if (s.contains("push")) { //(1) push X: 정수 X를 스택에 넣는 연산이다.
				String[] command = s.split(" "); // [push, 1]
				stack[++pos] = Integer.parseInt(command[1]);
				
				
			} else if (s.equals("pop")) { //(2) pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
				if (pos == -1) {
					System.out.println("-1");
				} else {
					System.out.println(stack[pos--]);
				}
				
				
			} else if(s.equals("size")) { //(3) size: 스택에 들어있는 정수의 개수를 출력한다.
				System.out.println(pos+1); // error => pos 초기값 -1이므로 pos+1이 되야 현재 들어있는 정수 개수가 됨
				
				
			} else if(s.equals("empty")) { //(4) empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
				if (pos == -1) {
					System.out.println("1");
				} else {
					System.out.println("0");
				}
				
				
			} else if(s.equals("top")) { //(5) top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
				if (pos == -1) {
					System.out.println("-1");
				} else {
					System.out.println(stack[pos]);
				}
			}

		}

	}

}
