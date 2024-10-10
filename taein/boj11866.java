import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj11866 {
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		StringBuilder rst = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		rst.append("<");
		
		for(int i=1; i<=N; i++) { // 큐에 1부터 N까지의 수 차례대로 입력
			q.add(i);
		}
		
		while(!q.isEmpty()) { // 큐가 비어버릴 때까지
			
			for(int i=0; i<K-1; i++) { // K번째 수가 나올 때 까지
				q.add(q.poll());	   // 첫번째 숫자를 마지막 숫자로 보냄
			}
			
			rst.append(q.poll());	   // K번째 수 획득
			
			if(!q.isEmpty()) {		   // 답안 형식을 충족하기 위한
				rst.append(", ");      // 억지 따옴표 붙여버리기
			}
			
		}
		
		rst.append(">");
		System.out.println(rst.toString());
	}
}