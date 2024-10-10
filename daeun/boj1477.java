import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 현재 휴게소 개수
		int M = sc.nextInt(); // 더 지을 휴게소 개수
		int L = sc.nextInt();// 고속도리 길이

		
		int[] road = new int[N+2];
		road[N+1] = L;
		
		for(int i=1; i<=N; i++) {
			road[i] = sc.nextInt();
		}
		
		
		Arrays.sort(road);//오름차순 정렬
		
		int left = 1;
		int right = L-1; // 문제에서 범위 주워짐
		
		
		while(left<=right) {
			int mid = (left+right)/2; // 현재의 가능한 최대 간격
			int cnt = 0; //세운 휴개소 개수
			for(int i=0; i<=N; i++) {
				int dist = road[i+1]-road[i]-1; //거리 차
				
				cnt+= dist / mid; //mid 간격에서 휴게소 몇개 세울수 있는지 세기
		
			}
			
			if(cnt>M) {//세운숫자가 M보다 많으면 ,,너무 촘촘히 세웠으니까
				
				left= mid+1;//조정해서 더 큰 간격으로 탐색
				
			}else {//세운게 M보다 적거나 같으면 
				
				right = mid-1;
				
			}
			
	
		}//while 
		
		System.out.println(left);
		
	}// main

}
