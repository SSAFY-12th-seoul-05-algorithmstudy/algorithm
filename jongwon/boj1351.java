import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class boj1351 {
	static Map<Long, Long> A;
	static long p, q;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		p = sc.nextLong();
		q = sc.nextLong();
		A = new HashMap<>();
		A.put(0L, 1L);

		long answer = dp(n);

		System.out.println(answer);

		sc.close();

	}

	static long dp(long n) {

		if (n == 0) {
			return 1;
		}
		if (A.containsKey(n)) {
			return A.get(n);
		} else {
			A.put(n, dp(n / p) + dp(n / q));
			return A.get(n);
		}
	}
}
