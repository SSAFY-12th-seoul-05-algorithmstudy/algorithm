import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1744 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		PriorityQueue<Integer> pq1 = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		
		for(int i=0 ; i<N ; i++) {
			int tmp = sc.nextInt();
			
			if(tmp>0) {
				pq1.add(tmp);				
			} else {
				pq2.add(tmp);
			}
			
		}
		
		long ans = 0;
		int tmp1 = 0;
		int tmp2 = 0;
		if(!pq1.isEmpty()) {
			tmp1 = pq1.poll();
		}
		if(!pq2.isEmpty()) {
			tmp2 = pq2.poll();			
		}
		
		while(!pq1.isEmpty()) {
			int tmp3 = pq1.poll();
			if(tmp3 + tmp1 > tmp1*tmp3) {
				ans += tmp1+tmp3;
			}
			else {
				ans += tmp1*tmp3;
			}
			if(!pq1.isEmpty()) tmp1 = pq1.poll();
			else tmp1 = 0;
		}
		ans += tmp1;
		
		while(!pq2.isEmpty()) {
			ans += tmp2*pq2.poll();
			if(!pq2.isEmpty()) tmp2 = pq2.poll();
			else tmp2 = 0;
		}
		
		ans += tmp2;
		
		System.out.println(ans);
	}
}
