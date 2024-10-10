import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1477_BuildRestArea {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		List<Integer> highway = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {

			highway.add(Integer.parseInt(st.nextToken()));

		}

		highway.add(0);
		highway.add(L);

		Collections.sort(highway);
		// 휴게소의 간격을 찾는 이분탐색방법
		int left = 1;
		int right = L;
		int mid = 0;// 찾고자 하는 휴게소의 간격
		while (left <= right) {

			mid = (left + right) / 2;

			int cnt = 0; // 해당 간격일 때 지어지는 화장실 수
			for (int i = 0; i < N + 1; i++) {

				cnt += (highway.get(i + 1) - highway.get(i) - 1) / mid;

			}

			// 더 지어야 한다면? 간격을 좁혀라
			if (cnt <= M) {
				right = mid - 1;
			} else {
				// 개수가 지어야할 수 보다 많으면? 화장실 간격을 넖혀야 함
				left = mid + 1;
			}

		}

		System.out.println(left);

	}
}

//최초의 풀이 : 그리디 방식 -> 그리디는 언제 최적해를 찾지 못하는가??
//	public static void main(String[] args) throws IOException {
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		StringTokenizer st = new StringTokenizer(br.readLine());
//
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//		int L = Integer.parseInt(st.nextToken());
//
//		List<Integer> highway = new LinkedList<>();
//		st = new StringTokenizer(br.readLine());
//		for (int i = 0; i < N; i++) {
//
//			highway.add(Integer.parseInt(st.nextToken()));
//
//		}
//
//		highway.add(0);
//		highway.add(L);
//
//		Collections.sort(highway);
//
//		for (int i = 0; i < M; i++) {
//			int maxDiff = -1;
//			int build = -1;
//			int idx = -1;
//			for (int j = 0; j < highway.size() - 1; j++) {
//
//				int f = highway.get(j);
//				int r = highway.get(j + 1);
//
//				if (r - f > maxDiff) {
//					maxDiff = r - f;
//					build = (r + f) / 2;
//					idx = j + 1;
//				}
//			}
//
//			highway.add(idx, build);
//		}
//
//		int ans = -1;
//		for (int j = 0; j < highway.size() - 1; j++) {
//
//			int f = highway.get(j);
//			int r = highway.get(j + 1);
//
//			ans = Math.max(ans, r - f);
//		}
//
//		System.out.println(ans);
//
//		br.close();
//
//	}