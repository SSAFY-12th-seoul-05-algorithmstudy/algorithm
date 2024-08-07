import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj2346 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 1. 입력
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 2. 계산
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		int add = 1;

		for (int i = 0; i < n; i++) {
			// 2.1 음수인지 양수인지 확인
			add = (arr[idx] > 0) ? 1 : -1;

			// 2.2 배열 값을 0으로 변경
			int tmp = arr[idx];
			arr[idx] = 0;
			sb.append(idx + 1).append(" ");

			// 2.3 이동 및 유효성 확인
			if (i == n - 1) {
				break;
			}
			while (tmp != 0) {
				idx = move(n, idx + add);
				if (arr[idx] != 0) {
					tmp -= add;
				}
			}
		}

		// 3. 출력
		bw.write(sb.toString());

		br.close();
		bw.close();
	}

	static int move(int n, int idx) {
		return idx >= 0 ? idx % n : n + (idx % n);
	}
}
