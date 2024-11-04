import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N], B = new int[N], C = new int[N], D = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());
		}

		int[] AandB = new int[N * N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				AandB[i * N + j] = A[i] + B[j];
			}
		}
		int[] CandD = new int[N * N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				CandD[i * N + j] = C[i] + D[j];
			}
		}
		Arrays.sort(AandB);
		Arrays.sort(CandD);

		// A와B의 덧셈 배열에 대한 포인터
		int abPointer = 0;
		// C와D의 덧셈 배열에 대한 포인터
		int cdPointer = N * N - 1;
		long cnt = 0;
		while (abPointer < N * N && cdPointer >= 0) {
			long abValue = AandB[abPointer];
			long cdValue = CandD[cdPointer];

			long sum = abValue + cdValue;
			if (sum < 0) {
				abPointer++;
			} else if (sum > 0) {
				cdPointer--;
			} else {
				long abCnt = 0, cdCnt = 0;
				// 현재 값이랑 동일한 경우 해당 값에 대한 정보 추가입력 (동일한 것은 뛰어넘는다.)
				// 그냥 뛰어넘으면 안되는게, 동일한 값이 나왔더라도 각각의 A,B 조합이 다를 수 있으니
				// 모든 경우의 수로 쳐서 넣어준다.
				while (abPointer < N * N && abValue == AandB[abPointer]) {
					abPointer++;
					abCnt++;
				}
				while (cdPointer >= 0 && cdValue == CandD[cdPointer]) {
					cdPointer--;
					cdCnt++;
				}
				cnt += abCnt * cdCnt;
			}
		}
		System.out.println(cnt);
	}
}