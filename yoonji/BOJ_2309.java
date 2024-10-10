package IM_Practice;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = 9;
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int sum;
		int no1 = 0;
		int no2 = 0;
		// 뺄 2명의 난쟁이를 고른다
		out : for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				sum = 0;
				for(int m=0; m<N; m++) {
					// 나머지 7명의 난쟁이 키를 더한다
					if(arr[m] != arr[i] && arr[m] != arr[j]) {
						sum += arr[m];
					}
				}
				// 7명의 난쟁이 키가 100이라면
				if(sum == 100) {
					no1 = arr[i];
					no2 = arr[j];
					break out;
				}
			}
		} // i
		
		for(int i=0; i<N; i++) {
			if(arr[i] != no1 && arr[i] != no2) {
				System.out.println(arr[i]);
			}
		}
	}
}

