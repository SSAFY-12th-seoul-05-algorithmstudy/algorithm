import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj10163_1 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 1. 입력
		int n = Integer.parseInt(br.readLine()); 
        final int LEN = 1001;

		// 2. 계산
        int[][] arr = new int[LEN][LEN];

		for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			for (int j = r; j < r + w; j++) { // 사각형 넓이 채우기
				for (int k = c; k < c + h; k++) {
					arr[j][k] = i;
				}
			}
		}

		// 3. 출력
		for (int i = 1; i <= n; i++) {
			int count = 0;
            for (int r = 0; r < LEN; r++) {
                for (int c = 0; c < LEN; c++) {
                    if (arr[r][c] == i) {
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
		}

		bw.write(sb.toString());

		br.close();
		bw.close();
	}
}
