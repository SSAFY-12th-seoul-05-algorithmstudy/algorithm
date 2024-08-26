import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean check;
	static int white = 0;
	static int blue = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cut(arr);
		System.out.println(white);
		System.out.println(blue);
	}

	public static void cut(int[][] arr) {
		if (arr.length == 1) {
			if (arr[0][0] == 0) {
				white++;
			} else {
				blue++;
			}
		} else {
			if (check(arr)) {
				if (arr[0][0] == 0) {
					white++;
				} else {
					blue++;
				}
			} else {
				int[][] arr1 = new int[arr.length / 2][arr.length / 2];
				int[][] arr2 = new int[arr.length / 2][arr.length / 2];
				int[][] arr3 = new int[arr.length / 2][arr.length / 2];
				int[][] arr4 = new int[arr.length / 2][arr.length / 2];

				for (int i = 0; i < (arr.length) / 2; i++) {
					for (int j = 0; j < (arr.length) / 2; j++) {
						arr1[i][j] = arr[i][j];
					}
				}
				cut(arr1);

				for (int i = 0; i < (arr.length) / 2; i++) {
					for (int j = 0; j < (arr.length) / 2; j++) {
						arr2[i][j] = arr[i][j + (arr.length) / 2];
					}
				}
				cut(arr2);
				for (int i = 0; i < (arr.length) / 2; i++) {
					for (int j = 0; j < (arr.length) / 2; j++) {
						arr3[i][j] = arr[i + (arr.length) / 2][j];
					}
				}
				cut(arr3);
				for (int i = 0; i < (arr.length) / 2; i++) {
					for (int j = 0; j < (arr.length) / 2; j++) {
						arr4[i][j] = arr[i + (arr.length) / 2][j + (arr.length) / 2];
					}
				}
				cut(arr4);
			}
		}
	}

	public static boolean check(int[][] arr) {
		check = true;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] == arr[0][0]) {
					check = true;
				} else {
					check = false;
					break;
				}
			}
			if (!check) {
				break;
			}
		}
		return check;
	}
}