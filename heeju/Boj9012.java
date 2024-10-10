import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj9012 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			// 1. 입력
			String str = br.readLine();

			// 2. 계산
			int count = 0;
			String ans = "NO";
			
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i)  == '(') {
					count++;
					continue;
				}
				count--;
				if (count < 0) {
					break;
				}
			}
			 ans = (count == 0) ? "YES" : "NO";
			
			// 3. 출력
			 sb.append(ans).append("\n");
		}

		bw.write(sb.toString());
		
		br.close();
		bw.close();
	}

}
