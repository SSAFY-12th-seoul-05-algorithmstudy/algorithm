import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st1.nextToken()); // 정수 N
		int K = Integer.parseInt(st1.nextToken()); // 정수 K
		
		int[] arr = new int[N];
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		
		int[] sum = new int [N-K+1];
		int max= Integer.MIN_VALUE;
		for(int i=0; i<=N-K;i++) {
			for(int j=0;j<K;j++) {
				sum[i]+=arr[i+j];
			
			}
			max = Math.max(max, sum[i]);
		}
		System.out.println(max);
		
	}
}