import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//애들 수
		int M = sc.nextInt();//보석 색상 수
		int[]arr= new int[M];
		
		int right=0;
		
		for(int i=0; i<M; i++) {
			arr[i] = sc.nextInt();
			right = Math.max(right, arr[i]); //색상 중 가장 보석 갯수 많은 것이 right
		}
		
		int left = 1; //보석 하나부터 나눠줄 수 있음

		
		int ans =0;
		
		while(left<=right) {
			int result=0; //결과 ,,몇명에게 나눠주는지 인원 수
			
			int mid = (right+left)/2; // 중간값: 나눠줄 수 있는 보석으로 설정
			
			for(int i=0; i<M; i++) {
				
				result += arr[i]/mid; 
				
				if(arr[i] % mid!=0) {// 안 나눠떨어지면 1명이 더 필요하니까
					result++;
				}
			}
			
			if(result>N ) { //애들 수 보다 인원 더 많으면 
				left = mid+1; 
						
			}else { //애들수보다 인원 수 적으면
				right =mid-1; // 더 작게 나눠줄 수 있는지 다시 검사
				ans = mid; //일단 가능한 최대의 값
			}
					
			
			
		}//while
		
		System.out.println(ans);
		
	}//main

}