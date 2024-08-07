import java.util.Arrays;
import java.util.Scanner;

public class swea1111 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			int[] count = new int[n+m+1];
			int big = 0;
				// 0 1 2 3 4 5 6 7 8 9 10 .. n + m 
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					count[i+j]++;
				}
			}
			for (int i=2;i<n+m+1;i++){ // 
				big = Math.max(count[i], big);
			}
			System.out.print("#"+tc+" ");
			for(int i=2;i<n+m+1;i++) {
				if(count[i]==big)
					System.out.print(i+" ");
			}
            System.out.println();
		}
	}
}
