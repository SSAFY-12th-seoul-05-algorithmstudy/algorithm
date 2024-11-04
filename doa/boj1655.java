import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class boj1655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        
        // 첫 번째 값 추가
        int now = Integer.parseInt(br.readLine());
        left.add(now);
        sb.append(now).append("\n"); // 첫 번째 출력

        for (int i = 1; i < N; i++) { // 1부터 N-1까지 반복
            now = Integer.parseInt(br.readLine());

            // 값 비교 후 추가
            if (now <= left.peek()) {
                left.add(now);
            } else {
                right.add(now);
            }

            // 사이즈 맞추기
            if (left.size() > right.size() + 1) {
                right.add(left.poll());
            } else if (right.size() > left.size()) {
                left.add(right.poll());
            }

            // 출력
            sb.append(left.peek()).append("\n");
        }

        // 최종 출력
        System.out.print(sb.toString());
        br.close();
    }
}
