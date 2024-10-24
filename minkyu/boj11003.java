import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		Deque<int[]> deq = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int curVal = Integer.parseInt(st.nextToken());
			while(!deq.isEmpty() && deq.peekLast()[0] >= curVal)
				deq.pollLast();
			deq.offer(new int[] {curVal, i});
			while(!deq.isEmpty() && deq.peekFirst()[1] <= i - L)
				deq.pollFirst();
			sb.append(deq.peekFirst()[0]).append(' ');
		}
		System.out.println(sb);
	}
}