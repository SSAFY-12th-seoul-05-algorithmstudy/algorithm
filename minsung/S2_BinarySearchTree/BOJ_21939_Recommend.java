import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Problem implements Comparable<Problem> {
	int P;
	int L;

	public Problem(int p, int l) {
		P = p;
		L = l;
	}

	@Override
	public int compareTo(Problem other) {
		// 난이도로 비교, 난이도가 같다면 문제 번호로 비교
		if (this.L != other.L) {
			return Integer.compare(this.L, other.L);
		} else {
			return Integer.compare(this.P, other.P);
		}
	}

}

public class BOJ_21939_Recommend {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Problem> hash = new HashMap<>();

		TreeSet<Problem> ts = new TreeSet<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			Problem pro = new Problem(P, Integer.parseInt(st.nextToken()));
			ts.add(pro);
			hash.put(P, pro);
		}

		int K = Integer.parseInt(br.readLine());

		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String action = st.nextToken();

			switch (action) {
			case "recommend":
				int opt = Integer.parseInt(st.nextToken());
				if (opt == 1) {
					System.out.println(ts.pollLast().P);
				} else {
					System.out.println(ts.pollFirst().P);

				}
				break;
			case "add":
				int P = Integer.parseInt(st.nextToken());
				int L = Integer.parseInt(st.nextToken());
				Problem pro = new Problem(P, L);
				ts.add(pro);
				hash.put(P, pro);

				break;
			case "solved":
				int p = Integer.parseInt(st.nextToken());

				ts.remove(hash.remove(p));
				break;
			}

		}

	}

}
