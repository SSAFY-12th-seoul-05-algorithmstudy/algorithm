import java.util.Scanner;

public class BOJ_1806 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int S = sc.nextInt();
		
		int[] arr = new int[N];
		
		for(int i=0 ; i<N ; i++) {
			arr[i] = sc.nextInt();
		}
		
		int ans = 100001;
		
		int left = 0;
		int right = 0;
		
		int sum = arr[left];
		
		while(right<N) {
			if(sum>=S) {
				ans = Math.min(ans, right-left+1);
				sum -= arr[left++];
			}  else {
				right++;
				if(right<N)	sum += arr[right];
			}
		}
		if(ans!=100001) {
			System.out.println(ans);			
		} else {
			System.out.println(0);
		}
	}
}