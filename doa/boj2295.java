import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static int N;
	static int[] nums;
	
	static int ans;
	static boolean flag=false;
	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);

		
		N = sc.nextInt();
		
		PriorityQueue<Integer> num = new PriorityQueue<>((o1,o2)-> o2-o1);

		for(int i=0 ;i< N ; i++) {
			num.add(sc.nextInt());
		}
		
		nums = new int[N];
		for(int i=0 ;i< N ; i++) {
			nums[i]= num.poll();
		
		}
		
		ans=-1;
		
		for(int i=0 ;i <N ; i++) {
			
			find(i+1,0,nums[i]);
			ans = nums[i];
			if(flag) break;

		}
		
		
		
		
		System.out.println(ans);
	
		
	}
	
	public static void find(int idx, int count, int sum) {
	
		if(count==3) {
			
			if(sum==0) {
				
				flag = true;
			}
			return;
		}
		
		
		for(int i= idx ; i< N ;i++) {
			
			sum -= nums[i];
			if(sum >= 0) {
				find(i, count+1, sum);
			}
			sum +=nums[i];
			if(count==2) {
			
		}

	}
	

}
	
}
