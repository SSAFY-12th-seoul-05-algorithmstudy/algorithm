import java.io.IOException;
import java.util.*;

public class boj1525 {
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static String answer = "123456780";

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		String init = "";

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				init += sc.next();
			}
		}

		System.out.println(bfs(init));
	}

	public static int bfs(String start) {
		Queue<String> queue = new LinkedList<>();
		// String은 상태
		// Integer는 횟수

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		// start들어가고 , 0 횟수 들어가고
		map.put(start, 0);
		queue.add(start);

		while (!queue.isEmpty()) {

			String pos = queue.poll();

			// 숫자를 움직인다고 생각하지말고, 빈칸인 0을 움직인다고 생각하는거임
			int zero = pos.indexOf('0');
			int r = zero / 3;
			int c = zero % 3;

			// 현재 상태가 최종 정리된 키값이랑 같다면, 그때 이동 횟수를 출력
			if (pos.equals(answer))
				return map.get(pos);

			// 0이 다음에 움직일 위치에 대해서 BFS
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				// index체크
				if (nr < 0 || nc < 0 || nr >= 3 || nc >= 3)
					continue;

				int npos = nr * 3 + nc;
				char tmp = pos.charAt(npos);

				// 0이 갈 위치와 기존에 있던 숫자 조각의 위치를 바꿔줌
				String next = pos.replace(tmp, 't');
				next = next.replace('0', tmp);
				next = next.replace('t', '0');

				// 만약 한번도 나오지 못한 조합이면 큐에 넣어줌
				// 나왔던 조합이면 굳이 넣을 필요 없오
				if (!map.containsKey(next)) {
					queue.add(next);
					map.put(next, map.get(pos) + 1);
				}
			}
		}
		return -1;
	}
}
