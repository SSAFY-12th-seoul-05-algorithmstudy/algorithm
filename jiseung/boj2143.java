import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			A[i]=Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		int[] B = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			B[i]=Integer.parseInt(st.nextToken());
		}
		
		int aSize = N*(N+1)/2;
		int bSize = M*(M+1)/2;
		int[] aSum = new int[aSize];
		int idx=0;
		for(int i=0; i<N; i++) {
			int sub=0;
			for(int j=i; j<N; j++) {
				sub += A[j];
				aSum[idx++] = sub;
			}
		}

		int[] bSum = new int[bSize];
		idx=0;
		for(int i=0; i<M; i++) {
			int sub = 0;
			for(int j=i; j<M; j++) {
				sub += B[j];
				bSum[idx++] = sub;
			}
		}
		Arrays.sort(aSum);
		Arrays.sort(bSum);
		// 이제부터는 합이 0인 네 정수랑 비슷
		int left = 0;
		int right = bSize-1;
		long cnt=0;
		while(left<aSize && right>=0) {
			int a = aSum[left];
			int b = bSum[right];
			int result = a+b;
			if(result<T) {
				left++;
			}
			else if(result>T) {
				right--;
			}
			else {
				long aDuplicate = 0;
				long bDuplicate = 0;
				while(left<aSize && a==aSum[left]) {
					left++;
					aDuplicate++;
				}
				while(right>=0 && b==bSum[right]) {
					right--;
					bDuplicate++;
				}
				cnt += aDuplicate*bDuplicate;
			}
		}
		System.out.println(cnt);
	}
}