import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());//tc
		for(int tc=1; tc<=T; tc++) {
			int K = Integer.parseInt(br.readLine()); //장 수
			StringTokenizer st = new StringTokenizer(br.readLine());
			PriorityQueue<Long> pq = new PriorityQueue<>(); //오름차순
			for(int i=0; i<K; i++) {
				Long num= Long.parseLong(st.nextToken()); //파일들
				pq.add(num);
			}
			
			
			long total=0;
			while(pq.size()>1) {
				long a= pq.poll();
				long b= pq.poll();
				long sum = a+b;
				total+=sum;
				pq.add(sum);
			}
			
			
			System.out.println(total);
			
			
		}//tc
	}

}
