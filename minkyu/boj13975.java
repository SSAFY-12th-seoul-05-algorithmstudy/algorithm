import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int K = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			PriorityQueue<Long> pq = new PriorityQueue<>();
			for (int i = 0; i < K; i++)
				pq.offer(Long.parseLong(st.nextToken()));
			
			long sum = 0;
			while(pq.size() > 1) {
				long curSum = pq.poll() + pq.poll();
				pq.offer(curSum);
				sum += curSum;
			}
			System.out.println(sum);
		}
	}
}