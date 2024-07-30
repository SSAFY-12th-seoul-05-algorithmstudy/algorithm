import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); 
		for (int i = 1; i <= T; i++) { // 테스트 케이스의 갯수만큼 반복
			int sum = 0; // 합을 입력받을 변수
			int max = -1; //
			int min = 10000; //
			for(int j=0; j<10;j++) {
				int num = sc.nextInt();
				if(max < num) {
					max = num;
				}
				if(min > num) {
					min = num;
				}
				sum += num;
			}
		System.out.println("#"+ i + " "+Math.round((sum-max-min)/8));
		}
	}
}
