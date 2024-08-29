import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// 상 우 하 좌 순으로 꺾어야한다.
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int C = Integer.parseInt(st.nextToken());	// 컬럼
		int R = Integer.parseInt(st.nextToken());	// 로우

		int[][] arr = new int[R][C];

		int r = R-1; // 로우
		int c = 0; // 컬럼
		int d = 0; // 델타 0상 1우 2하 3좌
		int cnt = 0; // 1부터 찍을거다.

		while (cnt < R * C) { // cnt가 N*N이될때까지 돌리고 종료
			cnt++;
			arr[r][c] = cnt;
			if (r + dr[d] < R && c + dc[d] < C && r + dr[d] >= 0 && c + dc[d] >= 0) { // 델타를 적용한 좌표가 밖으로 나가지 않을 때 델타를 적용
				if (arr[r + dr[d]][c + dc[d]] != 0) { // 델타를 쭉 돌다가 0이아닌 값을 만나면
					d = (d + 1) % 4; // 90도 회전!
					r = r + dr[d];
					c = c + dc[d];
				} else {
					r = r + dr[d];
					c = c + dc[d];
				}
			} else { // 델타를 더한 값이 배열의 범위를 넘어가면
				d = (d + 1) % 4; // 90도 회전!
				r = r + dr[d];
				c = c + dc[d];
			}
		}
		int target = Integer.parseInt(br.readLine());
		boolean found = false;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(arr[i][j]==target) {
					System.out.println((j+1)+" "+(R-i));
					found=true;
				}
			}
		}
		if (!found) {
			System.out.println(0);
		}
	}
}