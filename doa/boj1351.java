import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	
	static long N;
	static int P;
	static int Q;
	static Map<Long, Long> arr;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextLong();
		P = sc.nextInt();
		Q = sc.nextInt();
		
		arr = new HashMap<>();
		arr.put(0L, 1L);
		findAn(N);
		System.out.println(arr.get(N));

	}
	public static Long findAn(long n) {
		
		if(arr.containsKey(n))
		return arr.get(n);
		
		long result = findAn(n / P) + findAn(n / Q);
        arr.put(n, result);
		
		return result;
		
	}


}
