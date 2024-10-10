import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] seq = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		seq[0] = arr[0];
		int length = 1;
		
		for (int i = 1; i < N; i++) {
			int tmp = arr[i];
			
			// 맨 마지막 값보다 클 경우 추가
			if (seq[length - 1] < tmp) {
				length++;
				seq[length - 1] = tmp;
			}else {
				int left = 0;
				int right = length - 1;
				while (left <= right) {
					int mid = (left + right) / 2;
					
					if (seq[mid] < tmp)
						left = mid + 1;
					else
						right = mid - 1;
				}
				
				seq[left] = tmp;
			}
		}
		
		System.out.println(length);
	}
}