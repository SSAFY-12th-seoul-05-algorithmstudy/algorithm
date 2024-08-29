import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BOJ_2628 {
	public static void main(String[] args) {
		List<Integer> colcut = new LinkedList<>();
		List<Integer> rowcut = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			if (sc.nextInt() == 0) {
				rowcut.add(sc.nextInt());
			} else {
				colcut.add(sc.nextInt());
			}
		}
		rowcut.add(0);
		rowcut.add(M);
		colcut.add(0);
		colcut.add(N);
		rowcut.sort(null);
		colcut.sort(null);

		int rowmax = -1;

		for (int i = 0; i < rowcut.size() - 1; i++) {
			int tmp = rowcut.get(i + 1) - rowcut.get(i);
			if (tmp > rowmax) {
				rowmax = tmp;
			}
		}
		int colmax = -1;
		for (int i = 0; i < colcut.size() - 1; i++) {
			int tmp = colcut.get(i + 1) - colcut.get(i);
			if (tmp > colmax) {
				colmax = tmp;
			}
		}

		System.out.println(rowmax * colmax);

	}
}