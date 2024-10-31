import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class boj1806 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int N= Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int []arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i]= Integer.parseInt(st2.nextToken());
		}
		
		
		int left = 0;
		int right = 0;
		int sum =0;
		
		int length =Integer.MAX_VALUE; // 수열의 길이
		
		while(right<N) {//배열의 끝에 도달할 떄까지
			sum+=arr[right++];
			
			
			while(sum>=S) {
				length = Math.min(right-left, length);
				sum-= arr[left++];
			}
			
		}
		if(length == Integer.MAX_VALUE) {
			System.out.println(0);
		}else 
			System.out.println(length);
		
//		System.out.println(Arrays.toString(arr));
	}//main

}
