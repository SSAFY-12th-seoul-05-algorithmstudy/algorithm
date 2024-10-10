import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		int[] sum = new int[N * N];
		for (int i = 0; i < N; i++) 
			num[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(num);
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				sum[cnt++] = num[i] + num[j];
			}
		}
		
		Arrays.sort(sum, 0, cnt - 1);
		
		int ans = 0;
		main : for (int i = N - 1; i >= 0; i--) {
			for (int j = i; j >= 0; j--) {
				boolean hasFound = false;
				int left = 0;
				int right = cnt - 1;
				int curNum = num[i] - num[j];
				while(left <= right) {
					int mid = (left + right)/2;
					if (sum[mid] == curNum) {
						hasFound = true;
						break;
					}else if (sum[mid] < curNum)
						left = mid + 1;
					else
						right = mid - 1;
				}
				if (!hasFound) continue;
				ans = num[i];
				break main;
			}
		}
		System.out.println(ans);
	}
}