import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 나이트 이동경로 비교
		int[] dr = { 1, 2, 2, 1, -1, -2, -2, -1 };
		int[] dc = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int boardSize = Integer.parseInt(br.readLine());
			boolean[][] visitBoardCheck = new boolean[boardSize][boardSize];
			
			int[] curKnightPos = new int[2];
			st = new StringTokenizer(br.readLine());
			curKnightPos[0] = Integer.parseInt(st.nextToken());
			curKnightPos[1] = Integer.parseInt(st.nextToken());

			int[] tarKnightPos = new int[2];
			st = new StringTokenizer(br.readLine());
			tarKnightPos[0] = Integer.parseInt(st.nextToken());
			tarKnightPos[1] = Integer.parseInt(st.nextToken());
			
			// r, c, 최단회수 순으로 정렬
			Queue<int[]> queue = new ArrayDeque<>();
			// 첫 위치 방문 및 기억
			queue.add(new int[] {curKnightPos[0], curKnightPos[1], 0});
			visitBoardCheck[curKnightPos[0]][curKnightPos[1]] = true;
			while(!queue.isEmpty()) {
				int[] curInfo = queue.poll();
				// 현재 위치가 같은 경우 작성
				if (curInfo[0] == tarKnightPos[0] && curInfo[1] == tarKnightPos[1]) {
					System.out.println(curInfo[2]);
					break;
				}
				
				int curR = 0;
				int curC = 0;
				for (int i = 0; i < 8; i++) {
					curR = curInfo[0] + dr[i];
					curC = curInfo[1] + dc[i];
					if (0 <= curR && curR < boardSize && 0 <= curC && curC < boardSize) {
						// 방문하지 않은 곳인 경우
						if (!visitBoardCheck[curR][curC]) {
							visitBoardCheck[curR][curC] = true;
							queue.add(new int[] {curR, curC, curInfo[2] + 1});
						}
					}
				}
			}
		}
	}
}