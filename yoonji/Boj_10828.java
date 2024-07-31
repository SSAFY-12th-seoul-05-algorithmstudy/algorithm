package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_10828 {
	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stackInt = new Stack<>();
		
		int N=0;
		try {
			N = Integer.parseInt(bf.readLine()); // 첫줄 명령의 수
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0; i<N; i++) { // 명령 수 만큼 실행
			try {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				String command;
				int num = 0;
				if(st.countTokens() == 2) {
					command = st.nextToken();
					num = Integer.parseInt(st.nextToken());
				} else {
					command = st.nextToken();
				}
				
				switch(command) {
					case "push":
						stackInt.push(num);
						break;
						
					case "pop":
						if(stackInt.isEmpty()) {
							System.out.println(-1);
						} else {
							System.out.println(stackInt.pop());							
						}
						break;
						
					case "size":
						System.out.println(stackInt.size());
						break;
						
					case "empty":
						if(stackInt.isEmpty()) {
							System.out.println(1);
						} else {
							System.out.println(0);
						}
						break;
						
					case "top":
						if(stackInt.isEmpty()) {
							System.out.println(-1);
						}else {
							System.out.println(stackInt.peek());							
						}
						break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
