import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K;
	static char[][] arr = {};
	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static Map<String, Integer> map = new HashMap<>();
	static String[] stringArr = {};
	static int maxLength;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		for (int i = 0; i < N; i++) {
			String curLine = br.readLine();
			for (int j = 0; j < M; j++)
				arr[i][j] = curLine.charAt(j);
		}

		// 현재 문자열 저장
		maxLength = 0;
		stringArr = new String[K];
		for (int i = 0; i < K; i++) {
			String curString = br.readLine();
			maxLength = Math.max(maxLength, curString.length());
			map.put(curString, 0);
			stringArr[i] = curString;
		}

		char[] chars = new char[maxLength];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				chars[0] = arr[i][j];
				dfs(new int[] { i, j }, 1, chars);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < K; i++)
			sb.append(map.get(stringArr[i])).append("\n");
		System.out.println(sb);
	}

	public static void dfs(int[] pos, int cnt, char[] chars) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cnt; i++)
			sb.append(chars[i]);
		String curString = sb.toString();
		// 개수 갱신
		if (map.containsKey(curString))
			map.put(curString, map.get(curString) + 1);

		// 신이 좋아하는 문자열의 최대 길이에 도달하면 더 이상 찾을 필요가 없음
		if (cnt == maxLength)
			return;

		for (int i = 0; i < 8; i++) {
			int r = (pos[0] + dr[i] + N) % N;
			int c = (pos[1] + dc[i] + M) % M;
			chars[cnt] = arr[r][c];
			dfs(new int[] { r, c }, cnt + 1, chars);
		}
	}
}