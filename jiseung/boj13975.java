import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			PriorityQueue<Long> pq = new PriorityQueue<>();
			
			int N =Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				pq.add(Long.parseLong(st.nextToken()));
			}

			long sum = 0;
			while (pq.size() > 1) {
				long first = pq.poll();
				long second = pq.poll();

				sum += first + second;

				pq.add(first + second);
			}
			
			sb.append(sum).append("\n");
		}
		System.out.print(sb);
	}
}