import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class boj2295 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// 집합안 원소 수
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);//오름차순 정렬

		// x+y+z=K 를 x+y= K-z로

//		int []sum = new int[N/2];

		List<Integer> sum = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum.add(arr[i] + arr[j]);
			}
		} // x+y가 될 수 있는 값들의 
		
//		System.out.println(sum.size());
		Collections.sort(sum);// 오름 차순 정렬
		
		int result=0;
		
		for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j <N; j++) {// K-z가 최대로 될수 있는 값가장 큰거에서 가장 작은거 빼줘야 최대가 됨
				
				int gap = arr[i] - arr[j];
				int left = 0;
				int right = sum.size()-1;
				
				while (left <= right) {
					int mid = (left + right) / 2;
					
					if (gap >sum.get(mid)) { // 찾으려는 숫자가 mid보다 크면
						left = mid + 1; // 오른쪽 구간에서 다시 탐색
					} else if(gap<sum.get(mid)){
						right = mid - 1; // 아니며ㅑㄴ 왼쪽 구간에서 다시 이분탐색
						
					}else {
						result=Math.max(result, arr[i]);
						break;
					}
				} // while
			}
		} 

		
		System.out.println(result);
	}// main

}
