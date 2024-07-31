import java.util.Scanner;
import java.util.Stack;

public class Helloworld {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine().replace("()", "K");
		
		Stack<Character> st = new Stack<>();
		int ans = 0;

		for (int i = 0; i < s.length(); i++) {
			switch(s.charAt(i)) {
				case '(':
					st.add('(');
					break;
				case 'K':
					ans += st.size();
					break;
				case ')':
					ans++;
					st.pop();	
			}
		}
		
		System.out.println(ans);
	}
}
