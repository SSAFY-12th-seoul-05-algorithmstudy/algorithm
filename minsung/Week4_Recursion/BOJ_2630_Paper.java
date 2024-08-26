import java.util.Scanner;

public class BOJ_2630_Paper {
	static int blue = 0;
	static int white = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		Paper(map, 0, 0, N);
		System.out.println(white);
		System.out.println(blue);

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
			Paper(map, r, c, N / 2);
			Paper(map, r + N / 2, c, N / 2);
			Paper(map, r, c + N / 2, N / 2);
			Paper(map, r + N / 2, c + N / 2, N / 2);
		} else {

			if (check == 1)
				blue++;
			else
				white++;
		}

	}

}
