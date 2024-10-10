
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

// boj1158_요세푸스문제
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Queue<Integer> queue = new LinkedList<>();
		
		int N = sc.nextInt();
		int K = sc.nextInt();

		// N개 값 입력받아서 큐에 넣기
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		// 큐 값 확인
//		System.out.println(queue);
		
		System.out.print("<");
		while (!queue.isEmpty()) {
				// 한 사이클 : 1부터 5까지 점차 감소
				for (int i = 1; i <= K; i++) {
					// (1) 무조건 첫번째 값 삭제, K번째 자리가 아니면 추후에 마지막 자리에 넣기
					int num = queue.poll(); 
					
					// (2) K번째 값인 경우, 값과 ', ' 출력(마지막 ,는 출력 X)
					if (i == K) {
						System.out.print(num);
						if (queue.size() != 0) {
			                System.out.print(", ");
			            }
						break;
					// (3) K번째 값이 아닌 경우, 삭제했던 값 다시 넣기	
					} else {
						queue.add(num);
					}
					
				} // for문 1 ~ K
				
			} // while문
			System.out.print(">");
			
	} // main
} // class
