import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// A의 부 배열의 합에 B의 부 배열의 합을 더해서 T가 되는 모든 부 배열 쌍의 개수
		int T = sc.nextInt();

		// A의 부 배열
		int N = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}

		// B의 부 배열
		int M = sc.nextInt();
		int[] B = new int[M];
		for (int i = 0; i < M; i++) {
			B[i] = sc.nextInt();
		}

		// A의 모든 부분 배열의 합을 저장하는 HashMap
		HashMap<Integer, Integer> map = new HashMap<>();

		// A의 부분 배열 합을 구하고 그 빈도를 저장
		// -> 만약에 3이라는 부분 배열 합이 2번 나왔으면 2로 체크해야 B와 비교할 때 제대로 체크가 되기 때문 !!
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = i; j < N; j++) {
				sum += A[j];
				// 찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환하는 메서드
				// 반환 값 : 찾는 key가 존재하면 해당 key에 매핑되어 있는 값을 반환, 그렇지 않으면 기본 값 반환
				map.put(sum, map.getOrDefault(sum, 0) + 1);
			}
		}

		// B의 부분 배열 합과 매칭되는 A의 부분 배열 합을 찾음
		long result = 0;
		for (int i = 0; i < M; i++) {
			int sum = 0;
			for (int j = i; j < M; j++) {
				sum += B[j];
				if (map.containsKey(T - sum)) {
					result += map.get(T - sum);
				}
			}
		}

		System.out.println(result);
	}
}
