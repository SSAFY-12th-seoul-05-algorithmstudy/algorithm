import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int truckCnt = Integer.parseInt(st.nextToken());
		int bridgeLength = Integer.parseInt(st.nextToken());
		int maxWeight = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Queue<Integer> trucks = new LinkedList<>();
		for (int i = 0; i < truckCnt; i++)
			trucks.offer(Integer.parseInt(st.nextToken()));

		int shortestTime = 0;
		int bridgeWeight = 0;
		// 다리 비워놓기
		Queue<Integer> bridges = new LinkedList<>();
		for (int i = 0; i < bridgeLength - 1; i++)
			bridges.offer(0);
		// 트럭개수가 브리지 길이를 넘으면 안됨.
		// 트럭 총 무게가 브리지 허옹 무게를 넘으면 안됨.
		while(!trucks.isEmpty()) {
			// 아직 다리의 무게가 괜찮은 경우
			if (trucks.peek() + bridgeWeight <= maxWeight) {
				int curWeight = trucks.poll();
				bridgeWeight += curWeight;
				bridges.offer(curWeight);
			// 다리의 무게가 안전하지 않은 경우 비워둔다.
			} else {
				bridges.offer(0);
			}
			
			// 다리 빠져나가는 차 추가
			if (bridges.size() == bridgeLength)
				bridgeWeight -= bridges.poll();
			
			shortestTime++;
		}

		while (bridges.size() != 0) {
			bridges.poll();
			shortestTime++;
		}

		System.out.println(++shortestTime);
	}
}