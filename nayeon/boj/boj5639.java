import java.util.Scanner;

public class Main {
	static int[] tree = new int[10001]; // 이진 트리 저장

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int idx = 0; // 배열 인덱스 초기화

		while (sc.hasNext()) {
			tree[idx++] = sc.nextInt();
		}

		// 후위 순회
		post(0, idx - 1);
	} // main

	// 후위 순회 수행 메서드
	static void post(int n, int end) {
		// 기저 조건 : 인덱스가 범위를 벗어났다면 종료
		if (n > end)
			return;

		// 오른쪽 서브트리의 시작 인덱스 찾기
		int mid = n + 1; // 현재 노드의 오른쪽 자식 = 항상 현재 노드 다음 인덱스가 된다 !!
		while (mid <= end && tree[mid] < tree[n]) {
			mid++; // 현재 노드보다 큰 값을 만날 때까지 오른쪽으로 이동
		}

		// 왼쪽 서브트리 후위 순회
		post(n + 1, mid - 1);

		// 오른쪽 서브트리 후위 순회
		post(mid, end);

		// 현재 노드 출력 (후위 순회 순서)
		System.out.println(tree[n]);
	} // post

} // class
