import java.util.NoSuchElementException;
import java.util.Scanner;

public class BOJ_4779_Kantor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {

			try {
				int N = sc.nextInt();
				System.out.println(Kantor(N));

			} catch (NoSuchElementException e) {
				break;
			}

		}

	}

	static String Kantor(int N) {

		if (N == 0) {
			return "-";
		}

		StringBuilder sb = new StringBuilder();
		sb.append(Kantor(N - 1));
		for (int i = 0; i < Math.pow(3, N - 1); i++) {
			sb.append(" ");
		}
		sb.append(Kantor(N - 1));

		return sb.toString();
	}

}
