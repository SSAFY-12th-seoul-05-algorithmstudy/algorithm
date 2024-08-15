import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 자연수 N을 입력받는다.
		
		Deque<Integer> deque1 = new ArrayDeque<>();	// 덱 선언
		Deque<Integer> deque2 = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			deque1.addLast(i);
			deque2.addLast(Integer.parseInt(st.nextToken()));
		}
		// 1 2 3 4 5
		// 3 2 1 -3 -1
		
		
		int num = 0;	// 덱2의 값을 넣을 변수
		for (int i=0;i<N;i++) {
			if(i==0) {
				num = deque2.removeFirst();	// 처음에 풍선을터쳐 나온 번호를 num에 저장
				queue.add(deque1.removeFirst());
			}
			else {	// 이후부터
				if(num>0) {	// num이 양수이면
					for(int j=1;j<num;j++) {	// num만큼 풍선이동 (첫번째에서 빼서 뒤로보냄)
						deque1.addLast(deque1.removeFirst());
						deque2.addLast(deque2.removeFirst());
					}
					num = deque2.removeFirst();	// 터쳐서 나온숫자 num에 저장
					queue.add(deque1.removeFirst());	// 마지막은 터침, queue에 저장
				}
				else {	// num이 음수이면
					for(int j=1;j<-num;j++) {
						deque1.addFirst(deque1.removeLast());
						deque2.addFirst(deque2.removeLast());
					}
					num = deque2.removeLast();
					queue.add(deque1.removeLast());
				}
			}
		}
		System.out.print(queue.poll());
		while(!queue.isEmpty()) {
			System.out.print(" "+queue.poll());
		}
	}
}
