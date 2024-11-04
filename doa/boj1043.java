package 알고리즘;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class boj1043 {

	static int M;
	static int N;
	static Set<Integer> cantLie;
	static List<Set<Integer>> party;
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        party = new ArrayList<>();
        
        N = sc.nextInt();
        M = sc.nextInt();
        
        int N1 = sc.nextInt();
        cantLie = new HashSet<>();
        
        for(int i=0;i<N1 ; i++) {
        	cantLie.add(sc.nextInt());
        }
        
        
        for(int i=0;i<M ; i++) {
        	int N2= sc.nextInt();
        	Set<Integer> parties = new HashSet<>();
        	 for(int j=0;j<N2 ; j++) {
        	parties.add(sc.nextInt());

        }
        	 party.add(parties);

        }
        
 
        System.out.println(M-bfs());
    
    }
   public static int bfs() {
    	
	   int count=0;
    	Queue<Integer> queue = new LinkedList<>();
	
    	//특정 수만큼
    	boolean[] visitedPeople = new boolean[N+1];
    	boolean[] visitedParty = new boolean[M+1];

    	for(int a : cantLie) {
    		visitedPeople[a]=true;
    	}
    	
    	queue.addAll(cantLie);
    	
    	while(!queue.isEmpty()) {
    		
    		int now = queue.poll();
    		int idx =0;
   
    		for(Set<Integer> a : party) {
    			idx++;
    
    			if(visitedParty[idx]) continue;
    
    			if(a.contains(now)) {
    				count++;
    				visitedParty[idx]=true;
    				cantLie.addAll(a);    	
    				
    				for(int c : a) {
    					if(!visitedPeople[c]) {
    						queue.add(c);
    						visitedPeople[c]=true;
    					}
    				}
    			}
    		}
    		
    	}
    	
    	return count;
    }
    
    }
  
