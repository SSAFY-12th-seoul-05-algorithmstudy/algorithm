import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int rowSize;
	static int colSize;
	static char[][] board = {};
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	static int maxCnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());
		board = new char[rowSize][colSize];
		for (int r = 0; r < rowSize; r++) {
			String curLine = br.readLine();
			for (int c = 0; c < colSize; c++)
				board[r][c] = curLine.charAt(c);
		}
		
		Set<Character> set = new HashSet<>();
		set.add(board[0][0]);
		dfs(new int[] {0,0},set);
		System.out.println(maxCnt);
	}
	
	public static void dfs(int[] sta, Set<Character> chars) {
		if (maxCnt < chars.size())
			maxCnt = chars.size();
		for (int i = 0; i < 4; i++) {
			int curR = sta[0] + dr[i];
			int curC = sta[1] + dc[i];
			if (0<=curR&&curR<rowSize&&0<=curC&&curC<colSize&&!chars.contains(board[curR][curC])) {
				chars.add(board[curR][curC]);
				dfs(new int[] {curR,curC},chars);
				chars.remove(board[curR][curC]);
			}
		}
	}
}