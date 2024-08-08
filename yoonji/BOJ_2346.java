// 메모리 초과

package Deque_Queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class Balloon{
	int num;
	int pos;
	
	public Balloon(int num, int pos) {
		super();
		this.num = num;
		this.pos = pos;
	}
}


public class BOJ_2346 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 풍선 개수
		
		Balloon[] balloons = new Balloon[N]; // 풍선 객체 배열
		Deque<Balloon> deque = new LinkedList<>();
		
		int num = 1; // 풍선 번호
		
		// 객체 배열과 deque에 각각 balloon 객체 넣어주기
		for(int i=0; i<N; i++) {
			balloons[i] = new Balloon(num++, sc.nextInt());
			deque.add(balloons[i]);
		}
		
		int[] answer = new int[N]; // 정답 담을 배열
		Balloon b = deque.pollFirst(); // 1번 풍선 꺼낸다
		int idx = 0;
		answer[idx++] = b.num;
		int position = b.pos;
		while(!deque.isEmpty()) {
			if(position >= 0) { // 양수 방향이면 앞에서 좌표만큼 뽑는다.
				// 좌표-1개 까지는 다시 뒤에 넣어준다
				for(int i=0; i<position-1; i++) {
					deque.addLast(deque.pollFirst());
				}
				// 해당하는 좌표의 풍선은 빠져나가고
				b = deque.pollFirst();
				answer[idx++] = b.num; // 풍선 번호 배열에 저장
				position = b.pos; // 좌표값 저장
			}else { // 음수 방향이면 뒤에서 좌표만큼 뽑는다.
				// |좌표|-1개 까지는 다시 앞에 넣어준다
				for(int i=0; i<Math.abs(position)-1; i++) {
					deque.addFirst(deque.pollLast());
				}
				// 해당하는 좌표의 풍선은 빠져나가고
				b = deque.pollLast();
				answer[idx++] = b.num;
				position = b.pos;
			}
		}
		
		for(int i=0; i<N; i++) {
			System.out.printf("%d ", answer[i]);
			
		}
	}
}
