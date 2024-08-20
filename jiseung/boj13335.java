import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st1 = new StringTokenizer(br.readLine()); // 전체정보
		
		int n = Integer.parseInt(st1.nextToken()); // 트럭 갯수
		int w = Integer.parseInt(st1.nextToken()); // 다리의 길이
		int L = Integer.parseInt(st1.nextToken()); // 다리의 최대하중
		
		
		Queue<Integer> queue = new LinkedList<>();
		
		// 다리를 처음에 0으로 채운다.
		for (int i=0;i<w;i++) {
			queue.add(0);
		}
		
		StringTokenizer st2 = new StringTokenizer(br.readLine()); // 트럭정보
		
		int weight = 0; // 다리의 하중 초기값 0
		int time = 0; // 모두건너는데 필요한 시간
		for (int i=0;i<n;i++) {
			int truck = Integer.parseInt(st2.nextToken());
			weight -= queue.poll();	// 맨 앞 트럭 하나 빠짐.
			if(weight+truck<=L) {// 현재 다리에 올라갈수있으면(하중+트럭무게<최대하중)
				weight += truck;	// 트럭 추가
				queue.add(truck);
				time++;
			}
			else { // 현재 다리에 트럭이 올라갈 수 없음
				while(weight+truck>L) {	// 들어갈 수 있을때까지
					queue.add(0); // 일단 0추가
					time++;	// 1칸이동
					weight += -queue.poll(); // 맨앞 뺌.
				}
				// 들어갈 수 있음.
				queue.add(truck);
				weight+=truck;
				time++;
			}
		}
		if(time!=0) {
			time+=w;
		}
		System.out.println(time);
	}
}
/*
0 0
0 7 +1
7 0 +1
0 4 +1
4 5 +1
5 0 +1
0 6 +1
*/

/*
10 100 100
10 10 10 10 10 10 10 10 10 10
9 5 5
2 2 2 2 1 1 1 1 1
*/
