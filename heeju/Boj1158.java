import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1158 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 1. 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Queue<Integer> que = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			que.offer(i);
		}

		// 2. 계산
		StringBuilder sb = new StringBuilder().append("<");

		int idx = 0;

		while (!que.isEmpty()) {
			idx++;
			if (idx % k == 0) {
				sb.append(que.poll());
				if (!que.isEmpty()) {
					sb.append(", ");
				}
				continue;
			}
			que.offer(que.poll());
		}

		// 3. 출력
		sb.append(">");

		bw.write(sb.toString());

		br.close();
		bw.close();
	}
}
