import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int colSize = Integer.parseInt(st.nextToken());
		int rowSize = Integer.parseInt(st.nextToken());
		int levelSize = Integer.parseInt(st.nextToken());
		int[][][] tomatoes = new int[levelSize][rowSize][colSize];
		for (int lev = 0; lev < levelSize; lev++) {
			for (int r = 0; r < rowSize; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < colSize; c++) {
					tomatoes[lev][r][c] = Integer.parseInt(st.nextToken());
				}
			}
		}
		int[] dl = {1,-1,0,0,0,0};
		int[] dr = {0,0,1,-1,0,0};
		int[] dc = {0,0,0,0,1,-1};
		Queue<int[]> q = new ArrayDeque<>();
		for (int lev = 0; lev < levelSize; lev++) {
			for (int r = 0; r < rowSize; r++) {
				for (int c = 0; c < colSize; c++) {
					if (tomatoes[lev][r][c] == 1) {
						q.offer(new int[] {lev,r,c,1});
						while(!q.isEmpty()) {
							int[] tmp = q.poll();
							for (int i = 0; i < 6; i++) {
								int L = tmp[0] + dl[i];
								int R = tmp[1] + dr[i];
								int C = tmp[2] + dc[i];
								if (0<=L&&L<levelSize&&0<=R&&R<rowSize&&0<=C&&C<colSize) {
									if(tomatoes[L][R][C] == 0 || tomatoes[L][R][C] > tmp[3] + 1) {
										q.offer(new int[]{L,R,C,tmp[3] + 1});
										tomatoes[L][R][C] = tmp[3] + 1;
									}
								}
							}
						}
					}
				}
			}
		}
		
		boolean isPossible = true;
		int maxCnt = 0;
		main : for (int lev = 0; lev < levelSize; lev++) {
			for (int r = 0; r < rowSize; r++) {
				for (int c = 0; c < colSize; c++) {
					if (tomatoes[lev][r][c] == 0) {
						isPossible = false;
						break main;
					}else {
						if (maxCnt < tomatoes[lev][r][c])
							maxCnt = tomatoes[lev][r][c];
					}
				}
			}
		}
		
		if (isPossible)
			System.out.println(maxCnt - 1);
		else
			System.out.println(-1);
	}
}