package 알고리즘;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class boj1477 {

	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);

		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int L = sc.nextInt();
		
		PriorityQueue<Integer> where = new PriorityQueue<>((o1,o2)-> o1-o2);
		
		
		for(int i=0 ;i< N ; i++) {
			where.add(sc.nextInt());
		}
		
		where.add(L);
		
		int[] distance = new int[N+1];
		
		int first=0;
		
		int second=0;
		
		int max =0;
		for(int i=0; i< N+1 ; i++) {
			second = where.poll();
			distance[i] = second - first;
			max = Math.max(max, (second-first));
			first = second;
		}
		
		int left=1;
		int right=max;
		int answer =0;

		while(left<=right) {
			
			int mid = (left+right)/2;

			int count=N;
			
			for(int i : distance) {
				
				if(i/mid >= 1) {
					
				if(i%mid==0) count+= (i/mid)-1;			
				else{	
					count+= (i/mid);
				}
				
				}
			}

			if(count > (M+N)){
				left = mid+1;
			}else {
				right = mid-1;
				answer = mid;
			}

		}
		
		System.out.println(answer);
	
		
	}

}
