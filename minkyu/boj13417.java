import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				char curChar = st.nextToken().charAt(0);
				if (sb.length() == 0)
					sb.insert(0, curChar);
				else {
					if (sb.charAt(0) >= curChar)
						sb.insert(0, curChar);
					else
						sb.append(curChar);
				}
			}
			System.out.println(sb);
		}
	}
}