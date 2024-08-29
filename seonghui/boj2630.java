import java.util.Scanner;

public class boj2630 {
//	static int size = 0;
	static int[][] grid;
	static int blue = 0;
	static int white = 0;
	static boolean chk = true;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		grid = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				grid[r][c] = sc.nextInt();
			}
		}
//		System.out.println(Arrays.deepToString(grid));
		colorCnt(0, 0, N);
		System.out.printf("%d\n%d", white, blue);

	}
	
	// (1)section이 모두 같은 색으로 칠해져 있는지 확인하는 함수
	static void colorChk(int r, int c, int size) {
		
		// 호출시 체크변수 초기화
		chk = true;

		// 첫 원소 기준으로 색종이 전체 색깔 같은지 확인
		int start = grid[r][c]; // 첫 원소
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (grid[i][j] != start) { // 첫 원소 색깔과 같지 않을경우 => 1
					chk = false;
					return;
				}
			}
		}
	}
	
	// (2) section이 모두 같은색으로 칠해질 때까지 4등분하고
	// colorChk했을 때 같은 색일 경우 => 흰색과 파란색 색종이 개수 count
	static void colorCnt(int r, int c, int size) {

		// r,c가 시작점인 색종이 section의 색이 다 같을 경우
		colorChk(r, c, size);
		
		if (chk) {
			if (grid[r][c] == 1) {
				blue++;
			} else {
				white++;
			}
			return;
		}

		size /= 2;
		colorCnt(r, c, size);
		colorCnt(r + size, c, size);
		colorCnt(r, c + size, size);
		colorCnt(r + size, c + size, size);
	}

	

}
