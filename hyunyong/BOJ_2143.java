import java.util.HashMap;
import java.util.Scanner;

public class BOJ_2143 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		int N = sc.nextInt();
		int[] A = new int[N+1];
		
		A[1] = sc.nextInt();
		for(int i=2 ; i<=N ; i++) {
			int a = sc.nextInt();
			A[i] = A[i-1] + a;
		}
		
		int M = sc.nextInt();
		int[] B = new int[M+1];
		
		B[1] = sc.nextInt();
		for(int i=2 ; i<=M ; i++) {
			int b = sc.nextInt();
			B[i] = B[i-1] + b;
		}
		
		long ans = 0;
		HashMap<Integer,Integer> match = new HashMap<>();
		
		for(int i=1 ; i<=N ; i++) {
			for(int j=0 ; j<i ; j++) {
				if(!match.containsKey(T-(A[i]-A[j]))) {
					match.put(T-(A[i]-A[j]), 1);					
				} else {
					match.put(T-(A[i]-A[j]), match.get(T-(A[i]-A[j]))+1);					
					
				}
			}
		}
		for(int i=1 ; i<=M ; i++) {
			for(int j=0 ; j<i ; j++) {
				if(match.containsKey(B[i]-B[j])) ans += match.get(B[i]-B[j]);
			}
		}
		
		
		
		System.out.println(ans);
	}
}