import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1644 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		
		boolean[] visited = new boolean[N+1];
		
		int idx = 0;
		for(int i=2 ; i<=N ; i++) {
			for(int j=2 ; i*j<=N ; j++) {
				visited[i*j] = true;
			}
			if(!visited[i]) idx++;
		}
		if(idx!=0) {
			
			int[] pnum = new int[idx];
			
			idx=0;
			for(int i=2 ; i<=N ; i++) {
				if(!visited[i]) pnum[idx++] = i; 
			}
			
			int ans = 0;
			int left = 0;
			int right = 0;
			int sum = pnum[left]; 
			
			while(right<idx) {
				if(sum==N) {
					ans++;
					sum -= pnum[left++];
				} else if(sum<N) {
					++right;
					if(right<idx) sum += pnum[right];
				} else {
					sum -= pnum[left++];
				}
			}
			System.out.println(ans);
		} else {
			System.out.println(0);
		}
		
	}
}