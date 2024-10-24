import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> big = new PriorityQueue<>();
		PriorityQueue<Integer> small = new PriorityQueue<>(Comparator.reverseOrder());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cnt; i++) {
			int curVal = Integer.parseInt(br.readLine());
			
			if (small.size() == 0 || small.peek() >= curVal)
				small.offer(curVal);
			else
				big.offer(curVal);
			
			if (big.size() + 1 < small.size())
				big.offer(small.poll());
			else if (big.size() > small.size())
				small.offer(big.poll());
			
			sb.append(small.peek()).append("\n");
		}
		System.out.println(sb);
	}
}