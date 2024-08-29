import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		K--;
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++)
			queue.offer(i);
		
		StringBuilder sb = new StringBuilder("<");
		int cnt = 0;
		while(true) {
			if (cnt < K) {
				queue.offer(queue.poll());
				cnt++;
			}
			else {
				sb.append(queue.poll());
				cnt = 0;
				if (queue.size() == 0)
					break;
				sb.append(", ");
			}
		}
		sb.append(">");
		System.out.println(sb);
	}
}