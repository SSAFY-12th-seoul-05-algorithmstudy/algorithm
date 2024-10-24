import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1715_SortCard {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());

		if (N == 1) {
			System.out.println(0);
			return;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		long ans = 0;
		while (pq.size() != 1) {
			int tmp = pq.poll() + pq.poll();

			ans += tmp;
			pq.add(tmp);

		}

		System.out.println(ans);

	}

}
