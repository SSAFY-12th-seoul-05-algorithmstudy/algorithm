import java.util.*;
import java.io.*;

public class Main {
	static int[] parents;
	static List<Integer> truth;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		parents = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			parents[i] = i;
		}

		st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		truth = new ArrayList<>();

		int result = M;

		if (num > 0) {
			result = 0;
			for (int i = 0; i < num; i++) {
				truth.add(Integer.parseInt(st.nextToken()));
			}

			List<Integer>[] party = new ArrayList[M];

			for (int i = 0; i < M; i++) {
				party[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int count = Integer.parseInt(st.nextToken());

				int x = Integer.parseInt(st.nextToken());
				party[i].add(x);
				for (int j = 1; j < count; j++) {
					int y = Integer.parseInt(st.nextToken());
					union(x, y);
					party[i].add(y);
				}
			}
			for (int i = 0; i < M; i++) {
				boolean flag = true;
				for (int people : party[i]) {
					if (truth.contains(find(parents[people]))) {
						flag = false;
						break;
					}
				}
				if (flag) {
					result++;
				}
			}
		}
		sb.append(result);
		System.out.println(sb);

	}

	static int find(int x) {
		if (x != parents[x]) {
			parents[x] = find(parents[x]);
		}
		return parents[x];
	}

	static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if (truth.contains(py)) {
			int tmp = px;
			px = py;
			py = tmp;
		}

		parents[py] = px;
	}
}