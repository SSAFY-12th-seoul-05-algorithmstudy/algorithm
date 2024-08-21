import java.util.Scanner;

// 병합정렬 : 크기가 1될때까지 반씩 분할하며 인접한 숫자 비교하고 정렬해가면서 다시 합침
public class boj24060 {
	static int K; //저장횟수
	static int res = -1; // 저장횟수가 K보다 작을시 -1 출력
	static int chk = 0; // 저장횟수 체크용
	static int[] sortArr; // 정렬 저장 배열
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		K = sc.nextInt(); 
		
		int[] A = new int[n];
		for(int i = 0; i < n; i++) { // 배열A입력받기
			A[i] = sc.nextInt();
		}
		sortArr = new int[n]; // 정렬저장배열 n크기로 초기화
		
		merge_sort(A, 0, n-1);
		System.out.println(res);
	}
	
	static void merge_sort(int[] A, int l, int r) {
		if(l < r) {
			// 중간지점 구하기
			int m = (l+r)/2;
			// 전반부 정렬
			merge_sort(A, l, m);
			// 후반부 정렬
			merge_sort(A, m+1, r);
			// 병합
			merge(A, l, m, r);
		}
	}
	
	static void merge(int[] A, int l, int m, int r) {
		// 왼쪽정렬 시작점, 오른쪽정렬 시작점, 정렬배열idx
		int i = l, j = m+1, t = 0;
		
		// 작은 값부터 저장
		while(i<=m && j<=r) { 
			if(A[i] <= A[j]) {
				sortArr[t++] = A[i++]; 
			} else {
				sortArr[t++] = A[j++];
			}
		}
		
		// 정렬 후 왼쪽 배열 부분이 남은 경우
		while(i<=m) {
			sortArr[t++] = A[i++];
		}
		
		// 오른쪽 배열 부분이 남은 경우
		while(j<=r) {
			sortArr[t++] = A[j++];
		}
		
		i = l;
		t = 0;
		while(i<=r) { // 배열A에 결과저장
			chk++;
			if(chk==K) { // 저장 체크횟수와 K값 같으면 t idx값 저장하고나서 종료
				res = sortArr[t]; 
				return;
			}
			A[i++] = sortArr[t++];
		}
	
	}

}
