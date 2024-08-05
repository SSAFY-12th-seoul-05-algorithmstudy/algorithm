import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int T = sc.nextInt();
		Stack<Integer> S = new Stack<>();
		
		for(int tc=1; tc<=T; tc++) {
			int num = sc.nextInt();
			if(num != 0)
				S.push(num);
			else
				S.pop();
			
		}
		
		while(!S.empty()) {
			sum += S.pop();
		}
		System.out.println(sum);
	}
}
