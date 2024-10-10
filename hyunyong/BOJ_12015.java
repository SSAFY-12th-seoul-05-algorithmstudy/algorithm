import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_12015 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] nums = new int[N];
		
		for(int i=0 ; i<N ; i++) {
			nums[i] = sc.nextInt();
		}
		
		List<Integer> arr = new ArrayList<>();
		
		arr.add(nums[0]);
		
		for(int i=1 ; i<N ; i++) {
			
			if(nums[i]>arr.get(arr.size()-1)) arr.add(nums[i]);
			else {
				
			}
			int left = 0;
			int right = arr.size();
			
			while(left<right) {
				int mid = (left+right)/2;
				
				if(arr.get(mid)>=nums[i]) {
					right = mid;
				} else {
					left = mid+1;
				}
			}
			
			arr.set(left, nums[i]);
 		}
		
		System.out.println(arr.size());
	}
}
