import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int studentCnt;
	static int jewelCnt;
	
	static int[] jewels = {};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		studentCnt = Integer.parseInt(st.nextToken());
		jewelCnt = Integer.parseInt(st.nextToken());
		
		jewels = new int[jewelCnt];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < jewelCnt; i++) {
			int curVal = Integer.parseInt(br.readLine()); 
			jewels[i] = curVal;
			max = Math.max(max, curVal);
		}
		
		// 최대 보석의 값이 얼마일 경우에 학생 모두에게 나누어 줄 수 있는지 체크할 것.
		
		int left = 1;
		int right = max;
		int ans = 0;
		while(left <= right) {
			int mid = (left + right) / 2;
			int cnt = 0;
			for (int i = 0; i < jewelCnt; i++) {
				if (jewels[i] % mid == 0) cnt += jewels[i] / mid;
				else cnt += jewels[i] / mid + 1;
			}
			
			
			if (cnt <= studentCnt) {
				right = mid - 1;
				ans = mid;
			}
			else left = mid + 1;
		}
		
		System.out.println(ans);
	}
}