import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 학생 수
		int M = sc.nextInt(); // 보석 수

		int[] jewel = new int[M];
		int max = 0;
		for (int i = 0; i < M; i++) {
			jewel[i] = sc.nextInt();
			max = Math.max(max, jewel[i]); // 가장 많은 보석 수
		}

		// 이진 탐색
		int left = 1; // 학생이 받을 수 있는 최소 보석의 개수 : 1개
		int right = max; // 가장 많은 보석 개수 -> 보석을 나누지 않는다면 한 학생이 받을 수 있는 최대 보석의 개수 : max
		int result = max;

		while (left <= right) {
			int mid = (left + right) / 2; // 중간 값 -> 학생이 받을 수 있는 보석의 최대 개수로 가정하고 이진 탐색 진행 
			if (canDistribute(jewel, N, mid)) {
				result = mid; // 가능하면 결과값을 갱신
				right = mid - 1; // 더 작은 범위에서 탐색
			} else {
				left = mid + 1; // 불가능하면 더 큰 범위에서 탐색
			}
		}
		// canDistribute 함수는 각 보석을 mid 개수 이하로 나누어줄 때, N명의 학생에게 나누어 줄 수 있는지를 확인
		// 만약 mid 개수로 나눌 수 있다면, 더 작은 범위에서 가능한지 확인하기 위해 right = mid - 1로 범위를 좁히기
		// 반대로 mid 개수로 나눌 수 없다면, left = mid + 1로 범위를 넓혀 더 큰 값에서 탐색 계속 진행 		

		System.out.println(result);
	}

	// 주어진 크기로 모든 학생에게 보석을 나눌 수 있는지 확인
    // maxPerStudent: 현재 이진 탐색에서 설정된 보석의 최대 개수(mid 값)
	private static boolean canDistribute(int[] jewel, int N, int maxPerStudent) {
        // 각 보석을 maxPerStudent 개수 이하로 나누어줄 때 총 몇 명의 학생이 필요한지를 계산
		int count = 0;
		for (int j : jewel) {
			count += (j + maxPerStudent - 1) / maxPerStudent; // 보석을 나누는 데 필요한 학생 수
		}
        // 만약 학생 수 N보다 적거나 같으면, 해당 개수로 나눌 수 있다는 의미
		return count <= N;
	}
	
}
