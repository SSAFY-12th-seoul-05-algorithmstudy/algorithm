import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj1966_프린터 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			// 중요도와 인덱스를 함께 큐에 저장 | ex) N : 2, 중요도 : 1, 5 -> [[0, 1], [2, 5]]
			Queue<int[]> queue = new LinkedList<>();
			
			// 중요도만 담은 배열 생성 -> 가장 높은 중요도 확인하기 위해서
			int[] arr = new int[N];
			
			for (int i = 0; i < N; i++) {
				int value = sc.nextInt();
				queue.add(new int[] { i, value }); // 인덱스와 값을 배열에 담아 큐에 추가
				arr[i] = value;
			}

			// 중요도만 담은 배열 정렬 -> 가장 높은 중요도 순으로 체크하기 위해서 
			Arrays.sort(arr);
//			System.out.println(arr[arr.length-1]);
			
			// count : 중요도 순서에 따라 체크하기 위한 변수
			int count = arr.length - 1;
			// result : 인쇄 순서
			int result = 1;

			while (true) {
				// 첫번째 값 무조건 제거한 후 중요도가 낮으면 맨 뒤에 추가
				int[] num = queue.poll();
				
				// 중요도가 가장 높으면 제거만 진행(뒤에 추가할 필요 X)
				if (num[1] == arr[count]) {
					// 인덱스도 동일하다면 반복문 종료
					if (num[0] == M) {
						System.out.println(result);
						break;
					} else {
						// 중요도 하나 줄이기
						count--;
					}
					// 인쇄 순서 + 1
					result++;
				} else {
					queue.add(num);
				}

			} // while문
			
		} // for문 : T번 반복 
	} // main
} // class
