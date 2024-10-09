import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int rowCnt = Integer.parseInt(st.nextToken());
		int colCnt = Integer.parseInt(st.nextToken());
		int recCnt = Integer.parseInt(st.nextToken());
		
		// 방문여부 확인용 배열
		boolean[][] visited = new boolean[rowCnt][colCnt];
		// 직사각형 크기만큼 배열 돌기
		for (int i = 0; i < recCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int startCol = Integer.parseInt(st.nextToken());
			int startRow = Integer.parseInt(st.nextToken());
			int endCol = Integer.parseInt(st.nextToken());
			int endRow = Integer.parseInt(st.nextToken());
			
			// 이미 직사각형이 있는 곳은 방문을 하지 못하기 때문에
			// 방문했다는 표시를 해놓음
			for (int j = startRow; j < endRow; j++)
				for (int k = startCol; k < endCol; k++)
					visited[j][k] = true;
		}
		
		boolean isFound = true;
		// BFS 탐색할 방향
		int[] dr = {1,-1,0,0};
		int[] dc = {0,0, 1, -1};
		Queue<int[]> q = new ArrayDeque<>();
		// 각 빈 공간들의 크기를 저장함
		List<Integer> sizes = new ArrayList<>();
		int emptyCnt = 0;
		int curSize = 0;
		// 빈 공간이 존재하는 경우 계속 탐색 돌기
		while (isFound) {
			isFound = false;
			for (int i = 0; i < rowCnt; i++) {
				for (int j = 0; j < colCnt; j++) {
					if (!visited[i][j]) {
						isFound = true;
						emptyCnt++;
						q.offer(new int[] {i,j});
						visited[i][j] = true;
						curSize = 1;
						while(!q.isEmpty()){
							int[] tmp = q.poll();
							// 4방 탐색
							for (int k = 0; k < 4; k++) {
								// 보드 범위 안에만 탐색
								int curRow = tmp[0] + dr[k];
								int curCol = tmp[1] + dc[k];
								if (0 <= curRow && curRow < rowCnt && 
										0 <= curCol && curCol < colCnt &&
										!visited[curRow][curCol]) {
									q.offer(new int[] {curRow, curCol});
									visited[curRow][curCol] = true;
									curSize++;
								}
							}
						}
						// 탐색이 끝난 후 해당 값을 저장
						sizes.add(curSize);
					}
				}
			}
		}
		System.out.println(emptyCnt);
		Collections.sort(sizes);
		StringBuilder sb = new StringBuilder();
		for (int i = 0 ; i < sizes.size(); i++)
			sb.append(sizes.get(i)).append(" ");
		System.out.println(sb.toString().trim());
	}
}