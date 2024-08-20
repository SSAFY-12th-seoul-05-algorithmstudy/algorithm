import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 수열의 길이
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int maxLength = 1; // 최대 수열 길이 초기화
        int increaseLength = 1; // 현재 증가 수열 길이
        int decreaseLength = 1; // 현재 감소 수열 길이

        for (int i = 1; i < N; i++) {
            if (arr[i] > arr[i - 1]) { // 증가하는 경우
                increaseLength++;
                decreaseLength = 1; // 감소 길이 초기화
            } else if (arr[i] < arr[i - 1]) { // 감소하는 경우
                decreaseLength++;
                increaseLength = 1; // 증가 길이 초기화
            } else { // 이전 값과 동일한 경우
                increaseLength++;
                decreaseLength++;
            }
            maxLength = Math.max(maxLength, Math.max(increaseLength, decreaseLength)); // 최대 길이 갱신
        }

        System.out.println(maxLength);
    }
}