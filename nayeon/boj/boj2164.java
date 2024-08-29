import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

// boj2164_카드2
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Queue<Integer> queue = new LinkedList<>();
		
		int N = sc.nextInt();

		// N개 값 입력받아서 큐에 넣기
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		// 큐 값 확인
//		System.out.println(queue);
		int i = 1;
		while (queue.size() >  1) {
			// (1) 무조건 첫번째 값 삭제
			int num = queue.poll();
			// (2) 처음에는 삭제만 두번째는 마지막에 다시 추가 -> 반복 
			if(i%2 != 1)  {
				queue.add(num);
			}
			i++;
			
		}
		System.out.println(queue.peek());
			
	} // main
} // class
