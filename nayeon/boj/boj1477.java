import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 기존 휴게소 수
		int M = sc.nextInt(); // 더 지으려는 휴게소 수
		int L = sc.nextInt(); // 고속도로 길이

		// N개의 기존 휴게소 + 시작점(0), 끝점(L) 포함 -> N+2 크기
		int[] rest = new int[N + 2];

		rest[0] = 0; // 고속도로 시작점
		rest[N + 1] = L; // 고속도로 끝점

		for (int i = 1; i <= N; i++) {
			rest[i] = sc.nextInt();
		}

		// 휴게소 위치 정렬
		Arrays.sort(rest);

		// 이분 탐색으로 휴게소 간의 최대 거리를 최소화하기 위한 설정
		int left = 1; // 가능한 최소 거리
		int right = L; // 가능한 최대 거리
		int result = 0; // 최종 결과

		// 이분 탐색 시작 (휴게소 간의 최대 거리 최소)
		while (left <= right) {
			// mid : 최대 거리
			int mid = (left + right) / 2;

			// mid 값으로 휴게소를 배치할 수 있는지 확인
			if (Place(rest, M, mid)) {
				result = mid; // 가능하면 결과값 갱신
				right = mid - 1; // 더 작은 범위에서 탐색
			} else {
				left = mid + 1; // 불가능하면 더 큰 범위에서 탐색
			}
		}

		System.out.println(result);
	}

	// 해당 거리로 M개 이하 휴게소 세울 수 있는지 체크
	private static boolean Place(int[] rest, int M, int distance) {

		int count = 0; // 새로 설치할 휴게소의 수

		// 각 인접한 휴게소 간의 거리 차이 계산 -> 설치할 휴게소 수 계산
		for (int i = 1; i < rest.length; i++) {
			// 두 휴게소 간의 거리
			int diff = rest[i] - rest[i - 1];

			// 해당 거리로 세울 수 있는 휴게소 개수 계산
			count += (diff - 1) / distance;
		}

		// 새로 설치할 휴게소의 개수가 M개 이하일 때 true 반환
		return count <= M;
	} // main

} // class
