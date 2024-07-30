import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10; // TestCase 수
		for(int tc=1;tc<=T;tc++) { // 열번 반복
			int num = sc.nextInt(); // 빌딩 갯수
			int[] arr = new int[num];
			
			int cnt = 0; // 카운트
			
			for (int i=0; i<num;i++) {
				arr[i] = sc.nextInt(); // 빌딩 층수 배열
			}
			for (int i=2; i < (num-2); i++) { // 앞에 두개, 뒤에 두개 제외하고 반복문
					int left = Math.max(arr[i-2],arr[i-1]); // left : 왼쪽건물중 높은것
					int right= Math.max(arr[i+1],arr[i+2]); // right : 오른쪽건물중 높은것
					int result = Math.max(left,right); // result : 왼쪽높은것과 오른쪽높은것 중 높은것
					if (arr[i]-result > 0) { // 자신과 result의 차이가 0보다 크면 조망이 확보됨
						cnt += arr[i]-result; // 그래서 이 조망이 확보된 층을 cnt에 더함
					}
				}
			System.out.println("#"+tc+" "+cnt);
		}
	}
}
