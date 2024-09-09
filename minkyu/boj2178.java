import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int targetRow = Integer.parseInt(st.nextToken());
		int targetCol = Integer.parseInt(st.nextToken());
		int[][] maze = new int[targetRow][targetCol];
		boolean[][] hasVisited = new boolean[targetRow][targetCol];
		for (int i = 0; i < targetRow; i++) {
			String curLine = br.readLine();
			for (int j = 0; j < targetCol; j++) {
				int curPos = curLine.charAt(j) - '0';
				maze[i][j] = curPos;
				if (curPos == 0)
					hasVisited[i][j] = true;
			}
		}
		
		int[] dr = {1,-1,0,0};
		int[] dc = {0,0,1,-1};
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {0,0,0});
		hasVisited[0][0] = true;
		int cnt = 0;
		main : while(!q.isEmpty()) {
			int[] tmp = q.poll();
			for (int i = 0; i < 4; i++) {
				int curPosR = tmp[0] + dr[i];
				int curPosC = tmp[1] + dc[i];
				if (0<=curPosR&&curPosR<targetRow&&0<=curPosC&&curPosC<targetCol&&!hasVisited[curPosR][curPosC]) {
					if (curPosR == targetRow - 1 && curPosC == targetCol - 1) {
						cnt = tmp[2] + 1;
						break main;
					}else {						
						q.add(new int[] {curPosR, curPosC, tmp[2] + 1});
						hasVisited[curPosR][curPosC] = true;
					}
				}
			}
		}
		System.out.println(cnt + 1);
	}
}