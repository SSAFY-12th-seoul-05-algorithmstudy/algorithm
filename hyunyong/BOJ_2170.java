import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_2170 {
	static int N;
	static PriorityQueue<int[]> pq;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) {
					return o2[1] - o1[1];
				}
				return o1[0] - o2[0];
			}
		});
		
		for(int i=0 ; i<N ; i++) {
			int[] tmp = new int[2];
			tmp[0] = sc.nextInt();
			tmp[1] = sc.nextInt();
			
			
			pq.add(tmp);
		}
		
		int[] ans = pq.poll();
		
		int res = ans[1] - ans[0];
		int end = ans[1];
		
		while(!pq.isEmpty()) {
			int[] line = pq.poll();
			
			if(line[1]>end) {
				if(line[0]>end) {
					res += line[1] - line[0];
				} else {
					res += line[1] - end;
				}
				end = line[1];
			}
		}
		
		System.out.println(res);
	}
}
