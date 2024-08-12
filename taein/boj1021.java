import java.util.LinkedList;
import java.util.Scanner;

public class boj1021 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 큐의 크기
		int M = sc.nextInt(); // 뽑아내려는 수의 개수
		
		LinkedList<Integer> deque = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			deque.add(i); // 큐에 원소 삽입
		}
		
		int[] numArr = new int [M];
		for(int i=0; i<M; i++) {
			numArr[i] = sc.nextInt(); // 뽑아내려는 수 배열에 삽입
		}
		
		int cnt = 0;
		
		for(int i=0; i<M; i++) {
			int targetNum = numArr[i]; // 뽑아내려는 목표 숫자
			int targetIdx = deque.indexOf(targetNum); // 목표 숫자가 있는 인덱스
			
			int left = targetIdx; // 왼쪽에서 목표까지의 거리
			int right = deque.size() - targetIdx; // 오른쪽에서 목표까지의 거리
			
			if(left <= right) { // 왼쪽 이동이 더 짧음
				cnt += left;
				for(int j=0; j<left; j++) {
					deque.addLast(deque.pollFirst());
				}
			} else { // 오른쪽 이동이 더 짧음
				cnt += right;
				for(int j=0; j<right; j++) {
					deque.addFirst(deque.pollLast());
				}
			}
			
			deque.pollFirst(); // 다 옮긴 후 목표 숫자 뽑아냄
		}
		System.out.println(cnt);
	}
}
