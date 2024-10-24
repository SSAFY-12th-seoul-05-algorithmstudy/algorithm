import java.util.PriorityQueue;
import java.util.Scanner;

public class boj13975 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        for(int tc=0 ;tc < T ; tc++) {
        int N = sc.nextInt();
        PriorityQueue<Long> cards  = new PriorityQueue<>();
        
        for(int i=0; i<N ; i++) {
        	cards.add(sc.nextLong());
        }
        
        Long answer =0L;
        while(cards.size()!=1) {
        	
        	Long first = cards.poll();
        	Long second = cards.poll();
        	
        	answer += (first+second);
        	
        	cards.add(first+second);
        	
        	
        }
        
        cards.clear();
    System.out.println(answer);
       }
    }
}
