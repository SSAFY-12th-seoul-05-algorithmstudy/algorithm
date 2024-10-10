import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int restCnt = Integer.parseInt(st.nextToken());
		int needCnt = Integer.parseInt(st.nextToken());
		int highLength = Integer.parseInt(st.nextToken());
		int[] rests = new int[restCnt];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < restCnt; i++)
			rests[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(rests);
		
		int[] dists = new int[restCnt + 1];
		int max = 0;
		int before = 0;
		for (int i = 0; i < restCnt; i++) {
			dists[i] = rests[i] - before;
			max = Math.max(max, dists[i]);
			before = rests[i];
		}
		max = Math.max(max, highLength - before);
		dists[restCnt] = highLength - before;
		
		int left = 1;
		int right = max;
		int ans = 0;
		while(left <= right) {
			int mid = (left + right) / 2;
			
			int cnt = 0;
			for (int i = 0; i < restCnt + 1; i++) {
				if (dists[i] % mid == 0) cnt += dists[i] / mid;
				else cnt += dists[i] / mid + 1;
			}
			
			if (cnt > needCnt + restCnt + 1) left = mid + 1;
			else {
				right = mid - 1;
				ans = mid;
			}
		}
		
		System.out.println(ans);
	}
}