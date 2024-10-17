import java.util.*;
import java.io.*;

public class Main {
	static int[] d = {-3,3,-1,1};
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	static Map<String, Integer> map = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] curPos = new int[2];
		char[] curString = new char[9];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				char curChar = st.nextToken().charAt(0);
				curString[i * 3 + j] = curChar;
				if (curChar == '0') {
					curPos[0] = i;
					curPos[1] = j;
				}
			}
		}
		
		// map에다가 나오는 모든 경우의 수를 저장함
		map.put("123456780", -1);
		
		Queue<Case> q = new ArrayDeque<>();
		q.offer(new Case(curPos, 0, curString));
		while(!q.isEmpty()) {
			Case tmp = q.poll();
			String cur = charToString(tmp.content);
			if (cur.equals("123456780")) {
				map.put("123456780", tmp.cnt);
				break;
			}
			else if (map.containsKey(cur)) {
				if (map.get(cur) > tmp.cnt || map.get(cur) == -1)
					map.put(cur, tmp.cnt);
				continue;
			}else {
				map.put(cur, tmp.cnt);
				for (int i = 0; i < 4; i++) {
					int r = tmp.curPos[0] + dr[i];
					int c = tmp.curPos[1] + dc[i];
					// 범위안으로 이동하는 경우
					if (0<=r&&r<3&&0<=c&&c<3) {
						char[] newChar = tmp.content.clone();
						newChar[tmp.curPos[0] * 3 + tmp.curPos[1]] = newChar[r * 3 + c];
						newChar[r * 3 + c] = '0';
						q.offer(new Case(new int[] {r,c}, tmp.cnt + 1, newChar));
					}
				}
			}
		}
		
		System.out.println(map.get("123456780"));
	}
	
	public static void dfs(int curPos, int cnt, char[] charString) {
		String curString = charToString(charString);
		// 이미 해당 경우가 존재하는 경우 횟수만 갱신하고 종료 (뒤에 부분은 다른 부분과 동일하기 때문)
		if (map.containsKey(curString)) {
			if (map.get(curString) > cnt || map.get(curString) == -1)
				map.put(curString, cnt);
			return;
		// 해당 경우가 존재하지 않는 경우는 새로운 경우가 발생할 수 있음.
		}else {
			// 해당 경우의 값을 넣고 나머지 부분 4방 탐색으로 dfs 마저 돌 것.
			map.put(curString, cnt);
			// map의 위치로 확인해서 돌 수 있도록 할 것
			for (int i = 0; i < 4; i++) {
				int nextPos = curPos + d[i];
				// 범위안으로 이동하는 경우
				if (0<=nextPos&&nextPos<9) {
					charString[curPos] = charString[nextPos];
					charString[nextPos] = '0';
					dfs(nextPos, cnt + 1, charString);
					charString[nextPos] = charString[curPos];
					charString[curPos] = 0;
				}
			}
		}
	}
	
	public static String charToString(char[] charString) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++)
			sb.append(charString[i]);
		return sb.toString();
	}
}

class Case{
	public int[] curPos;
	public int cnt;
	public char[] content = new char[9];
	public Case(int[] curPos, int cnt, char[] content) {
		this.curPos = curPos;
		this.cnt = cnt;
		this.content = content;
	}
}