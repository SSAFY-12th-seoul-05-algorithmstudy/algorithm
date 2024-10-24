import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1655 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		
		PriorityQueue<Integer> pq1 = new PriorityQueue<>(Comparator.reverseOrder());
		PriorityQueue<Integer> pq2 = new PriorityQueue<>();
		
		for(int i=0 ; i<N ; i++) {
			int tmp = sc.nextInt();
			
			if(pq1.peek()==null) {
				pq1.add(tmp);
			} else {
				if(tmp>pq1.peek()) {
					pq2.add(tmp);
					if(pq2.size()>pq1.size()) {
						pq1.add(pq2.poll());
					}
				} else {
					pq1.add(tmp);
					if(pq2.size()+1<pq1.size()) {
						pq2.add(pq1.poll());
					}
				}
			}
			
			sb.append(pq1.peek()).append("\n");
		}
		System.out.println(sb);
	}
}
