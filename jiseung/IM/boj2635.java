import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int next = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 처음 숫자
		int max = 0;
		int where = 0;
		for (int i = 1; i <= N; i++) {
			if (max > attach(N, i, 0)) {
				continue;
			}
			max = Math.max(max, attach(N, i, 0));
			where = i;
		}
		System.out.println(max);
		attachprint(N,where);
	}

	public static int attach(int N, int a, int count) {
		int next = 0;
		if (N < a) {
			next = a - N;
			return count + 2;
		} else {
			next = N - a;
			N = a;
			a = next;
		}
		return attach(N, a, count + 1);
	}

	public static void attachprint(int N, int a) {
		int next = 0;
		System.out.print(N + " ");
		if (N < a) {
			next = a - N;
			System.out.print(a);
			return;
		} else {
			next = N - a;
			N = a;
			a = next;
		}
		attachprint(N, a);
	}

}