import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class boj1926 {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int n, m;
	static int[][] map;
	static boolean[][] visited; // 탐색 확인용
	static int cnt; // 그림의 개수
	static int max = 0; // 그림 넓이 최대값(그림 하나도 없는 경우 0)

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 필요한 정보 세팅
		n = sc.nextInt();
		m = sc.nextInt();
		visited = new boolean[n][m];
		map = new int[n][m];
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < m; c++) {
				map[r][c] = sc.nextInt(); 
			}
		}
		
		// 그림 탐색
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < m; c++) {
				if(map[r][c] == 1 && !visited[r][c]) {
					int area = bfs(r,c);
					max = Math.max(max, area);
					cnt++;
				}
			}
		}
		System.out.printf("%d\n%d", cnt, max);
		
	}// main
	
	static int bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{r,c});
		visited[r][c] = true;
		int area = 1;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int curRow = tmp[0];
			int curCol = tmp[1];
			
			for(int k = 0; k < 4; k++) {
				int nextRow = curRow + dr[k];
				int nextCol = curCol + dc[k];
				
				// map 범위 밖이면 pass
				if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m) continue; 
				
				// 그림그려져있고, 방문한적없으면 => area+1
				if(map[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
					q.offer(new int[] {nextRow, nextCol});
					visited[nextRow][nextCol] = true;
					area++;
				}
			}
		}
		return area;
	}

}