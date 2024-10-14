import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2230 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] arr = new int[N];
		
		for(int i=0 ; i<N ; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int left = 0;
		int right = 0;
		
		int ans = Integer.MAX_VALUE;
		
		while(right<N) {
			int res = arr[right] - arr[left];
			if(res>M) {
				ans = Math.min(ans, res);
				left++;
			} else if (res<M){
				right++;
			} else {
				ans = Math.min(ans, res);
				break;
			}
		}
		System.out.println(ans);
	}
}
