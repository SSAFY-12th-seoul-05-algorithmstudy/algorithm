import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class boj2583 {
	static int m, n, k;
	static int[][] map;
	static int cnt = 0; // 분리된 영역 개수
	static List<Integer> list = new ArrayList<>(); // 분리된 각 영역의 넓이 저장
	static boolean[][] visited; // 탐색 확인용
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		m = sc.nextInt();
		n = sc.nextInt();
		k = sc.nextInt();
		visited = new boolean[m][n];
		map = new int[m][n];
		
		for(int i = 0; i < k; i++){
			int[] s = {sc.nextInt(), sc.nextInt()};
			int[] e = {sc.nextInt(), sc.nextInt()};
			
			// 왼쪽아래, 오른쪽위 => 왼쪽위, 오른쪽아래로 생각
			for(int r = s[1]; r < e[1]; r++) {
				for(int c = s[0]; c < e[0]; c++) {
					map[r][c] = 1; // 박스영역 체크
				}
			}
		}
		
		for(int r = 0; r < m; r++) {
			for(int c = 0; c < n; c++) {
				// 배열 값이0인 곳들을 상하좌우 탐색해서 넓이 구하기
				if(map[r][c] == 0 && !visited[r][c]) {  
					int area = bfs(r,c); // 분리된 영역 시작위치 r,c
					list.add(area);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		Collections.sort(list);
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}// main
	
	static int bfs(int r, int c) { 
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {r,c});
		visited[r][c] = true;
		int area = 1;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int curRow = tmp[0];
			int curCol = tmp[1];
			
			for(int k = 0; k < 4; k++) {
				int nextRow = curRow + dr[k];
				int nextCol = curCol + dc[k];
				
				if(nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n) {
					if(!visited[nextRow][nextCol] && map[nextRow][nextCol] == 0) {
						visited[nextRow][nextCol] = true;
						q.offer(new int[] {nextRow, nextCol});
						area++;
					}
				}
			}
		}
		return area;
	}
}
