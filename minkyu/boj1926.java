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
		int rowSize = Integer.parseInt(st.nextToken());
		int colSize = Integer.parseInt(st.nextToken());
		int[][] board = new int[rowSize][colSize];
		boolean[][] hasVisited = new boolean[rowSize][colSize];
		for (int i = 0; i < rowSize; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < colSize; j++) {
				int curInfo = Integer.parseInt(st.nextToken());
				board[i][j] = curInfo;
				if (curInfo == 0)
					hasVisited[i][j] = true;
			}
		}
		int[] dr = {1,-1,0,0};
		int[] dc = {0,0,1,-1};
		int pictureCnt = 0;
		int maxArea = 0;
		
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				if (!hasVisited[i][j]) {
					pictureCnt++;
					Queue<int[]> q = new ArrayDeque<>();
					q.offer(new int[] {i,j});
					hasVisited[i][j] = true;
					int curArea = 1;
					while (!q.isEmpty()) {
						int[] tmp = q.poll();
						for (int k = 0; k < 4; k++) {
							int curPosR = tmp[0] + dr[k];
							int curPosC = tmp[1] + dc[k];
							if (0<=curPosR&&curPosR<rowSize&&0<=curPosC&&curPosC<colSize&&!hasVisited[curPosR][curPosC]) {
								q.offer(new int[] {curPosR,curPosC});
								hasVisited[curPosR][curPosC] = true;
								curArea++;
							}
						}
					}
					
					if (maxArea < curArea)
						maxArea = curArea;
				}
			}
		}
		System.out.println(pictureCnt);
		System.out.println(maxArea);
	}
}