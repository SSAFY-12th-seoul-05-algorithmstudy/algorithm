package 알고리즘;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class boj12015 {

	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);

		
		int N = sc.nextInt();

		int[] arr = new int[N];
		
		List<Integer> list = new ArrayList<>();
		
		
		for(int i=0 ;i< N ; i++) {
			arr[i] = sc.nextInt();
		}


		list.add(arr[0]);
		
for(int i=1 ;i<N ; i++) {

	int left=0;
	int right=list.size();

		while(left<right) {
			int mid = (left+right)/2;

			if(list.get(mid)<arr[i]) left = mid+1;
			else right = mid;
		}
		
		if(left<list.size()) {
			list.set(left, arr[i]);
		}else {
			list.add(arr[i]);
		}
		
		
}

		System.out.println(list.size());
	
		
	
	}

}
