package baekjoon;

import java.util.Scanner;

public class 스위치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			arr[i] = sc.nextInt();
		}
		int stu = sc.nextInt();
		for (int i = 0; i < stu; i++) {
			int sex = sc.nextInt();
			int num = sc.nextInt();

			if (sex == 1) {
				for (int j = num; j <= N; j = j + num) {
					if (arr[j] == 1) {
						arr[j] = 0;
					} else {
						arr[j] = 1;
					}
				}
			} else {
				for (int j = 0; j < Math.min(num, N - num + 1); j++) {
					if (arr[num - j] == arr[num + j]) {
						if (arr[num - j] == 1) {
							arr[num - j] = 0;
							arr[num + j] = 0;

						} else {
							arr[num - j] = 1;
							arr[num + j] = 1;

						}
					} else {
						break;
					}
				}
			}
		}
		int cnt = 0;
		for (int i = 1; i < N; i++) {
			cnt++;
			if (cnt == 21) {
				System.out.println();
			}
			System.out.print(arr[i] + " ");
		}
		System.out.print(arr[N]);
	}
}
