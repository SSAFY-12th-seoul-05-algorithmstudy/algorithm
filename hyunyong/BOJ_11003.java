import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_11003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] num = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0 ; i<N ; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Deque<Integer> deque = new ArrayDeque<>();
		
		for(int i=0 ; i<N ; i++) {
			if(i>=L && num[i-L]==deque.peekFirst()) {
				deque.pollFirst();
			}
			if(deque.size()==0) {
				deque.addLast(num[i]);
			} else {
				while(!deque.isEmpty() && deque.peekLast()>num[i]) {
					deque.pollLast();
				}
				deque.addLast(num[i]);
			}
			sb.append(deque.peekFirst()).append(" ");
		}
		
		System.out.println(sb);
	}
}
