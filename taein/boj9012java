import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			Stack<Character> S = new Stack<>();
			String str = sc.next();
			
			for(int i=0; i<str.length(); i++) {
				
				if(S.empty())
					S.push(str.charAt(i));
				else {
					if(S.peek() != str.charAt(i) && str.charAt(i) == ')')
						S.pop();
					else
						S.push(str.charAt(i));
				}
			}
			if(S.size() == 0) {
				System.out.println("YES");
			} else
				System.out.println("NO");
		}
	}
}
