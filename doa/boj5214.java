package 알고리즘;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class boj5214 {

	//N이 전체 역 개수, K가 연결하는 역 개서, M이 하이퍼튜브의 개수
	static int N;
	static int K;
	static int M;
	
	
	static List<Set> hipertube;
	static Queue<Integer> queue = new LinkedList<>();
	
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        
       
        N = sc.nextInt();
        K = sc.nextInt();
        M = sc.nextInt();
        int[][] arr = new int[K][M];
        hipertube= new ArrayList<>();
 
        
        for(int i =0 ;i<M ; i++) {
        	Set<Integer> list = new HashSet<>();
        	for(int j=0 ; j<K ;j++) {
        		list.add(sc.nextInt());
        	}
        	hipertube.add(list);
 
        }
        
        
       
        System.out.println(bfs());
    
    }
   public static int bfs() {
    

	   int count=1;
	
    	//특정 수만큼
    	boolean[] visitedStation = new boolean[N+1];
    	boolean[] visitedConnection = new boolean[hipertube.size()+1];
	
    	queue.add(N);
    	
    	if(N==1) return 1;
  
    	while(!queue.isEmpty()) {
    		int size = queue.size();
    		for(int i=0 ;i<size ; i++ ) {
    		int now = queue.poll();
    		
    		int idx =0;
  
    		for(Set<Integer> a : hipertube) {		
    			idx++;
    
    			if(visitedConnection[idx]) continue;
    
    			if(a.contains(now)) {
    				
    				visitedConnection[idx]=true; 	
    				
    				for(int c : a) {
    					if(!visitedStation[c]) {
    						if(c==1) return ++count;
    						queue.add(c);
    						visitedStation[c]=true;
    					}
    				}
    			}
    		}
    		
    		}
    		
    		count++;
    	}
    	
    	return -1;
    }
    
    }
  
