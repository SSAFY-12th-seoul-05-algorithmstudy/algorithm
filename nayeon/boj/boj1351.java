import java.util.*;
import java.io.*;

public class Main {

	static long P;
	static long Q;
	static long N;
	static HashMap<Long, Long> hash;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextLong();
		P = sc.nextLong();
		Q = sc.nextLong();

		hash = new HashMap<>();

		long result = A(N);

		System.out.println(result);

	}

	static long A(long num) {
		// 무한 수열의 기본 조건
		if (num == 0) {
			return 1;
		}

		// 이미 계산된 값이 있으면 바로 반환 -> 없다면 재귀
		if (hash.containsKey(num)) {
			return hash.get(num);
		}

		// 재귀 : num/P + num/Q 계산
		hash.put(num, A(num / P) + A(num / Q));

		return hash.get(num);
	} // main 
} // class 
