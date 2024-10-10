import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;

// boj2170_선긋기
public class Main {
	public static void main(String[] args) throws IOException {
		// BufferedReader, BufferedWriter 사용하여 I/O 최적화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력 받기
		int N = Integer.parseInt(br.readLine());
		int[][] num = new int[N][2];

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			num[i][0] = Integer.parseInt(input[0]); // start값
			num[i][1] = Integer.parseInt(input[1]); // end값
		}

		// 0. start점 기준 정렬 | 2차원 배열 정렬 : Lambda 사용
		Arrays.sort(num, (o1, o2) -> {
			if (o1[0] != o2[0]) {
				return o1[0] - o2[0]; // 첫 번째 숫자 기준 오름차순
			} else {
				return o1[1] - o2[1]; // 첫 번째 숫자가 같을 경우 두 번째 숫자 기준 오름차순
			}
		});

		// 시작점, 끝점 초기화
		int start = num[0][0];
		int end = num[0][1];
		int result = 0;

		// 1. 구간을 하나씩 확인하면서 겹치는 부분 계산
		for (int i = 1; i < N; i++) {
			// 현재 구간이 이전 구간과 겹치는지 확인 : 기존 end값 보다 새로운 start값이 작거나 같다면
			if (num[i][0] <= end) {
				// 겹친다면 끝나는 값을 더 큰 값으로 업데이트
				end = Math.max(end, num[i][1]);
			} else {
				// 겹치지 않는다면 이전 구간을 결과에 추가하고 새로운 구간 시작
				result += (end - start);
				// 새로운 구간 시작
				start = num[i][0];
				end = num[i][1];
			}
		}

		// 마지막 구간 더하기
		result += (end - start);

		// 결과 출력
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
