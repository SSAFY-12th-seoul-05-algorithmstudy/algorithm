import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1202 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[][] jewel = new int[N][2];
		int[] bag = new int[K];
		
		
		
		for(int i=0 ; i<N ; i++) {
			jewel[i][0] = sc.nextInt();
			jewel[i][1] = sc.nextInt();
		}
		
		for(int i=0 ; i<K ; i++) {
			bag[i] = sc.nextInt();
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		
		Arrays.sort(bag);
		Arrays.sort(jewel,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) return o2[1] - o1[1];
				return o1[0] - o2[0];
			}
		});
		
		int idx = 0;
		long ans = 0;
		
		for(int i=0 ; i<K ; i++) {
			while(true) {
				if(idx==N) break;
				if(jewel[idx][0]<=bag[i]) {
					pq.add(jewel[idx++][1]);
				} else {
					break;
				}
			}
			
			if(!pq.isEmpty()) {
				ans += pq.poll();
			}
		}
		
		System.out.println(ans);
	}
}
