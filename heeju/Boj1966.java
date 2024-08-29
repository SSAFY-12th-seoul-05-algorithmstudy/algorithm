import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1966 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			// 1. 입력
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			Queue<int[]> que = new LinkedList<>();
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				que.offer(new int[] { tmp, i });
				arr[i] = tmp;
			}

			// 2. 계산
			Arrays.sort(arr);
			int count = 0;

			loop: for (int i = n - 1; i >= 0; i--) {
				while(true) {
					int[] tmp = que.poll();
					if (tmp[0] == arr[i]) { // 우선순위가 가장 높을 때
						count++;
						if (tmp[1] == m) {  // 궁금한 문서 일 때
							break loop;
						}
						break;
					}
					que.offer(tmp);         // 우선순위가 낮을 때
				}
			}
			
			// 3. 출력
			sb.append(count).append("\n");
		}

		bw.write(sb.toString());

		br.close();
		bw.close();
	}
}
