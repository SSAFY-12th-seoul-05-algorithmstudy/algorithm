package baekjoon;

import java.util.LinkedList;

import java.util.Queue;

import java.util.Scanner;

public class 토마토 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int H = sc.nextInt();
		int[][][] arr = new int[N][M][H];
		Queue<int[]> q = new LinkedList<>();
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[i][j][h] = sc.nextInt();
				}
			}
		}
		int max = 0;
		int[] dx = { -1, 0, 0, 1, 0, 0 };
		int[] dy = { 0, -1, 1, 0, 0, 0 };
		int[] dz = { 0, 0, 0, 0, -1, 1 };
		int day = 0;

		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j][h] == 1) {
						q.add(new int[] { i, j, h, day });
					}
				}
			}
		}
		while (!q.isEmpty()) {
			int cur[] = q.poll();
			int y = cur[0];
			int x = cur[1];
			int z = cur[2];
			day = cur[3];
			max = Math.max(max, day);
			for (int d = 0; d < 6; d++) {
				if (y + dy[d] >= 0 && y + dy[d] < N && x + dx[d] >= 0 && x + dx[d] < M && z + dz[d] >= 0
						&& z + dz[d] < H && arr[y + dy[d]][x + dx[d]][z + dz[d]] == 0) {
					arr[y + dy[d]][x + dx[d]][z + dz[d]] = 1;
					q.add(new int[] { y + dy[d], x + dx[d], z + dz[d], day + 1 });
				}
			}
		}

		boolean allRipe = true;
		out: for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j][h] == 0) {
						allRipe = false;
						break out;
					}
				}
			}
		}

		if (!allRipe) {
			max = -1;
		}
		System.out.println(max);
	}
}