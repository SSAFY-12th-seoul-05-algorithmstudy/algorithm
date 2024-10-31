import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_2457 {
	static int[] month = {0,0,31,59,90,120,151,181,212,243,273,304,334};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) return o2[1] - o1[1];
				return o1[0] - o2[0];
			}
		});
		
		for(int i=0 ; i<N ; i++) {
			int start = month[sc.nextInt()] + sc.nextInt();
			int end = month[sc.nextInt()] + sc.nextInt();
			
			if(start>month[12] || end<=month[3]+1) continue;
			if(start<month[3]+1) start = month[3]+1;
			
			pq.add(new int[] {start,end});
			
		}
		
		int[] tmp = new int[2];
		if(!pq.isEmpty()) tmp = pq.poll();
		
		int start = tmp[0];
		int end = tmp[1];
		int ans = 1;
		boolean flag = true;
		if(start>month[3]+1) flag = false;
		
		while(!pq.isEmpty()) {
			int[] tmp2 = pq.poll();
			if(tmp2[0]>tmp[1]) {
				flag = false;
				break;
			} else if(tmp2[1]<=tmp[1]) {
				continue;
			} else if(tmp2[0]>end) {
				
				end = tmp[1];
				tmp = tmp2;
				ans++;
			} else if(tmp2[1]>tmp[1]) {
				tmp = tmp2;
			} 
			
			if(tmp[1]>month[12]+1) break;
		}
		if(tmp[1]<=month[12]) {
			flag = false;
		} else if(end <= month[12]) {
			ans++;
		}
		if(flag) System.out.println(ans);
		else System.out.println(0);
	}
}
