import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj10163_2 {

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
        Map<Integer, Integer> map = new HashMap<>(); // 색종이 순서 : 면적

		for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			for (int j = r; j < r + w; j++) { // 사각형 넓이 채우기
				for (int k = c; k < c + h; k++) {
					if (arr[j][k] != 0) { // 해당 위치에 사각형이 존재할 때
						int key = arr[j][k];
						map.put(key, map.get(key) - 1);
					}
					arr[j][k] = i;
				}
			}
			map.put(i, w * h);
		}

		// 3. 출력
		for (int a : map.values()) {
			sb.append(a).append("\n");
		}

		bw.write(sb.toString());

		br.close();
		bw.close();
	}
}
