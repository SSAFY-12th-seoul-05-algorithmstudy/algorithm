import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int left=0;
		int right=0;
		int result = Integer.MAX_VALUE;
		while(right<N && left<N) {
			int gap = arr[right]-arr[left];
			if(gap<M) {
				right++;
			}
			else {
				result = Math.min(result,gap);
				left++;
			}
		}
		System.out.println(result);
	}
}