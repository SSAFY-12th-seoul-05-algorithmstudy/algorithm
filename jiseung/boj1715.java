import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        
        for(int i=0;i<N;i++) {
        	pq.add(Integer.parseInt(br.readLine()));
        }
        
        
        int sum=0;
        while(pq.size()>1) {
        	int first = pq.poll();
        	int second = pq.poll();
        	
        	sum+=first+second;
        	
        	pq.add(first+second);
        }
        
        System.out.println(sum);
    }
}