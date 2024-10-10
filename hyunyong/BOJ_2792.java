import java.util.Scanner;

public class BOJ_2792 {
	static int N, M;
	static int[] gem;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		gem = new int[M];
		int left = 1;
		int right = 0;
		
		for(int i=0 ; i<M ; i++) {
			gem[i] = sc.nextInt();
			if(right<gem[i]) right = gem[i];
		}
		
		while(left<right) {
			int mid = (left+right)/2;
			long sum = 0;
			
			for(int g : gem) {
				if(g%mid==0) {
					sum += g/mid;
				} else {
					sum += g/mid + 1;
				}
			}
			
			if(sum>N) {
				left = mid+1;
			} else {
				right = mid;
			} 
		}
		
		System.out.println(left);
	}
}
