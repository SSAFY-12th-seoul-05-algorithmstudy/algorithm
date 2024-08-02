import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int P = sc.nextInt();
		Stack<Integer>[] stacks = new Stack[6];
		for (int i = 0; i < 6; i++)
			stacks[i] = new Stack<Integer>();
		int cnt = 0;
		for (int tc = 0; tc < T; tc++) {
			int str = sc.nextInt() - 1;
			int plat = sc.nextInt();
			if (stacks[str].size() == 0) {
				stacks[str].push(plat);
				cnt++;
			} else {
				while (stacks[str].peek() > plat) {
					stacks[str].pop();
					cnt++;
					if (stacks[str].size() == 0)
						break;
				}
				if (stacks[str].size() == 0) {
					stacks[str].push(plat);
					cnt++;
				}else {
					if (stacks[str].peek() < plat) {
						stacks[str].push(plat);
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}