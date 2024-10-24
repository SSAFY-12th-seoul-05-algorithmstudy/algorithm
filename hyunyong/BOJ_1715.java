import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1715 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0 ; i<N ; i++) {
			pq.add(sc.nextInt());
		}
		int ans = 0;
		
		for(int i=0 ; i<N ; i++) {
			int a = pq.poll();
			if(!pq.isEmpty()) {
				int b = pq.poll();				
				pq.add(a+b);
				ans += a+b;
			} else {
				pq.add(a);
			}
		}
		
		System.out.println(ans);
	}
}
