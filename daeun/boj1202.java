import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class boj1202 {

	static int N, K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();// 보석 개수
		K = sc.nextInt(); // 가방 개수
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			if (a[0] == b[0])// 무게 같으면
				return b[1] - a[1]; // 가치 더 큰거 (내림차순)
			else
				return a[0] - b[0]; // 무게는 오름차순
		});

		for (int i = 0; i < N; i++) {
			int M = sc.nextInt(); // 보석 무게
			int V = sc.nextInt(); // 보석 가치
			pq.add(new int[] { M, V }); // 우선순위 큐에 추가
			// 뺼 때 무게는 작은거 부터 빠지고, 가치는 큰거 부터 빠지게 되어있음
		}

		List<Integer> bag = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			int C = sc.nextInt();
			bag.add(C);
		}

		Collections.sort(bag); // 오른차순 정렬

		long total = 0;
		PriorityQueue<Integer> pqfinal =  new PriorityQueue<>(Collections.reverseOrder()); //가치를 내림차순 정렬된 pq에 다시 넣음
		
		for(int i=0; i<bag.size(); i++) {//K개 만큼 돌면서
			while(!pq.isEmpty() && pq.peek()[0]<=bag.get(i)) {//pq안에 뭐 있고 보석의 무게가 현재 bag 인덱스보다 작을때
				pqfinal.add(pq.poll()[1]); //가치만 더하기
			}
			if(!pqfinal.isEmpty()) { 
				total+= pqfinal.poll();//pqfinal에 있는 것들 다 더하기
			}
		}
		
		

		System.out.println(total);

	}// main

}
