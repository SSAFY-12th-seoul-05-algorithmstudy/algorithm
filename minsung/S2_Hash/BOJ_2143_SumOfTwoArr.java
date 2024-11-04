import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2143_SumOfTwoArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long T = sc.nextLong(); 
        int n = sc.nextInt();
        int[] A = new int[n];
        long[] sumA = new long[n * (n + 1) / 2];  
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        int idx = 0;
        for (int i = 0; i < n; i++) {
            long tmp = 0;  
            for (int j = i; j < n; j++) {
                tmp += A[j];
                sumA[idx++] = tmp;
            }
        }
        int m = sc.nextInt();
        int[] B = new int[m];
        long[] sumB = new long[m * (m + 1) / 2]; 
        for (int i = 0; i < m; i++) {
            B[i] = sc.nextInt();
        }
        idx = 0;
        for (int i = 0; i < m; i++) {
            long tmp = 0;  
            for (int j = i; j < m; j++) {
                tmp += B[j];
                sumB[idx++] = T - tmp;
            }
        }
        
        Arrays.sort(sumA);
        Arrays.sort(sumB);
        
        
        int left = 0;
        int right = 0;
        long ans = 0; 
        while (left < sumA.length && right < sumB.length) {
            if (sumA[left] == sumB[right]) {
                long countA = 1; 
                long countB = 1;  
                left++;
                right++;
                while (left < sumA.length && sumA[left] == sumA[left - 1]) {
                    countA++;
                    left++;
                }
                while (right < sumB.length && sumB[right] == sumB[right - 1]) {
                    countB++;
                    right++;
                }
                ans += countA * countB;
            } else if (sumA[left] < sumB[right]) {
                left++;
            } else {
                right++;
            }
        }
        System.out.println(ans);
    }
}