import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static magnetic[] mag = new magnetic[4];
	static int[][] arr;
	static boolean[] rotated;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		arr = new int[4][8];
		for (int i = 0; i < 4; i++) {
			String str = br.readLine();
			for (int j = 0; j < 8; j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		
		for (int i = 0; i < 4; i++) {
			mag[i] = new magnetic(0, 2, 6);
		}
		
		int K = Integer.parseInt(br.readLine());

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());
			rotated = new boolean[4];
			rotate(num, dir);
		}

		int score = 0;
		for (int i = 0; i < 4; i++) {
			score += arr[i][mag[i].head] * (1 << i);
		}

		System.out.println(score);
	}

	public static class magnetic {
		int head;
		int right;
		int left;

		public magnetic(int head, int right, int left) {
			this.head = head;
			this.right = right;
			this.left = left;
		}
	}

	public static void rotate(int num, int dir) {
		if (rotated[num])
			return;

		else {

			rotated[num] = true;
			magnetic currentmag = mag[num];

			int nexthead = (currentmag.head - dir + 8) % 8;
			int nextright = (currentmag.right - dir + 8) % 8;
			int nextleft = (currentmag.left - dir + 8) % 8;

			// 왼쪽이 있으면 왼쪽돌리기
			if (num > 0 && !rotated[num - 1]) {

				magnetic leftmag = mag[num - 1];

				if (arr[num - 1][leftmag.right] != arr[num][currentmag.left]) {
					rotate(num - 1, -dir);
				}
			}
			// 오른쪽이 있으면 오른쪽돌리기
			if (num < 3 && !rotated[num + 1]) {
				magnetic rightmag = mag[num + 1];
				if (arr[num + 1][rightmag.left] != arr[num][currentmag.right]) {
					rotate(num + 1, -dir);
				}
			}

			// 다 돌렸으면
			mag[num].head = nexthead;
			mag[num].right = nextright;
			mag[num].left = nextleft;
		}
	}
}