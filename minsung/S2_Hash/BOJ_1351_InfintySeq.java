import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ_1351_InfintySeq {
	static Map<Long, Long> hash = new HashMap<>();
	static int P, Q;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long N = sc.nextLong();
		P = sc.nextInt();
		Q = sc.nextInt();

		hash.put(0l, 1l);

		System.out.println(seq(N));


		sc.close();

	}

	static long seq(long N) {

		if (hash.containsKey(N))
			return hash.get(N);

		if (hash.containsKey(N / P) && hash.containsKey(N / Q))
			hash.put(N, hash.get(N / P) + hash.get(N / Q));

		return seq(N / P) + seq(N / Q);

	}

}
