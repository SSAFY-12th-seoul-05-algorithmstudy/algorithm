import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // N
		int K = Integer.parseInt(st.nextToken()); // K

		Queue<Integer> queue = new LinkedList<>();

		// 큐에 1부터 N까지 넣음
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j < K; j++) {	//K-1개 뒤로
				queue.add(queue.poll());
			}
			sb.append(String.valueOf(queue.poll()));
			if(i<N) {
				sb.append(", ");
			}
		}
		System.out.println("<"+sb.toString()+">");
	}
}