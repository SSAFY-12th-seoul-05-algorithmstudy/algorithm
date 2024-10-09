import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class ArrIdx{
	int row;
	int col;
	public ArrIdx(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}
}

public class BOJ_2178 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] maze = new int[N][M];
		for(int r=0; r<N; r++) {
			String s= sc.next();
			for(int c=0; c<M; c++) {
				maze[r][c] = Integer.parseInt(Character.toString(s.charAt(c)));
			}
		}
		
		// 방문 표시를 남길 배열 visited
		// 거리를 계산해야 하므로 int형
		int[][] visited = new int[N][M];
		
		// 델타 배열 -> 상우하좌(시계 방향)으로 돈다
		int[] dr = {-1,0,1,0};
		int[] dc = {0,1,0,-1};
		
		// 현재 위치를 담아줄 큐
		Queue<ArrIdx> queue = new LinkedList<>();
		
		// BFS 과정
		// 1. 시작 칸을 방문한다.
		//    (1) visited에 방문 표시하기
		visited[0][0] = 1;
		//    (2) 큐에 현재 (r,c) 넣기
		queue.add(new ArrIdx(0,0));
		
		while(!queue.isEmpty()) {
			// 현재 있는 위치 확인
			ArrIdx cur = queue.peek();
			// 2. 현재 위치를 큐에서 꺼낸다.
			queue.poll();
			
			for(int dir=0; dir<4; dir++) {
				// 3. 다음 위치 = 현재 위치 + 이동할 방향
				int nr = cur.row + dr[dir];
				int nc = cur.col + dc[dir];
				
				// (1) 범위 밖을 넘어가면 그 다음 방향으로 튼다
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				// (2) 이미 방문했거나, 갈 수 없는 길이면 그 다음 방향으로 튼다
				if(visited[nr][nc] != 0 || maze[nr][nc] != 1) continue;
				
				// (3) 위 조건에 걸리지 않으면 가야하는 길이므로 방문했다는 표시를 남긴다.
				// 미로는 거리를 계산해야 하므로
				// 다음 방문 거리 = 현재 위치 거리 + 1
				visited[nr][nc] = visited[cur.row][cur.col]+1;
				// (4) 큐에 삽입
				queue.add(new ArrIdx(nr, nc));
			}
			
		} // 4. 큐가 빌 때까지 2~3 과정을 반복한다
		
		System.out.println(visited[N-1][M-1]);
	}//main
}
