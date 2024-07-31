import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int ans = 0;

		for (int tc = Integer.parseInt(br.readLine()); tc > 0; tc--) {
			String input = br.readLine();
			List<String> stack = new ArrayList<>();

			for (int i = 0; i < input.length(); i++) {
				//
				String s = "" + input.charAt(i);
				if (stack.size() == 0 || !stack.get(stack.size() - 1).equals(s)) {
					stack.add(s);
					continue;
				}
				stack.remove(stack.size() - 1);
			}

			if (stack.size() == 0) {
				ans++;
			}
		}
		
		br.close();

		bw.write("" + ans);
		bw.flush();
		bw.close();
	}
}
