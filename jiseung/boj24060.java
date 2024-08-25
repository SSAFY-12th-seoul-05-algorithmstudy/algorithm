import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] tmp = new int[500000];
	static int count = 0;
	static int result = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st1 = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st1.nextToken()); // 배열의 크기
		int[] A = new int[N];

		int K = Integer.parseInt(st1.nextToken()); // K번째 저장되는 수

		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st2.nextToken());
		}
		// 병합정렬 실행
		merge_sort(A, 0, N - 1, K);
		
		// K번째에 숫자가 바뀌지 않으면 -1출력 바뀌면 결과값 출력
		if (result != -1) {
			System.out.println(result);
		} else {
			System.out.println("-1");
		}
	}
	
	// 병합정렬 q를기준으로 나누고 합침
	// 다시 그걸기준으로 나누고 합침
	// 반복, 원소가 하나남았을때 병합시작
	static void merge_sort(int[] arr, int p, int r, int K) {
		if (p < r) {
			int q = (p + r) / 2;
			merge_sort(arr, p, q, K);
			merge_sort(arr, q + 1, r, K);
			merge(arr, p, q, r, K);
		}
	}
	
	// 병합할 때 작은쪽먼저 tmp에 기록
	// 기록할 때 마다 count를 올리고
	// count=K이면 tmp[t-1]값을 반환
	static void merge(int[] arr, int p, int q, int r, int K) {
		int i = p;
		int j = q + 1;
		int t = 0;
		while (i <= q && j <= r) {
			if (arr[i] <= arr[j]) {
				tmp[t++] = arr[i++];
			} else {
				tmp[t++] = arr[j++];
			}
			count++;
			if (count == K) {
				result = tmp[t - 1];
			}
		}
		while (i <= q) {
			tmp[t++] = arr[i++];
			count++;
			if (count == K) {
				result = tmp[t - 1];
			}
		}
		while (j <= r) {
			tmp[t++] = arr[j++];
			count++;
			if (count == K) {
				result = tmp[t - 1];
			}
		}
		// 병합된 결과를 원래 배열에 복사
		i = p;
		t = 0;
		while (i <= r) {
			arr[i++] = tmp[t++];
		}
	}
}