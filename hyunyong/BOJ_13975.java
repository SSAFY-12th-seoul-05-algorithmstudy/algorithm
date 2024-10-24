import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_13975 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			int K = sc.nextInt();
			
			PriorityQueue<Long> pq = new PriorityQueue<>();
			
			for(int i=0 ; i<K ; i++) {
				pq.add(sc.nextLong());
			}
			
			long ans = 0;
			for(int i=0 ; i<K ; i++) {
				long a = pq.poll();
				if(!pq.isEmpty()) {
					long b = pq.poll();
					ans += a+b;
					pq.add(a+b);
				} else {
					pq.add(a);
				}
			}
			
			System.out.println(ans);
		}
	}
}
