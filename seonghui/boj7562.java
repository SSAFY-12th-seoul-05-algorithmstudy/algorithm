import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class boj7562 {
	
	static int[] dr = {-1, -1, 1, 1, -2, -2, 2, 2};
	static int[] dc = {-2, 2, -2, 2, -1, 1, -1, 1};
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int tc = 0; tc < t; tc++) {
			Queue<int[]> q = new ArrayDeque<>();
			
			cnt = 0;
			int l = sc.nextInt();
			boolean[][] visited = new boolean[l][l];
			int[] start = new int[] {sc.nextInt(), sc.nextInt(), cnt};
			int[] target = new int[] {sc.nextInt(), sc.nextInt()};
			
			
			q.offer(start);
			
			while(!q.isEmpty()) {
				int[] tmp = q.poll();
				int currRow = tmp[0];
				int currCol = tmp[1];
				int cnt = tmp[2];
				
				if(currRow == target[0] && currCol == target[1]) {
					System.out.println(cnt);
					break;
				}
				
				for(int k = 0; k < 8; k++) {
					int move_r = currRow + dr[k];
					int move_c = currCol + dc[k];
					
					if(move_r >= 0 && move_r < l && move_c >= 0 && move_c < l && !visited[move_r][move_c]) {
						q.offer(new int[] {move_r, move_c, cnt+1});
						visited[move_r][move_c] = true;
					}
				}
			}
		}// tc
	}// main
}
