import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//연산 1: +1
//연산 2: *2
//최소연산 횟수 구하기
public class boj25418 {
	static int a, k;
	static int[] cnt; // 최소연산 횟수 저장 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		k = sc.nextInt();
		cnt = new int[k+1];
		
		findMinOperation(a);
		System.out.println(cnt[k]);
	}
	public static void findMinOperation(int a) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(a); // 시작 값 넣기
		
		// 탐색
		while(!q.isEmpty()) {
			int b = q.poll();
			
			if(b==k) return;
			
			if(b+1 <= k && cnt[b+1] == 0) {
				q.offer(b+1);
				cnt[b+1] = cnt[b]+1;
			}
			if(b*2 <= k && cnt[b*2] == 0) {
				q.offer(b*2);
				cnt[b*2] = cnt[b]+1;
			}
		}
	}
}