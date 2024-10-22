import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        
        // 전체 숫자 배열
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        for (int i = 0; i < N; i++) {
        	// 윈도우 범위 벗어난 값은 제거
            if (!dq.isEmpty() && dq.peekFirst() <= i - L) {
                dq.pollFirst();
            }
            
            // 현재 값보다 큰 값들은 덱에서 제거
            while (!dq.isEmpty() && arr[dq.peekLast()] > arr[i]) {
                dq.pollLast();
            }
            
            // 덱에 현재 값 추가
            dq.offerLast(i);
            
            // 덱에서 첫 번째 값이 현재 윈도우에서의 최소값
            sb.append(arr[dq.peekFirst()]).append(" ");
        }
        
        System.out.println(sb.toString());
    }
}

