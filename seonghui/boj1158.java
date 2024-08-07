import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj1158 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		while(queue.size() > 1) {
			
			// K-1만큼 뺏다 추가
			for(int i = 0; i < K-1; i++) {
				queue.add(queue.remove());
			}
			
			// K번째 제거
			sb.append(queue.remove()).append(", ");
		}
		sb.append(queue.remove()).append(">"); // 마지막 남은 사람 큐에서 제거
		System.out.println(sb.toString());
	}// main
}
