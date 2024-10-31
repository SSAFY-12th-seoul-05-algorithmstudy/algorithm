import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj21939 {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		Scanner sc= new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 제일 난이도 높은 뮨재룰 위한 우선순위큐
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			if (a[1] == b[1]) { // 문제 난이도 같으면
				return b[0] - a[0]; // 더 작은 문제 수 반환
			}
			return b[1] - a[1]; // 난이도 내림차순
		});

		//난이도가 제일 낮은 문제를 위한 우선순위큐
		PriorityQueue<int[]>downpq = new PriorityQueue<>((a,b)-> {
			if(a[1]==b[1]) {
				return a[0]-b[0];
			}
			return a[1]-b[1]; //난이도 오름차순
			
		});
		
		HashMap<Integer, Integer> hm = new HashMap<>();

		int N = Integer.parseInt(br.readLine());// 문제 수
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
//			
			int P = Integer.parseInt(st.nextToken()); // 문제번호
			int L = Integer.parseInt(st.nextToken()); // 난이도

			pq.add(new int[] { P, L });
			downpq.add(new int[] {P,L});
			hm.put(P, L);
		} // N 처음 있던 문제 넣어주기

		int M = Integer.parseInt(br.readLine()); // 메서드 개수

		for (int i = 0; i < M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			String command = st2.nextToken();

			if (command.equals("recommend")) {
				int x = Integer.parseInt(st2.nextToken());
				if (x == 1) {// 난이도 가장 높은 문제 추천
					while (!pq.isEmpty()) {

						int[] hard = pq.peek();

						if (hm.containsKey(hard[0]) && hm.get(hard[0])==hard[1]) {
							sb.append(hard[0]).append("\n");// [0]이 문제번호임
							break;
						}
						pq.poll();
					}
				} else  {// 난이도 가장 낮은 문제 추천
//					downpq.addAll(pq);
					while(!downpq.isEmpty()) {
						int[] easy = downpq.peek();
						if (hm.containsKey(easy[0]) && hm.get(easy[0])==easy[1]) {
							sb.append(easy[0]).append("\n");// [0]이 문제번호임
							break;
						}
						downpq.poll();
						
					}
				}
			}

			if (command.equals("add")) {// 더하는 메서드
				int P = Integer.parseInt(st2.nextToken());
				int L = Integer.parseInt(st2.nextToken());
				pq.add(new int[] { P, L });
				downpq.add(new int[] {P,L});
				hm.put(P, L);

			}

			if (command.equals("solved")) { // 풀었다는 메서드
				int P = Integer.parseInt(st2.nextToken());
				hm.remove(P); // 문제번호가 P와 일치하면 두개의 pq에서 지우기
			}

		} // M
		System.out.println(sb.toString());
	}// main

}
