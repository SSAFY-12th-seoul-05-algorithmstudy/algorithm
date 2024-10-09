import java.util.Scanner;
// boj2606.바이러스
public class Main {
	static int N, M, count; // 컴퓨터 수, 컴퓨터 쌍의 수
	static int[][] arr; // 연결된 컴퓨터 번호 저장
	static boolean[] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N + 1][N + 1];
		check = new boolean[N + 1];
		
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = arr[b][a] = 1;
		} // 입력 완료

		dfs(1); // 1번 컴퓨터를 통해 바이러스에 걸리게 되는 컴퓨터의 수 구하기 
		System.out.println(count);

	} // main

	static void dfs(int start) {
		// 현재 노드 방문 표시
		check[start] = true;

		for (int i = 1; i <= N; i++) {
			// 방문 X, 연결되어 있다면
			if (!check[i] && arr[start][i] == 1) {
				count++;
				dfs(i);
			}
		}

	} // dfs
	
} // class
