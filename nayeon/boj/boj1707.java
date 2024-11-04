import java.util.*;

// 이분 그래프로 나누기 위해서는 각 정점을 두 가지 색 중 하나로 구분하는 작업이 필요
// -> "색칠"이라고 표현

// 이분 그래프는 인접한 정점끼리 서로 다른 색을 가져야 하는데
// 이를 위해 하나의 색상(0 또는 1)을 각 정점에 할당해 
// 인접한 두 정점이 서로 다른 색을 가지도록 설정
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 테케 입력
		int K = scanner.nextInt();
		for (int k = 0; k < K; k++) {
			int V = scanner.nextInt(); // 정점 수
			int E = scanner.nextInt(); // 간선 수

			List<Integer>[] list = new ArrayList[V + 1];
			for (int i = 1; i <= V; i++) {
				list[i] = new ArrayList<>();
			}

			// 간선 정보 입력
			for (int i = 0; i < E; i++) {
				int v1 = scanner.nextInt();
				int v2 = scanner.nextInt();
				// v1-v2와 v2-v1 모두 간선으로 저장
				list[v1].add(v2);
				list[v2].add(v1);
			}

			boolean result = true;
			Integer[] draw = new Integer[V + 1];

			// 모든 정점을 순회
			for (int i = 1; i <= V; i++) {
				if (!result) // 결과가 false이면 반복 종료
					break;

				// 현재 정점이 아직 색칠되지 않았다면 색칠
				if (draw[i] == null)
					result = check(list, draw, i, 0); // 0번 색으로 시작
				else
					check(list, draw, i, draw[i]); // 이미 색칠된 정점은 그 색으로 체크
			}

			System.out.println(result ? "YES" : "NO");
		} // k번 반복
	} // main

	// 어떤 정점과 그 인접 정점이 같은 색을 가지게 된다면, 이분 그래프가 될 수 없다고 판단 -> false
	public static boolean check(List<Integer>[] list, Integer[] draw, int v, int color) {
		// 현재 정점이 이미 색칠되어 있고 색상이 일치하면 true
		if (draw[v] != null && draw[v] == color)
			return true;
		// 현재 정점이 이미 색칠되어 있고 색상이 불일치하면 false
		if (draw[v] != null && draw[v] != color)
			return false;

		boolean isTwoGraph = true; // 이분 그래프 여부 초기화
		draw[v] = color; // 현재 정점에 색상 칠하기

		// 인접 정점에 대해 재귀적으로 색칠 시도
		for (Integer i : list[v]) {
			if (!isTwoGraph) // 이분 그래프가 아닌 경우 반복 종료
				break;

			// 인접 정점의 색상을 현재 정점과 다르게 칠하기
			if (color == 0)
				isTwoGraph = check(list, draw, i, 1); // 현재 정점이 0이라면 인접 정점은 1로
			else
				isTwoGraph = check(list, draw, i, 0); // 현재 정점이 1이라면 인접 정점은 0으로
		}
		return isTwoGraph; // 이분 그래프 여부 반환
	} // check
} // class
