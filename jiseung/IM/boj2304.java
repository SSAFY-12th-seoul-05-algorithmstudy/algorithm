import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[1001];
		int N = Integer.parseInt(br.readLine()); // 기둥의 갯수
		
		int Lmin = 1001;
		int Lmax = 0;
		int max = 0;
		int maxL = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken()); // 왼쪽면위치
			int H = Integer.parseInt(st.nextToken()); // 높이
			arr[L]=H;
			Lmin = Math.min(Lmin, L);
			Lmax = Math.max(Lmax, L);
			if(H>=max) {
				max = Math.max(max, H);
				maxL = L;
			}
		}
		for(int i=Lmin;i<maxL;i++) {
			if(arr[i+1]<arr[i]) {
				arr[i+1]=arr[i];
			}
		}
		for(int i=Lmax;i>maxL;i--) {
			if(arr[i-1]<arr[i]) {
				arr[i-1]=arr[i];
			}
		}
		int sum=0;
		for(int i=Lmin;i<=Lmax;i++) {
			sum+=arr[i];
		}
		System.out.println(sum);
	}
}