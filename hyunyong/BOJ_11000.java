import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_11000 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});
		
		PriorityQueue<Integer> pq2 = new PriorityQueue<>();
		
		int N = sc.nextInt();
		
		for(int i=0 ; i<N ; i++) {
			int[] tmp = new int[2];
			tmp[0] = sc.nextInt();
			tmp[1] = sc.nextInt();
			
			pq.add(tmp);
		}
		
		int[] tmp = pq.poll();
		
		pq2.add(tmp[1]);
		
		while(!pq.isEmpty()) {
			tmp = pq.poll();
			
			if(pq2.peek() > tmp[0]) pq2.add(tmp[1]);
			else {
				pq2.poll();
				pq2.add(tmp[1]);
			}
		}
		
		System.out.println(pq2.size());
	}
}
