import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] jewel = new int[M];
		
		
		int left = 0;
		int right = 0;
		for(int i=0;i<M;i++) {
			int num = Integer.parseInt(br.readLine());
			jewel[i] = num;
			right = Math.max(right, num);
		}
		int mid=0;
		int result = Integer.MAX_VALUE;
		// 이분탐색
		while(left<=right) {
			mid = (left+right)/2;
			
			// 보석을 mid개로 분할해서 몇명분이 나오는지 확인
			int sum=0;
			for(int i=0;i<M;i++) {
				sum += (int) Math.ceil((double)jewel[i]/mid);
			}
			
			// N명분보다 작거나 같은 mid값으로 result의 최소값 갱신
			if(sum<=N) {
				result = Math.min(result,mid);
				right=mid-1;
			}
			// N명분보다 크면 더 큰쪽으로
			else {
				left=mid+1;
			}
		}
		System.out.println(result);
	}
}