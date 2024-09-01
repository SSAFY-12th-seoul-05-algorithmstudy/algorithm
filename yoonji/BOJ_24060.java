import java.util.Arrays;
import java.util.Scanner;

// 시간 초과 나는데 왜그러는지 아는사람 있나요 ㅠㅠ
public class BOJ_24060 {
	static int K;
	static int cnt = 1;
	static int answer = -1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		K = sc.nextInt();
		
		int[] A = new int[N];
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		
		merge_sort(A, 0, N-1);
		
		System.out.println(answer);
		
	}
	
	static int[] merge_sort(int[] A, int p, int r) {
		
		if(p < r) {
			int q = (p+r) / 2;
			merge_sort(A, p, q);
			merge_sort(A, q+1, r);
			merge(A, p, q, r);
		}
		return A;
	}
	
	static int[] merge(int[] A, int p, int q, int r) {
		int i = p;
		int j = q+1;
		int t = 0;
		
		int[] tmp = new int[A.length];
		
		while(i<=q && j<=r) {
			if(A[i] <= A[j]) {
				tmp[t++] = A[i++];
				if(cnt == K) {
					answer = tmp[t-1];
				}
				cnt++;
			} else {
				tmp[t++] = A[j++];
				if(cnt == K) {
					answer = tmp[t-1];
				}
				cnt++;
			}
		}
		while(i<=q) {
			tmp[t++] = A[i++];
			if(cnt == K) {
				answer = tmp[t-1];
			}
			cnt++;
		}
		while(j<=r) {
			tmp[t++] = A[j++];
			if(cnt == K) {
				answer = tmp[t-1];
			}
			cnt++;
		}
		
		i = p;
		t = 0;
		while(i<=r) {
			A[i++] = tmp[t++];
		}
		
		return A;
	}
}
