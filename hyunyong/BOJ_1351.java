import java.util.HashMap;
import java.util.Scanner;

public class BOJ_1351 {
	static HashMap<Long,Long> dp;
	static long N, P, Q;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		N = sc.nextLong();
		P = sc.nextInt();
		Q = sc.nextInt();
		
		dp = new HashMap<>();
		
		long ans = dpFind(N);
		System.out.println(ans);
	}
	
	static long dpFind(long n) {
		
		if(n==0) {
			dp.put(n, 1L);
			return 1;
		}
		
		if(!dp.containsKey(n/P)) {
			dpFind(n/P);
		}
		if(!dp.containsKey(n/Q)) {
			dpFind(n/Q);
		}
		
		dp.put(n, dp.get(n/P)+dp.get(n/Q));
		
		return dp.get(n);
	}
}
