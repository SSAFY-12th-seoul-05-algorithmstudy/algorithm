import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10799_Stick {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		Stack<Integer> laser = new Stack<>();
		Stack<Integer> stick = new Stack<>();

		int[] laserP = new int[str.length()];
		int index = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				if (laser.empty()) {
					laser.push(1);
				}

			} else if (str.charAt(i) == ')') {
				if (!laser.empty()) {
					laserP[index++] = i;
					laser.pop();
				}
			}
		}
		
		
	
	}

}
