package 백준;

import java.util.Scanner;

public class 바이러스 {
	static int[][] arr;
	static int res;
	static int computer;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		computer = sc.nextInt();
		int connection = sc.nextInt();
		arr = new int[computer + 1][computer + 1];
		visited = new boolean[computer + 1];
		for (int i = 0; i < connection; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b]++;
			arr[b][a]++;
		}
		res = 0;
		dfs(1);
		System.out.println(res);
	}

	static void dfs(int start) {
		for (int i = 1; i <= computer; i++) {
			if (arr[start][i] == 1 && (visited[start] == false || visited[i] == false)) {
				visited[start] = true;
				visited[i] = true;
				arr[start][i] = 0;
				arr[i][start] = 0;
				res += 1;
				dfs(i);
			}
		}
	}
}