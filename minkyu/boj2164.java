import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if (N == 1) {
			System.out.println(N);
			return;
		}
		boolean isDump = true;
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (isDump)
				isDump = false;
			else {
				queue.offer(i);
				isDump = true;
			}
		}
		
		while(queue.size() > 1) {
			if (isDump) {
				isDump = false;
				queue.poll();
			}
			else {
				queue.offer(queue.poll());
				isDump = true;
			}
		}
		System.out.println(queue.poll());
	}
}