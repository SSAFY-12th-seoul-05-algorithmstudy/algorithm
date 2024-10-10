import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1477 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		
		int[] rest = new int[N+2];
		
		for(int i=1 ; i<=N ; i++) {
			rest[i] = sc.nextInt();
		}
		rest[N+1] = L;
		Arrays.sort(rest);
		
		int left = 1;
		int right = L;
		
		while(left<right) {
			int mid = (left+right)/2;
			int sum = 0;
			
			for(int i=1 ; i<=N+1 ; i++) {
				if((rest[i]-rest[i-1])%mid==0) {
					sum += (rest[i]-rest[i-1])/mid-1;
				} else {
					sum += (rest[i]-rest[i-1])/mid;
				}
			}
			
			if(sum>M) {
				left = mid+1;
			} else {
				right = mid;
			}
		}
		
		System.out.println(left);
	}
}
