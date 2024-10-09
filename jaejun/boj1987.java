package boj;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class boj1987 {
	static int[][] map;
	static boolean[] alphabet;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { -1, 0, 1, 0 };
	static int max = 0;
	static int R, C;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();

		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j) - 'A';
			}
		}
		alphabet = new boolean[26];
		dfs(0,0,1);
		System.out.println(max);
	}

	static void dfs(int r, int c, int length) {
		alphabet[map[r][c]] = true;
		max = Math.max(length, max);
		for (int i = 0; i < 4; i++) {
			int or = r + dr[i];
			int oc = c + dc[i];

			if (or >= R || oc >= C || or < 0 || oc < 0 || alphabet[map[or][oc]]) {
				continue;
			}
			if (!alphabet[map[or][oc]]) {
				dfs(or, oc, length + 1);
				alphabet[map[or][oc]] = false;

			}
		}
	}
}
