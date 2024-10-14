package P_1014;

import java.util.Scanner;

// 연속된 수들의 부분합

public class boj1806 {

    public static void main(String[] arg) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int S = sc.nextInt();
        int[] nums = new int[N];

        for (int i = 0; i < N; i++)
            nums[i] = sc.nextInt();

        int start = 0;
        int end = 0;
        int min = 0;
        int sum = 0;
        while(true) {
            if (sum >= S) {
                sum -= nums[start];
                if ( min == 0 ) min = end - start;
                else min = Math.min(min, end-start);
                start++;
            }
            else if (end == N) break;
            else {
                sum += nums[end];
                end++;
            }
        }

        System.out.print(min + "");
    }
}
