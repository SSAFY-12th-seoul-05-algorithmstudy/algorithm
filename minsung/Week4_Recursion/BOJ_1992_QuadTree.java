import java.util.Scanner;

public class BOJ_1992_QuadTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		Paper(map, 0, 0, N);

	}

	static void Paper(int[][] map, int r, int c, int N) {
		int check = map[r][c];
		boolean flag = false;
		out: for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[r + i][c + j] != check) {
					flag = true;
					break out;
				}
			}
		}

		if (flag) {
			System.out.print("(");
			Paper(map, r, c, N / 2);
			Paper(map, r, c + N / 2, N / 2);
			Paper(map, r + N / 2, c, N / 2);
			Paper(map, r + N / 2, c + N / 2, N / 2);
			System.out.print(")");
		} else {

			if (check == 1) {
				System.out.print(1);
			} else {
				System.out.print(0);

			}
		}

	}
}