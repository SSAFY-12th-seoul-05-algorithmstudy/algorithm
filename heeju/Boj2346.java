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
		int idx = 0;  // 터트릴 풍선 인덱스
		int add = 1;  // 이미 터진 풍선일때, 추가로 이동해줄 값

		for (int i = 0; i < n; i++) {
			// 2.1 음수인지 양수인지 확인
			add = (arr[idx] > 0) ? 1 : -1;

			// 2.2 배열 값을 0으로 변경
			int tmp = arr[idx];
			arr[idx] = 0;
			sb.append(idx + 1).append(" ");

			// 2.3 이동 및 유효성 확인
			if (i == n - 1) {     // 마지막 풍선이면 이동 안함
				break;
			}
			while (tmp != 0) {    // 한 칸씩 이동하면서 터지지 않은 풍선 찾기
				idx = move(n, idx + add);   // -1 or 1 이동 후, 유효한 인덱스로 변경
				if (arr[idx] != 0) {        // 해당 인덱스의 숫자가 0이면(이미 터진 풍선) -> add방향으로 추가 이동
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
		return idx >= 0 ? idx % n : n + (idx % n); // 인덱스가 0보다 작으면, 유효한 인덱스로 변경
		                                           // ex) idx = -4; 고 n = 3이면, -> 2로 변경됨
	}
}
