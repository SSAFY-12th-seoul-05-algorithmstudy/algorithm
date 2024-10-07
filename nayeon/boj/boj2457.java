import java.util.*;

// boj2457_공주님의정원
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<int[]> flower = new ArrayList<>();

		// 시작일, 종료일
		for (int i = 0; i < n; i++) {
			int startMonth = sc.nextInt();
			int startDay = sc.nextInt();
			int endMonth = sc.nextInt();
			int endDay = sc.nextInt();

			// 날짜를 101, 202 등으로 변환 : 1월 1일 -> 101
			int start = startMonth * 100 + startDay;
			int end = endMonth * 100 + endDay;

			// 유효한 날짜 범위인지 확인
			if (end < 301 || start > 1130) {
				continue; // 유효하지 않은 날짜는 무시
			}
      
      // 유효한 날짜 범위인 경우 flower 리스트에 추가
			flower.add(new int[] { start, end });

		}

		// 시작일 기준 정렬 (시작일이 같으면 종료일 기준 정렬)
		flower.sort((a, b) -> {
			if (a[0] == b[0]) {
				return b[1] - a[1]; // 시작일이 같으면 종료일 기준 내림차순
			}
			return a[0] - b[0]; // 시작일 기준 오름차순
		});

		int cur = 301; // 3월 1일을 기준으로 시작
		int count = 0; // 선택한 꽃의 수
		int i = 0; // 리스트 인덱스

    // 꽃을 선택하는 과정
		while (cur <= 1130) { // 11월 30일까지 반복
			int next = cur; // 다음 꽃의 최대 종료일
			boolean found = false; // 꽃을 찾았는지 체크 

			// 현재 선택한 꽃이 끝나는 시점 전에 시작하는 꽃들 중 가장 늦게까지 피어있는 꽃 찾기 
			while (i < flower.size() && flower.get(i)[0] <= cur) {
				next = Math.max(next, flower.get(i)[1]); // 가장 늦게까지 피어있는 꽃의 종료일 업데이트
				i++; // 다음 꽃으로 이동
				found = true;
			}

			if (!found) {
				System.out.println(0); // 더 이상 선택할 꽃이 없으면 0 출력
				return;
			}

			count++; // 선택한 꽃 수 증가
			cur = next; // 가장 늦은 날짜 꽃 선택 -> 구간 확장

		} // while 
		
		// 선택한 꽃의 수 출력
		System.out.println(count); 
		
	} // main 
} // class
