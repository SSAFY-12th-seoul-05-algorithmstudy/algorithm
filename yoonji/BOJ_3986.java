package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class BOJ_3986 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			Stack<Character> stackString = new Stack<>();
			String s = br.readLine(); 
			char[] arr = s.toCharArray();
			
			for(int j=0; j<arr.length; j++) {
				
				if(stackString.isEmpty()) { // 스택이 비어있다면
					stackString.push(arr[j]); // 스택에 원소 추가
				} else { // 비어있지 않다면 스택 안 원소와 배열 원소 비교
					if(stackString.peek() == arr[j]) { // 같다면
						stackString.pop(); // 스택 안 원소 빠져나온다
					}else { // 같지 안다면
						stackString.push(arr[j]); // 배열 원소를 스택으로 집어넣는다.
					}
					
				}
				
			} // j
			
			if(stackString.isEmpty()) {
				cnt++;
			}
			
		} // i		
		System.out.println(cnt);
	} // main
}
