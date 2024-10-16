import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N];
		int[] B = new int[N];
		int[] C = new int[N];
		int[] D = new int[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			A[i]=Integer.parseInt(st.nextToken());
			B[i]=Integer.parseInt(st.nextToken());
			C[i]=Integer.parseInt(st.nextToken());
			D[i]=Integer.parseInt(st.nextToken());
		}
		
		int [] AplusB = new int[N*N];
		int [] CplusD = new int[N*N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				AplusB[N*i+j]=A[i]+B[j];
				CplusD[N*i+j]=C[i]+D[j];
			}
		}
		
		Arrays.sort(AplusB);
		Arrays.sort(CplusD);
		
		int left = 0;
		int right = N*N-1;
		
		long count = 0;
		
		while(left<N*N && right>=0) {
			int ab = AplusB[left];
			int cd = CplusD[right];
			int result = ab+cd;
			if(result<0) {
				left++;
			}
			else if(result>0) {
				right--;
			}
			else {
				long abDuplicate = 0;
				long cdDuplicate = 0;
				while(left<N*N && ab==AplusB[left]) {
					left++;
					abDuplicate++;
				}
				while(right>=0 && cd==CplusD[right]) {
					right--;
					cdDuplicate++;
				}
				count += abDuplicate*cdDuplicate;
			}
		}
		System.out.println(count);
	}
}