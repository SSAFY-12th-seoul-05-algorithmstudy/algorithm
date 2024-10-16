import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		int[] nums = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(st.nextToken());

		int minLength = Integer.MAX_VALUE;
		int left = 0;
		int right = 0;
		int sum = 0;
		while (left <= N && right <= N) {
			// 해당 값이 S보다는 크다면 값 갱신
			if (sum >= S && minLength > right - left)
				minLength = right - left;

			if (sum < S)
				sum += nums[right++];
			else
				sum -= nums[left++];
		}
		
		if (minLength == Integer.MAX_VALUE)
			System.out.println(0);
		else
			System.out.println(minLength);
	}

}