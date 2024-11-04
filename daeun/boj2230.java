import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj2230 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //N개의 정수
		int M = Integer.parseInt(st.nextToken());// 두 수의 차이의 최소 값
		
		int [] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr); //오름차순 정렬

		
		
		int left = 0; 
		int right = 0;
		
		int min = Integer.MAX_VALUE;
		
		while(right<N && left<N ) { //제일 오른쪽 포인터가 배열 안벗어나게
			int diff = arr[right]-arr[left]; // 두 수의 차
			
			if(diff>=M) {
				min= Math.min(min, diff);
				
				left++; //차이가 충분하니까 왼쪽 늘려서 차이 최소한으로 만드는 시도 하기}
			
			}else { //차가 M보다 적으면
				right++; //오른포인터 늘려줌(= 오른쪽으로 갈수록 수의 값이 커지니까)
			}	
			
			
		}
		
			System.out.println(min);
		
		
	}//main
}
