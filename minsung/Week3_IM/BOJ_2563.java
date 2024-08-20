import java.util.Scanner;

public class BOJ_2563 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[][] map = new int[100][100];
		for (int t = 0; t < N; t++) {
			int r = sc.nextInt();
			int c = sc.nextInt();

			for (int i = r; i < r + 10; i++) {
				for (int j = c; j < c + 10; j++) {
					map[i][j] = 1;
				}
			}
		}

		int ans = 0;

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] == 1)
					ans++;
			}
		}

		System.out.println(ans);

	}

}
