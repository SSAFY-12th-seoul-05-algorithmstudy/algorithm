import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = (int) Math.pow(2,Integer.parseInt(st.nextToken()));
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		Z(N, r, c);
		System.out.println(cnt);
	}

	public static void Z(int N, int r, int c) {
		int num = N/2;
		if (N == 2) {
			cnt += (r*2+c);
		} else {
			if (c > num - 1) {
				cnt += num*num;
				c = c - (num);
			}
			if (r > num - 1) {
				cnt += 2 * num * num;
				r = r - (num);
			}
			Z(num, r, c);
		}
	}
}