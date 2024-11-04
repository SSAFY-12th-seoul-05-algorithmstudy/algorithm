import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 보석 정보 저장
		Jewel[] jewels = new Jewel[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			jewels[i] = new Jewel(w, v);
		}
		
		Arrays.sort(jewels, new Comparator<Jewel>() {
			@Override
			public int compare(Jewel o1, Jewel o2) {
				if (o1.weight == o2.weight)
					return Integer.compare(o2.value, o1.value);
				return Integer.compare(o1.weight, o2.weight);
			}
		});
		
		// 가방 정보 저장
		int[] bags = new int[K];
		for (int i = 0; i < K; i++)
			bags[i] = Integer.parseInt(br.readLine());
		Arrays.sort(bags);
		
		// 작은 가방부터 채워넣기. (무게 순으로 오름차순 정렬)
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		long ans = 0;
		int idx = 0;
		// 가방 크기 순으로 진행하며, 작은 가방에 작은 무게, 최대 가치를 가진 것들을 넣어서 진행
		for (int i = 0; i < K; i++) {
			// 현재 가방 크기에 넣을 수 있는 보석들을 모두 넣는다.
			while(idx < N && jewels[idx].weight <= bags[i])
				pq.offer(jewels[idx++].value);
			// 들어가는게 없으면 해당 가방에는 넣지 못하는 것
			// 해당 가방에 하나 넣어준다. (무게가 가장 많이 나가는 것부터 넣어줌)
			if (!pq.isEmpty())
				ans += pq.poll();
		}
		
		System.out.println(ans);
	}
	
	
}

class Jewel{
	int weight;
	int value;
	Jewel(int weight, int value){
		this.weight = weight;
		this.value = value;
	}
}