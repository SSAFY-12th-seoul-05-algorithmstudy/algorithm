import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int count=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs(A,K));
	}
	
	public static int bfs(int start,int end) {
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[2*end+1];
		
		queue.offer(new int[] {start,0});
		visited[start]=true;
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int number = current[0];
			int steps = current[1];
			
			if(number == end){
				return steps;
			}
			if (number*2 <=end && !visited[number*2]) {
				queue.offer(new int[] {number*2,steps+1});
				visited[number*2]=true;
			}
			if (number+1<=end && !visited[number+1]) {
				queue.offer(new int[] {number+1,steps+1});
				visited[number+1]=true;
			}
		}
		return -1;
	}
}