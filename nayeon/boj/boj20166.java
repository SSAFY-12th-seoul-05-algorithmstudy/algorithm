import java.util.*;

public class Main {
	static int N, M, K;
	static char[][] arr;
	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static Map<String, Integer> map = new HashMap<>();
	static String[] stringArr;
	static int maxLength;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 격자 크기 N, M, K 입력
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		sc.nextLine(); // 개행 제거

		// 격자
		arr = new char[N][M];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextLine().toCharArray(); // 문자열을 문자 배열로 변환
		}

		// 찾을 문자열 입력 및 최대 길이 계산
		maxLength = 0;
		stringArr = new String[K];
		for (int i = 0; i < K; i++) {
			String curString = sc.nextLine();
			maxLength = Math.max(maxLength, curString.length());
			map.put(curString, 0); // (찾을 문자열, 카운트) 초기화
			stringArr[i] = curString;
		}

		char[] chars = new char[maxLength];
		// 모든 위치에서 DFS 탐색 시작
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				chars[0] = arr[i][j]; // 시작 문자 설정
				dfs(i, j, 1, chars); // DFS 호출
			}
		}

		// 결과 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < K; i++) {
			sb.append(map.get(stringArr[i])).append("\n");
		}
		System.out.println(sb);

	} // main

	public static void dfs(int x, int y, int cnt, char[] chars) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < cnt; i++) {
			sb.append(chars[i]);
		}
		String curString = sb.toString();

		// 문자열 개수 갱신
		if (map.containsKey(curString)) {
			map.put(curString, map.get(curString) + 1);
		}

		// 최대 길이에 도달하면 종료
		if (cnt == maxLength) {
			return;
		}

		for (int i = 0; i < 8; i++) {
			int r = (x + dr[i] + N) % N;
			int c = (y + dc[i] + M) % M;
			chars[cnt] = arr[r][c];
			dfs(r, c, cnt + 1, chars);
		}
	} // dfs

} // class
