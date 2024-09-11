import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int boardSize = Integer.parseInt(br.readLine());
		char[][] board = new char[boardSize][boardSize];
		boolean[][] hasVisited = new boolean[boardSize][boardSize];
		for (int i = 0; i < boardSize; i++) {
			String curLine = br.readLine();
			for (int j = 0; j < boardSize; j++) {
				board[i][j] = curLine.charAt(j);
			}
		}
		int[] dr = {0,0,1,-1};
		int[] dc = {1,-1,0,0};
		Queue<int[]> q = new ArrayDeque<>();
		int groupCnt = 0;
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				// 빨간색 구역 검사
				if (board[i][j] == 'R' && !hasVisited[i][j]) {
					q.offer(new int[] {i,j});
					hasVisited[i][j] = true;
					groupCnt++;
					while(!q.isEmpty()) {
						int[] tmp = q.poll();
						for (int k = 0; k < 4; k++) {
							int curR = tmp[0] + dr[k];
							int curC = tmp[1] + dc[k];
							if (0<=curR&&curR<boardSize&&0<=curC&&curC<boardSize&&!hasVisited[curR][curC]&&board[curR][curC] == 'R') {
								q.offer(new int[] {curR,curC});
								hasVisited[curR][curC] = true;
							}
						}
					}
					
				// 초록색 구역 검사
				}else if (board[i][j] == 'G' && !hasVisited[i][j]) {
					q.offer(new int[] {i,j});
					hasVisited[i][j] = true;
					groupCnt++;
					while(!q.isEmpty()) {
						int[] tmp = q.poll();
						for (int k = 0; k < 4; k++) {
							int curR = tmp[0] + dr[k];
							int curC = tmp[1] + dc[k];
							if (0<=curR&&curR<boardSize&&0<=curC&&curC<boardSize&&!hasVisited[curR][curC]&&board[curR][curC] == 'G') {
								q.offer(new int[] {curR,curC});
								hasVisited[curR][curC] = true;
							}
						}
					}
				// 파란색 구역 검사
				}else if (board[i][j] == 'B' && !hasVisited[i][j]) {
					q.offer(new int[] {i,j});
					hasVisited[i][j] = true;
					groupCnt++;
					while(!q.isEmpty()) {
						int[] tmp = q.poll();
						for (int k = 0; k < 4; k++) {
							int curR = tmp[0] + dr[k];
							int curC = tmp[1] + dc[k];
							if (0<=curR&&curR<boardSize&&0<=curC&&curC<boardSize&&!hasVisited[curR][curC]&&board[curR][curC] == 'B') {
								q.offer(new int[] {curR,curC});
								hasVisited[curR][curC] = true;
							}
						}
					}
				}
			}
		}
		
		System.out.print(groupCnt);
		System.out.print(" ");
		hasVisited = new boolean[boardSize][boardSize];
		groupCnt = 0;
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				// 빨간색, 초록색 구역 검사
				if ((board[i][j] == 'R' || board[i][j] == 'G') && !hasVisited[i][j]) {
					q.offer(new int[] {i,j});
					hasVisited[i][j] = true;
					groupCnt++;
					while(!q.isEmpty()) {
						int[] tmp = q.poll();
						for (int k = 0; k < 4; k++) {
							int curR = tmp[0] + dr[k];
							int curC = tmp[1] + dc[k];
							if (0<=curR&&curR<boardSize&&0<=curC&&curC<boardSize&&!hasVisited[curR][curC]&&(board[curR][curC] == 'R'||board[curR][curC] == 'G')) {
								q.offer(new int[] {curR,curC});
								hasVisited[curR][curC] = true;
							}
						}
					}
					
				// 파란색 구역 검사
				}else if (board[i][j] == 'B' && !hasVisited[i][j]) {
					q.offer(new int[] {i,j});
					hasVisited[i][j] = true;
					groupCnt++;
					while(!q.isEmpty()) {
						int[] tmp = q.poll();
						for (int k = 0; k < 4; k++) {
							int curR = tmp[0] + dr[k];
							int curC = tmp[1] + dc[k];
							if (0<=curR&&curR<boardSize&&0<=curC&&curC<boardSize&&!hasVisited[curR][curC]&&board[curR][curC] == 'B') {
								q.offer(new int[] {curR,curC});
								hasVisited[curR][curC] = true;
							}
						}
					}
				}
			}
		}
		System.out.println(groupCnt);
		
	}
}