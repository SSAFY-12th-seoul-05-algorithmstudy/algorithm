import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13975_File {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {

			int N = Integer.parseInt(br.readLine());

			PriorityQueue<Long> pq = new PriorityQueue<>();

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				pq.add(Long.parseLong(st.nextToken()));
			}

			long ans = 0;
			while (pq.size() != 1) {
				long tmp = pq.poll() + pq.poll();

				ans += tmp;
				pq.add(tmp);

			}

			sb.append(ans).append("\n");

		}
		System.out.println(sb.toString());
	}

}
