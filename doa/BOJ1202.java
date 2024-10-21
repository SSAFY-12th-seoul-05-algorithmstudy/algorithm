import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1202 {

	static class jewl implements Comparable<jewl>{
		int W, V;

		public jewl(int W, int V) {
			super();
			this.W = W;
			this.V = V;
		}
		

		@Override
		public int compareTo(jewl o) {
			// TODO Auto-generated method stub
			return this.W - o.W;
		}
		
		
	}
	
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		List<jewl> jewls= new ArrayList<>();

		PriorityQueue<Integer> bags= new PriorityQueue<Integer>();
		PriorityQueue<Integer> bestV= new PriorityQueue<Integer>(Collections.reverseOrder());

		for (int i = 0; i < N; i++) {
			jewls.add(new jewl(sc.nextInt(),sc.nextInt()));
		}
		
		Collections.sort(jewls);

		for (int i = 0; i < K; i++) {
			bags.add(sc.nextInt());
		}
		

		long answer=0;
		//value 순으로 정렬, 하고,
		//bag는 낮은 순으로 정렬,
		//낮은 순서대로 value를 뽑을 때 bag 기준만 충족하면 뽑아
		
		int idx=0;
		for(int i=0 ;i< K ; i++ ) {
			
			int nowB = bags.poll();
			
			while(idx<N && jewls.get(idx).W <=nowB) {
				
				bestV.add(jewls.get(idx).V);
				idx++;
			}
				
			if(!bestV.isEmpty()) answer += bestV.poll();
			
			}
			
		

		System.out.println(answer);

	}



}
