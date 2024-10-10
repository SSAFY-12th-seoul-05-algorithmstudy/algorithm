import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10158 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		int time = Integer.parseInt(br.readLine());

		// 주기가 있음
		// 가로로만 봤을때 2w시간 후 (방향까지 같게) 제자리로 복귀
		// 세로로만 봤을때 2h시간 후 (방향까지 같게) 제자리로 복귀

		// 그러므로 time 의 나머지를 각각 구한다.

		int moveX = time % (2 * w);
		int moveY = time % (2 * h);

		// 가로만 따로 생각
		int nx = x;
		int dx = 1;
		for (int i = 0; i < moveX; i++) {
			if (nx + dx >= 0 && nx + dx <= w) {
				nx = nx + dx;
				continue;
			} else {
				// 벽에 막히면 방향 전환ㅁ
				dx *= -1;
				nx = nx + dx;
			}

		}

		// 세로만 따로 생각
		int ny = y;
		int dy = 1;
		for (int i = 0; i < moveY; i++) {
			if (ny + dy >= 0 && ny + dy <= h) {
				ny = ny + dy;
				continue;
			} else {
				// 벽에 막히면 방향 전환ㅁ
				dy *= -1;
				ny = ny + dy;
			}

		}

		System.out.println(nx + " " + ny);

		br.close();
	}

}
