import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj2164 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new LinkedList<>();

		int N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=N; i++) {
			q.add(i); // 1부터 N까지 수를 queue에 add
		}
		
		while(q.size() != 1) {
			q.poll(); // 제일 위에 있는 카드 버림
			q.add(q.poll()); // 그 다음 위에 있는 카드를 제일 아래로 옮김
		}
		
		System.out.println(q.poll());
	}
}