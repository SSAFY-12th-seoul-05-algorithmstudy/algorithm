package study_스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj3986 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//단어 수 받기
		int T = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		for(int tc=0; tc< T; tc++) {
			//Stack 배열? 받기?
			Stack<Character> stack = new Stack<>();
			String line = br.readLine();
			
			//짝 지어야 해서 짝수만 가능함.
			if(line.length()%2!=0) {
				continue;	
			}
			
			for(int i=0; i <line.length(); i++) {
				if(stack.isEmpty()) {//스택에 아무 것도 없을 때는 넣어줘야함!!
					stack.push(line.charAt(i));
				}else {
					if(stack.peek()==line.charAt(i)) {//peek으로 최상단에 있는 거 확인해서 넣어야 할 것과 같을 때는 꺼내줌
						stack.pop();
					}else {//최상단에 있는 거랑 다를 때는 넣어줌.
						stack.push(line.charAt(i));
					}
				}
				
			}
				if(stack.isEmpty()) {
					cnt++;
				}//스택이 비어있으면 좋은 단어이니까 cnt++해줌~~!!
			}
		System.out.println(cnt);

	}

}
