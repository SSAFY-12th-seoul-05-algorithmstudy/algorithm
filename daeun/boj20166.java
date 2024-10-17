import java.util.HashMap;
import java.util.Scanner;

public class boj20166 {

	static HashMap<String, Integer> hs;
	static int N, M, K;
	static char[][] map;
	static String[] word;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();// 세러
		M = sc.nextInt();// 가로
		K = sc.nextInt(); // 문자열 개수

		map = new char[N][M]; //
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
			}
		} // 입력

		hs = new HashMap<>();

		word = new String[K];// 순서대로 나중에 출력하기 위해서 배열로

		for (int i = 0; i < K; i++) {
			word[i] = sc.next();
			hs.put(word[i], 0);// 해쉬에다가 신이 좋아하는 문자열 넣고 value는 0으로 넣음
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(i, j, ""); //초기에는 빈문자열에서 부터 시작하니까
			}
		}

		for (int i = 0; i < K; i++) {
			System.out.println(hs.get(word[i]));

		} // 해쉬맵에 있는 value값을 출력한다.

	}// main

	static void dfs(int i, int j, String currword) { // 좌표와 hs인덱스 값
		if (currword.length() >= 5) { // 문자열 길이가 5이상이면 종료
			return;
		}

		currword += map[i][j];// 문자 하나씩 추가해보기

		if (hs.containsKey(currword)) {
			hs.put(currword, hs.get(currword) + 1); // 갯수 세야하니까 value에다가 1더하기
		}

		int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
		int[] dc = { 0, 0, -1, 1, -1, 1, 1, -1 }; // 상하좌우 대각선 8방

		for (int d = 0; d < 8; d++) {
			
			int nr = (i + dr[d] + N) % N; // 경계 처리
			int nc = (j + dc[d] + M) % M; // 경계 처리
			
			dfs(nr, nc, currword); //dfs 진행

		}

	}

}
