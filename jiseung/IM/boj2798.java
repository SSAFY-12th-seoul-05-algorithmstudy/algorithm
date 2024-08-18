import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st1.nextToken());	// 카드 갯수
		int M = Integer.parseInt(st1.nextToken());	// 합
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		int min=M;
		for(int i=0;i<N-2;i++) {
			for(int j=i+1;j<N-1;j++) {
				for(int k=j+1;k<N;k++) {
					if(arr[i]+arr[j]+arr[k]<=M) {
						min = Math.min(M-(arr[i]+arr[j]+arr[k]),min);
					}
				}
			}
		}
		System.out.println(M-min);
		
	}
}