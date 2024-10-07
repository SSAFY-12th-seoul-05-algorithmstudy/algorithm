import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		int[] sum = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i]=num;
			sum[i]= sum[i-1]+arr[i];
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			sb.append(sum[end]-sum[start-1]).append("\n");
		}
		System.out.println(sb);
	}
}
