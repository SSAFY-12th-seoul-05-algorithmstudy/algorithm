import java.util.Scanner;

public class Main {
	static char[][] stars = {};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		stars = new char[N][N];
		saveStars(N, 0, 0);

		StringBuilder sb = new StringBuilder();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				sb.append(stars[r][c]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void saveStars(int curLevel, int startRow, int startCol) {
		if (curLevel == 1) {
			stars[startRow][startCol] = '*';
			return;
		}

		int cnt = 0;
		int nextLevel = curLevel / 3;
		for (int i = 0; i < 3; i++) {
			int curStartRow = startRow + i * nextLevel;
			for (int j = 0; j < 3; j++) {
				int curStartCol = startCol + j * nextLevel;
				// 가운데인 경우 빈 칸으로 진행
				if (i == 1 && j == 1) {
					for (int r = 0; r < nextLevel; r++) {
						for (int c = 0; c < nextLevel; c++) {
							stars[curStartRow + r][curStartCol + c] = ' ';
						}
					}
				} else
					saveStars(nextLevel, curStartRow, curStartCol);
			}
		}
	}
}