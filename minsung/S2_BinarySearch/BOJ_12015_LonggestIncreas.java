import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_12015_LonggestIncreas {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 이떄 맨 앞 부터 linkedlist 에 넣어주는데,
		// 두가지 케이스
		// 1. 증가가 가능한 상태라면, 가장 뒤 인덱스에 넣어줌
		// 2. 증가가 불가능한 상태라면?
		// 넣을 위치를 이분탐색으로 찾고, 교체 함
		// 왜 교체냐? 추후에 수열의 구성이 바뀔 수 있음
		// 교체를 해도 문제가 없는이유? 어차피 증가수열의 최대 길이만 궁금하기 떄문에 길이에는 변화가 없음

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		ArrayList<Integer> ans = new ArrayList<>();
		// 인덱스 예쁘게 맞춰주자
		ans.add(0);

		for (int i = 0; i < N; i++) {
			int input = arr[i];
			// 증가가 가능한 경우
			if (input > ans.get(ans.size() - 1)) {
				ans.add(input);
			} else {
				// 교체할 위치를 찾자
				int left = 1;
				int right = ans.size() - 1;

				while (left <= right) {
					int mid = (left + right) / 2;

					if (ans.get(mid) < input)
						left = mid + 1;
					else
						right = mid - 1;

				}
				ans.set(left, input);
			}
		}

		System.out.println(ans.size() - 1);

	}
}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.StringTokenizer;
//
//public class BOJ_12015_LonggestIncreas {
//	static int[] arr;
//	static int mid;
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		int N = Integer.parseInt(br.readLine());
//
//		StringTokenizer st = new StringTokenizer(br.readLine());
//
//		arr = new int[N];
//
//		for (int i = 0; i < N; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
//		}
//
//		// 증가하는 수열의 갯수로 가능한 수를 이분탐색으로 찾아볼것임
//		// 최소 한개는 증가수열
//		int left = 1;
//		// 최대 N개가 증가수열
//		int right = N;
//		boolean flag = false;
//		while (left <= right) {
//			// mid 개로 증가수열 가능?
//			mid = (left + right) / 2;
//			// mid개로 조합 뽑아
//			combination = new ArrayList<>();
//			comb(0);
//			// 모든 조합중에서 항상 증가수열인게 있는가?
//			for (List<Integer> li : combination) {
//				flag = false;
//				for (int i = 0; i < mid - 1; i++) {
//					// 한번이라도 감소 or 같다면
//					if (li.get(i + 1) - li.get(i) <= 0) {
//						flag = true;
//						break;
//					}
//
//				}
//				// 한번도 감소를 안했다면 ->증가수열
//				if (!flag)
//					break;
//			}
//
//			// mid 개로 증가수열 가능하다 -> 하지만 더 많은 개수로 가능하다면 그게 답이 된다.
//			// 더 큰 범위를 탐색해봐야한다.
//			if (!flag)
//				left = mid + 1;
//			// mid 개로 증가수열을 만들 수 없다면 -> 더 좁은 범위를 탐색해 봐야한다.
//			else
//				right = mid - 1;
//
//		}
//
//		System.out.println(right);
//
//	}
//
//	static List<List<Integer>> combination = new ArrayList<>();
//	static List<Integer> current = new ArrayList<>();
//
//	static void comb(int idx) {
//		if (current.size() == mid) {
//			combination.add(new ArrayList<>(current));
//			return;
//		}
//
//		for (int i = idx; i < arr.length; i++) {
//			current.add(arr[i]);
//			comb(i + 1);
//			current.remove(current.size() - 1);
//		}
//
//	}
//
//}
