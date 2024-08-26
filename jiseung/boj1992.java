import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static boolean check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
			}
		}
		cut(arr);
		System.out.println(sb.toString());
	}
	
	// 색종이만들기에서 썼던 cut메서드
	public static void cut(int[][] arr) {
		// 배열의 길이가 1이면
		if (arr.length == 1) {
			if (arr[0][0] == 0) {
				sb.append(0);
			} else {
				sb.append(1);
			}
		} else {
			
			if (check(arr)) {
				if (arr[0][0] == 0) {
					sb.append(0);
				} else {
					sb.append(1);
				}
			} else {
				sb.append("(");
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
				sb.append(")");
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