import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {-1,1,0,0,-1,-1,1,1};
	static int[] dc = {0,0,-1,1,-1,1,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			int colSize = Integer.parseInt(st.nextToken());
			int rowSize = Integer.parseInt(st.nextToken());
			if (colSize == 0)
				break;
			
			int[][] landInfo = new int[rowSize][colSize];
			for (int i = 0; i < rowSize; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < colSize; j++) {
					landInfo[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int landCnt = 0;
			for (int r = 0; r < rowSize; r++) {
				for (int c = 0; c < colSize; c++) {
					if (landInfo[r][c] == 1) {
						Queue<int[]> q = new ArrayDeque<>();
						q.offer(new int[] {r,c});
						landInfo[r][c] = 0;
						landCnt++;
						while(!q.isEmpty()) {
							int[] tmp = q.poll();
							for (int i = 0; i < 8; i++) {
								int curR = tmp[0] + dr[i];
								int curC = tmp[1] + dc[i];
								if (0<=curR&&curR<rowSize&&0<=curC&&curC<colSize&&landInfo[curR][curC]!=0) {
									q.offer(new int[] {curR,curC});
									landInfo[curR][curC] = 0;
								}
							}
						}
					}
				}
			}
			System.out.println(landCnt);
		}
	}
}