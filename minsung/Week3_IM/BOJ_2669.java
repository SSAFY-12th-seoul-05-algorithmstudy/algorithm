import java.util.Scanner;

public class BOJ_2669 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] map = new int[101][101];
		for (int t = 1; t <= 4; t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();

			for (int i = a; i < c; i++) {
				for (int j = b; j < d; j++) {
					map[i][j] = 1;

				}
			}
		}
		int ans = 0;
		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {
				if (map[i][j] == 1)
					ans++;
			}
		}
		System.out.println(ans);
	}

}
