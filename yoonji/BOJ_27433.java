import java.util.Scanner;

public class BOJ_27433 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextLong();
		System.out.println(factorial(n));
	}
	
	static long factorial(long n) {
		
		if(n == 0)
			return 1;
		
		return n*factorial(n-1);
	}
}
