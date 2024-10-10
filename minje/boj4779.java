package baekjoon;

import java.util.Scanner;

public class boj4779 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextInt()) {
			int n = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			Cantor(n, sb);
			System.out.println(sb.toString());
		}

		sc.close();
	}

	static void Cantor(int N, StringBuilder sb) {
		if (N == 0) {
			sb.append('-');
			return;
		}

		Cantor(N - 1, sb);

		int length = (int) Math.pow(3, N - 1);
		for (int i = 0; i < length; i++) {
			sb.append(' ');
		}

		Cantor(N - 1, sb);
	}
}
