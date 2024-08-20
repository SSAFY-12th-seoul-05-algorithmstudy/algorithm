package IM;

import java.util.Scanner;

// BOJ10163 색종이 
public class boj10163 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 초기화 시킨 배열
		int[][] arr = new int[1001][1001];

		// 1. 해당 배열에서 값을 입력 받은 색종이로 위치 탐색
		for (int tc = 1; tc <= N; tc++) {
			int r = sc.nextInt();
			int c = sc.nextInt();

			int dr = sc.nextInt();
			int dc = sc.nextInt();

			for (int i = r; i < r + dr; i++) {
				for (int j = c; j < c + dc; j++) {
					// 2.tc 번호에 해당하는 위치를 tc num로 바꿔주기
					if (arr[i][j] == 0 || arr[i][j] != tc) {
						arr[i][j] = tc;
					}
				}
			}
		} // tc

		int cnt = 0;

		for (int tc = 1; tc <= N; tc++) {
			cnt = 0;
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					if (arr[i][j] == tc)
						cnt++;
				}
			}
			System.out.println(cnt);
		}

	}
}
