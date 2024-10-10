import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 자연수의 수

		int[] arr = new int[N];
        
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		// 배열 정렬
		Arrays.sort(arr);

		// 두 수의 합을 저장할 배열
		int[] twoSum = new int[N * (N + 1) / 2];
		int index = 0;

		// 두 수의 합을 배열에 저장
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				twoSum[index++] = arr[i] + arr[j];
			}
		}

		// 두 수의 합 배열 정렬
		Arrays.sort(twoSum);

		// 결과값 초기화
		int result = 0;

		// 세 번째 수와 두 수의 합을 맞춰 최대값 찾기
		for (int i = N - 1; i >= 0; i--) { // 최대값을 찾기 위해서 뒤에서 부터 시작
			for (int j = 0; j < i; j++) {
				// arr[i] - arr[j]가 twoSum에 있는지 확인
				// Arrays.binarySearch : 찾고자 하는 값이 배열에 있으면 그 값의 인덱스 반환 
                // >= : 해당 값이 배열 내에 있다는 것을 의미 [즉, 찾고자 하는 값이 없으면 음수 반환]
				if (Arrays.binarySearch(twoSum, arr[i] - arr[j]) >= 0) { 
					result = Math.max(result, arr[i]);
				}
			}
		}

		// 최종 결과 출력
		System.out.println(result);
		
	} // main
} // class
