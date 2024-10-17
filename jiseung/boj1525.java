import java.io.*;
import java.util.*;

public class Main {
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {

				String next = st.nextToken();
				sb.append(next);
			}
		}
		bfs(sb.toString());

	}

	static void bfs(String str) {
		Queue<String> queue = new ArrayDeque<>();
		Map<String, Integer> map = new HashMap<>();
		queue.offer(str);
		map.put(str, 0);

		while (!queue.isEmpty()) {
			String current = queue.poll();
			int loc = current.indexOf("0");
			int r = loc / 3;
			int c = loc % 3;

			for (int d = 0; d < 4; d++) {
				int nextr = dr[d] + r;
				int nextc = dc[d] + c;
				int move = nextr * 3 + nextc;
				if (nextr >= 0 && nextr < 3 && nextc >= 0 && nextc < 3) {
					StringBuilder next = new StringBuilder(current);
					char temp = next.charAt(move);
					next.setCharAt(loc, temp);
					next.setCharAt(move, '0');
					String nextStr = next.toString();
					if (!map.containsKey(nextStr)) {
						queue.offer(nextStr);
						map.put(nextStr, map.get(current) + 1);
					}
				}
			}
		}

		if (map.containsKey("123456780")) {
			System.out.println(map.get("123456780"));
		} else {
			System.out.println(-1);
		}

	}
}