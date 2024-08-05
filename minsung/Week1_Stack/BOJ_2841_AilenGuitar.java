import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2841_AilenGuitar {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int P = Integer.parseInt(st1.nextToken());
		// n+1개의 스택을 만들고 초기화
		// 형변환 설명해 주실분 구함...
		Stack<Integer>[] stack = (Stack<Integer>[]) new Stack[N + 1];
		for (int i = 0; i < N + 1; i++) {
			stack[i] = new Stack<>();
		}

		int[] maxP = new int[N + 1];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			// 비었을땐 넣고 +1
			if (stack[n].empty()) {
				stack[n].push(p);
				cnt++;
			} else if (stack[n].peek() < p) {
				// 손가락보다 높은 음을 연주할 때는 손가락 하나만 붙이면 되니까 +1 과 푸시
				stack[n].push(p);
				cnt++;
			} else if (stack[n].peek() > p) {
				// 손가락보다 낮은 음을 연주할 때는 연주해야되는 음보다 우선 손가락이 같거나 낮아져야함.
				while (stack[n].peek() > p) {
					// 높은음이면 일단 손가락을 빼라 +1
					stack[n].pop();
					cnt++;
					if (stack[n].empty()) {
						// 그러다 손가락이 다 떨어지면 연주해야 하는 음을 연주 +1
						stack[n].push(p);
						cnt++;
						break;
					}
					// 연주해야할 음을 이미 누르고 있다면, 손가락의 이동은 더이상 없으므로 반복문 탈출
					if (stack[n].peek() == p)
						break;
					else if (stack[n].peek() < p) {
						// 연주해야할 음보다 낮은음을 누르고 있다면 손가락 붙여라 +1
						stack[n].push(p);
						cnt++;
						break;
					}
				}
			}

		}

		System.out.println(cnt);

	}

}
