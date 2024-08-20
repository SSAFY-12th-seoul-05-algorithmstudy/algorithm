import java.util.Scanner;

public class BOJ_2635 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int maxLength = 0; // 최대 수열 길이
        int bestA = 0; 

       
        for (int i = 0; i <= N; i++) {
            int cnt = 3; // 초기 수열 길이는 N, a, b로 3
            int a = i;
            int b = N - a;
            StringBuilder sb = new StringBuilder();
            sb.append(N).append(" ").append(a).append(" ").append(b).append(" ");

            // 수열 생성
            while (true) {
                int c = a - b;
                if (c < 0) {
                    break;
                }
                cnt++;
                sb.append(c).append(" ");
                a = b;
                b = c;
            }

            // 현재 수열 길이가 최대 길이보다 길면 갱신
            if (cnt > maxLength) {
                maxLength = cnt;
                bestA = i;
            }
        }

        
        System.out.println(maxLength);

        
        int a = bestA;
        int b = N - a;
        StringBuilder sb = new StringBuilder();
        sb.append(N).append(" ").append(a).append(" ").append(b).append(" ");

        while (true) {
            int c = a - b;
            if (c < 0) {
                break;
            }
            sb.append(c).append(" ");
            a = b;
            b = c;
        }

      
        System.out.println(sb.toString().trim());
    }
}