package P_1014;

import java.util.Arrays;
import java.util.Scanner;

public class boj2230 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int ans = Integer.MAX_VALUE;

        int start = 0;
        int end = 0;
        int mid = 0;
        for (int i = 0; i < N; i++) {
            start = i;
            end = N;

            while (start < end) {
                mid = (start + end) / 2;
                if (arr[mid] - arr[i] < M) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }

            if (end == N) {
                continue;
            }

            ans = Math.min(ans, arr[end] - arr[i]);

            if (ans == M) {
                break;
            }
        }

        System.out.println(ans);
    }

}