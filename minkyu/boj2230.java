import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] nums = new int[N];
		for (int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(br.readLine());
		Arrays.sort(nums);
		
		int minVal = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int left = i+1;
			int right = N-1;
			int curNum = nums[i];
			int curMin = Integer.MAX_VALUE;
			while(left <= right) {
				int mid = (left + right) / 2;
				// 현재 위치와 첫 위치와의 차이 확인
				int curDiff = nums[mid] - curNum;
				// 작은 경우는 적용될 수 없으므로 더 차이가 크도록 만든다.
				if (curDiff < M) 
					left = mid + 1;
				else {
					right = mid - 1;
					// 현재 나왔던 차이가 최소차이만큼 나는 경우
					// 해당 차이만큼으로 변경할 것
					if (curMin > curDiff)
						curMin = curDiff;
				}
			}
			
			if (minVal > curMin)
				minVal = curMin;
			
			if (minVal == M) break;
		}
		
		System.out.println(minVal);
	}
}