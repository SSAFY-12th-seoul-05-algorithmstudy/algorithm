import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj25418 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. 입력 및 초기화
        int a = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 2. 로직
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[] {a, 0});

        Map<Integer, Integer> map = new HashMap<>(); // 이미 탐색했는지 확인하는 용도

        final int VISTED = 1;
        final int NOT_VISTED = 0;

        int ans = 0;
        int num;
        int cnt;

        while (!que.isEmpty()) {
            int[] tmp = que.poll();
            num = tmp[0];
            cnt = ++tmp[1];
            
            // 정답을 찾았을 때
            if (num * 2 == k || num + 1 == k) {
                ans = cnt;
                break;
            } 

            // 이미 탐색했는지 확인
            if (map.getOrDefault(num, NOT_VISTED) != NOT_VISTED) {
                continue;
            }
            map.put(num, VISTED);

            // 큐에 다시 넣기
            if (num * 2 < k) {
                que.offer(new int[] {num * 2, cnt});
            }
            if (num + 1 < k) {
                que.offer(new int[] {num + 1, cnt});
            }
        }
		
        // 3. 출력
		bw.write(String.valueOf(ans));

		br.close();
		bw.close();
	}
}
