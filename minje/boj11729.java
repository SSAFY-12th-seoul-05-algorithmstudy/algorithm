import java.util.Scanner;

public class boj11729 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println((int) Math.pow(2, N) - 1);
		StringBuilder result = new StringBuilder();
		HanoiTop(N, 1, 3, 2,result);
		System.out.println(result.toString());
	}

	static void HanoiTop(int N, int start, int arrive, int mid, StringBuilder result) {

		if (N == 1) {
			  result.append(start).append(" ").append(arrive).append("\n");
		}
		if (N >= 2) {
			HanoiTop(N - 1, start, mid, arrive, result);
			 result.append(start).append(" ").append(arrive).append("\n");
			HanoiTop(N - 1, mid, arrive, start,result);
		}
	}
}
