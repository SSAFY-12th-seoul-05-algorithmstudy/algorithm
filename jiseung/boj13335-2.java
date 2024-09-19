import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		if(N==1) {
			System.out.println(0);
		}
		else {
			int dasom = Integer.parseInt(br.readLine());
			
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			for(int i=1;i<N;i++) {
				pq.add(Integer.parseInt(br.readLine()));
			}
			int count=0;
			
			while(true) {
				int max = pq.poll();
				if(dasom<=max) {
					pq.add(--max);
					dasom++;
					count++;
				}
				else {
					System.out.println(count);
					break;
				}
			}
		}
	}
}