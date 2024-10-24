import java.util.PriorityQueue;
import java.util.Scanner;

public class boj1715 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        PriorityQueue<Integer> cards  = new PriorityQueue<>();
        
        for(int i=0; i<N ; i++) {
        	cards.add(sc.nextInt());
        }
        
        int answer =0;
        while(cards.size()!=1) {
        	
        	int first = cards.poll();
        	int second = cards.poll();
        	
        	answer += (first+second);
        	
        	cards.add(first+second);
        	
        	
        }
        
        
    System.out.println(answer);
        
    }
}
