import java.util.Arrays;
import java.util.Scanner;

public class BOJ_7453 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] A = new int[N];
		int[] B = new int[N];
		int[] C = new int[N];
		int[] D = new int[N];
		
		for(int i=0 ; i<N ; i++) {
			A[i] = sc.nextInt();
			B[i] = sc.nextInt();
			C[i] = sc.nextInt();
			D[i] = sc.nextInt();
		}
		
		int[] num1 = new int[N*N];
		int[] num2 = new int[N*N];
		int idx1 = 0;
		int idx2 = 0;
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				num1[idx1++] = A[i]+B[j];
				num2[idx2++] = C[i]+D[j];
			}
		}
		
		Arrays.sort(num1);
		Arrays.sort(num2);
		
		long ans = 0;
		int left = 0;
		int right = N*N-1;
		
		while(left<N*N && right>=0) {
			int sum = num1[left] + num2[right];
			if(sum>0) {
				right--;
			} else if(sum<0) {
				left++;
			} else {
				long chkLeft = 1;
				long chkRight = 1;
				
				while(left+1<N*N && num1[left]==num1[left+1]) {
					chkLeft++;
					left++;
				}
				
				while(right-1>=0 && num2[right]==num2[right-1]) {
					chkRight++;
					right--;
				}
				ans += chkLeft*chkRight;
				left++;
				right--;
			}
		}
		
		System.out.println(ans);
	}
}
