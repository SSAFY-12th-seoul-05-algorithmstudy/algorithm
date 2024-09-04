import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class boj2178 {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int n, m;
	static int[][] map;
	static boolean[][] visited; // 탐색 확인용

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		visited = new boolean[n][m];
		map = new int[n][m];
		for(int r = 0; r < n; r++) {
			String s = sc.next();
			for(int c = 0; c < m; c++) {
				map[r][c] = Character.getNumericValue(s.charAt(c)); 
			}
		}
		
		
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{0,0}); // 시작위치
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int curRow = tmp[0];
			int curCol = tmp[1];
			
			if(curRow == n-1 && curCol == m-1) { // 도착시 값 출력
				System.out.println(map[n-1][m-1]);
				break;
			}
			
			for(int k = 0; k < 4; k++) {
				int nextRow = curRow + dr[k];
				int nextCol = curCol + dc[k];
				
				// map 범위 안에서
				if(nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m) {
					if(map[nextRow][nextCol] != 0 && !visited[nextRow][nextCol]) { // 값이 이동할 수 없는 0이 아니며, 방문안한곳
						q.offer(new int[] {nextRow, nextCol});
						visited[nextRow][nextCol] = true;
						map[nextRow][nextCol] += map[curRow][curCol]; // 이동위치에 이전 값 누적
					}
				}
			}
		}
		
	}

}