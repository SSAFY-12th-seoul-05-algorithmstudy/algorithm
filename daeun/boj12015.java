package sss;
import java.util.ArrayList;
import java.util.Scanner;

public class boj12015 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();//수열 크기
		int []arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
			
		}
		
		ArrayList<Integer> l = new ArrayList<>(); //가장 긴 증가하는 수열을 만들 리스트
		
		
		for(int num: arr) {
			int left =0;//초기에는 0
			int right = l.size(); //만들 수열 리스트의 가장 오른쪽은 사이즈와 같을 것임
			
			
			while(left<right) {
				int mid = (left+right)/2; //리스트의 중간 인덱스
				
				if(l.get(mid)<num) {//중간값보다 현재 숫자가 크면
					left = mid+1; //가장 왼쪽을 중간+1로
				}else { //중간값보다 작거나 같으면
					right = mid; //가장 중간값을 가장 오른쪽 값으로
				}
				
			}//while
			
			
			if(left<l.size()) {
				l.set(left, num);
			}else {
				l.add(num);
			}
			
		}

		System.out.println(l.size());
	}//main

}
