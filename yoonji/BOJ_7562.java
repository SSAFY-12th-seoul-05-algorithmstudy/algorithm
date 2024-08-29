// 테케는 맞았는데 틀림
// 재귀 + visited 배열로 체크 필요

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class ChessIdx{
	int row;
	int col;
	
	ChessIdx(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}
}

public class BOJ_7562 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<T+1; tc++) {
			int I = sc.nextInt();
			
			ChessIdx start = new ChessIdx(sc.nextInt(), sc.nextInt());
			ChessIdx finish = new ChessIdx(sc.nextInt(), sc.nextInt());
			
			int[][] chess = new int[I][I];
			Queue<ChessIdx> queue = new LinkedList<>();
			
			// 나이트의 이동 방향 (왼쪽 위부터 시계방향)
			int[] dr = {-1,-2,-2,-1,1,2,2,1};
			int[] dc = {-2,-1,1,2,2,1,-1,-2};
			
			// 시작 위치가 도착 위치와 일치한다면 다음 tc로 넘어가기
			if(start.row == finish.row && start.col == finish.col) {
				System.out.println(0);
				break;
			}
			
			// 1. 나이트 현재 위치부터 시작
//			chess[start.row][start.col] = 0; -> 이미 0으로 초기화되어있어서 굳이 할 필요 없음
			queue.add(start);
			
			while(!queue.isEmpty()) {
				// 2. 큐에서 현재 위치 꺼내기
				ChessIdx cur = queue.poll();
				
				// 3. 다음 이동할 칸 확인
				for(int i=0; i<dr.length; i++) {
					int nr = cur.row + dr[i];
					int nc = cur.col + dc[i];
					
					// (1) 범위 밖이면 이동할 수 없음
					if(nr < 0 || nr >= I || nc < 0 || nc >= I) continue;
					// (2) 이미 방문했다면 이동할 수 없음
					if(chess[nr][nc] != 0) continue;
					
					// (3) 위 조건에 걸리지 않으면 이동한다 -> 거리를 찾아야 하므로
					//     다음칸 = 현재칸 + 1
					chess[nr][nc] = chess[cur.row][cur.col] + 1;
					// (4) 큐에 다음칸 정보 넣어준다
					queue.add(new ChessIdx(nr,nc));
					// (5) 원하는 도착 지점에 도착했다면 while문 빠져나오기
					if(nr == finish.row && nc == finish.col) break;
				}
			}
			System.out.println(chess[finish.row][finish.col]);
		} // tc
	}
}
