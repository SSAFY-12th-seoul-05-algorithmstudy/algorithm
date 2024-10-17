import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		// A 와 B의 배열을 누적합 배열로 저장
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] aArr = new int[N + 1];
		int before = 0;
		for (int i = 1; i <= N; i++) {
			int curVal = Integer.parseInt(st.nextToken());
			aArr[i] = before + curVal;
			before = aArr[i];
		}
		
		int M = Integer.parseInt(br.readLine());
		int[] bArr = new int[M + 1];
		before = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			int curVal = Integer.parseInt(st.nextToken());
			bArr[i] = before + curVal;
			before = bArr[i];
		}
		
		// A에서 나올 수 있는 부분합의 배열을 나열할 것
		Map<Long, Long> aMap = new HashMap<>();
		List<Long> aList = new ArrayList<>();
		// 2개의 포인터로 i와 j가 작용한다.
		for (int i = 0; i < N; i++) {
			// 마지막 누적합까지의 위치에 대한 누적합 방법
			for (int j = i + 1; j < N + 1; j++) {
				long curVal = aArr[j] - aArr[i];
				if (aMap.containsKey(curVal))
					aMap.put(curVal, aMap.get(curVal) + 1);
				else {
					aMap.put(curVal, 1L);
					aList.add(curVal);
				}
			}
		}
		
		Collections.sort(aList);
		
		// B에서 나올 수 있는 부분합의 배열을 나열한 것
		Map<Long, Long> bMap = new HashMap<>();
		List<Long> bList = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			for (int j = i + 1; j < M + 1; j++) {
				long curVal = bArr[j] - bArr[i];
				if (bMap.containsKey(curVal))
					bMap.put(curVal, bMap.get(curVal) + 1);
				else {
					bMap.put(curVal, 1L);
					bList.add(curVal);
				}
			}
		}
		
		Collections.sort(bList);
		long cnt = 0;
		for (int i = 0; i < aList.size(); i++) {
			long curA = aList.get(i);
			int left = 0;
			int right = bList.size() - 1;
			while(left<=right) {
				int mid = (left + right)/2;
				long curSum = curA + bList.get(mid);
				// 값을 이미 찾은 경우
				if (curSum == T) {
					cnt += aMap.get(curA) * bMap.get(bList.get(mid));
					break;
				}else if (curSum < T)
					left = mid + 1;
				else if (curSum > T)
					right = mid - 1;
			}
		}
		
		System.out.println(cnt);
		
	}
}