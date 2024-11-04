import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> lower = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> upper = new PriorityQueue<>();
		
		lower.add(Integer.parseInt(br.readLine()));
		sb.append(lower.peek()).append("\n");
		for(int i=1;i<N;i++) {
			int next = Integer.parseInt(br.readLine());
			
			// 짝수개
			if(i%2==1) {
				if(next<lower.peek()) {
					upper.add(lower.poll());
					lower.add(next);
				}
				else {
					upper.add(next);
				}
			}
			
			// 홀수개
			else {
				if(next>upper.peek()) {
					lower.add(upper.poll());
					upper.add(next);
				}
				else {
					lower.add(next);
				}
			}
			
			sb.append(lower.peek()).append("\n");
		}
		System.out.println(sb);
	}
}