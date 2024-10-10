import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2295 {
	static int N;
	static int[] num, sum;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		num = new int[N];
		
		for(int i=0 ; i<N ; i++) {
			num[i] = sc.nextInt();
		}
		Arrays.sort(num);
		
		sum = new int[N*N];
		int idx = 0;
		for(int i=0 ; i<N ; i++) {
			for(int j=i ; j<N ; j++) {
				sum[idx++] = num[i] + num[j];
			}
		}
		
		
		Arrays.sort(sum);
		int ans = 0;
		
		out :
		for(int i=N-1 ; i>=0 ; i--) {
			for(int j=0 ; j<i ; j++) {
				if(binarySearch(num[i]-num[j])) {
					ans = num[i];
					break out;
				}
			}
		}
		
		System.out.println(ans);
	}

	
	static boolean binarySearch(int target) {
		int left = 0;
		int right = N*N-1;
		while(left<=right) {
			int mid = (left+right)/2;
			if(target>sum[mid]) {
				left = mid+1;
			} else if(target<sum[mid]) {
				right = mid-1;
			} else {
				return true;
			}
		}
		
		return false;
	}
}
