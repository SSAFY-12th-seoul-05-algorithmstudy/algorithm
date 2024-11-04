package P_1014;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class boj1644 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean [] primes = new boolean[4000001];

        // 에라토스테네스의 체
        Arrays.fill(primes, true);

        primes[1] = false;

        for (int i = 2; i <= 4000000; i++) {
            if (primes[i]) {
                for (int j = i + i; j <= 4000000; j += i) {
                    primes[j] = false;
                }
            }
        }

        // 연속합 구하기
        int count = 0;
        for (int i = 2; i <= n; i++) {
            int total = 0;
            if (!primes[i]) {
                continue;
            }
            for (int j = i; j <= n; j++) {
                if (primes[j]) {
                    total += j;
                    if (total == n) {
                        count++;
                    }

                    if (total >= n)
                        break;
                }
            }
        }
        System.out.print(count);
    }
}