import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		
		
		PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> min = new PriorityQueue<>();
		
		// 합
		int sum=0;
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			if(num>1) {
				max.add(num);
			}
			else if(num<1){
				min.add(num);
			}
			else {
				sum+=1;
			}
		}
		
		// 2개이상이면 서로 곱하기
		if(max.size()>=2) {
			while(max.size()>=2) {
				sum += max.poll()*max.poll();
			}
		}
		// 남은거 더하기
		while(!max.isEmpty()) {
			sum += max.poll();
		}
		// 2개이상이면 곱하기
		if(min.size()>=2) {
			while(min.size()>=2) {
				sum += min.poll()*min.poll();
			}
		}
		// 남은거 더하기
		while(!min.isEmpty()) {
			sum += min.poll();
		}
			
		System.out.println(sum);
	}
}