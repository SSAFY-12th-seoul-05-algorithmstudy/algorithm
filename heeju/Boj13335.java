import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj13335 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 1. 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken()); // 다리 길이
        int l = Integer.parseInt(st.nextToken()); // 최대 하중

        Queue<Integer> run = new LinkedList<>();
        Queue<Integer> wait = new LinkedList<>();

        for (int i = 0; i < w; i++) {
            run.offer(0);
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            wait.offer(Integer.parseInt(st.nextToken()));
        }

		// 2. 계산
        int sum = 0;
        int time = 1;

        int tmp = wait.poll(); 
        sum += tmp;
        run.poll();
        run.offer(tmp);

        while (sum > 0) {
            sum -= run.poll();
            time++;
            if (!wait.isEmpty() && wait.peek() + sum <= l) {
                tmp = wait.poll();
                sum += tmp;
                run.offer(tmp);
                continue;
            }
            run.offer(0);
        }

		// 3. 출력
		bw.write(String.valueOf(time));

		br.close();
		bw.close();
	}
}
