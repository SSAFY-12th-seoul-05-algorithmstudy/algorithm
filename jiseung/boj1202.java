import java.io.*;
import java.util.*;

public class Main {
    static class Jewel implements Comparable<Jewel>{
    	
    	int weight,value;
    	
    	Jewel(int weight,int value){
    		this.weight = weight;
    		this.value = value;
    	}

		@Override
		public int compareTo(Jewel other) {
			if(this.weight!=other.weight) {
				return Integer.compare(this.weight, other.weight);
			}
			else {
				return -Integer.compare(this.value, other.value);
			}
		}
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        List<Jewel> jewel = new ArrayList<>();
        for(int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	jewel.add(new Jewel (Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        Collections.sort(jewel);
        
        int[] bag = new int[K];
        for(int i=0;i<K;i++) {
        	bag[i]=Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(bag);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long ans = 0;
        for(int i=0,j=0;i<K;i++) {
        	while(j<N && jewel.get(j).weight<= bag[i]) {
        		pq.offer(jewel.get(j++).value);
        	}
        	if(!pq.isEmpty()) {
        		ans+=pq.poll();
        	}
        }
        System.out.println(ans);
    }
}