import java.util.Scanner;

public class BOJ_2578 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[][] map = new int[5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < 25; i++) {
			int k = sc.nextInt();
			out: for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 5; c++) {
					if (map[r][c] == k) {
						map[r][c] = 0;
						break out;
					}
				}

			}
			if (bingocnt(map) >= 3) {
				System.out.println(i + 1);
				return;
			}
		}
		sc.close();

	}

	static int bingocnt(int[][] arr) {
		int result = 0;

		for (int i = 0; i < 5; i++) {
			int cnt = 0;
			for (int j = 0; j < 5; j++) {
				if (arr[i][j] == 0)
					cnt++;

			}
			if (cnt == 5)
				result++;
		}

		for (int i = 0; i < 5; i++) {
			int cnt = 0;
			for (int j = 0; j < 5; j++) {
				if (arr[j][i] == 0)
					cnt++;

			}
			if (cnt == 5)
				result++;
		}
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			if (arr[i][i] == 0)
				cnt++;

			if (cnt == 5)
				result++;
		}
		cnt = 0;
		for (int i = 0; i < 5; i++) {
			if (arr[i][4 - i] == 0)
				cnt++;

			if (cnt == 5)
				result++;
		}
		return result;
	}

}
