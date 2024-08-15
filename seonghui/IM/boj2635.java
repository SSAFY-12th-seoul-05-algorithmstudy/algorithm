import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj2635 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int num = sc.nextInt();

		// 수열 리스트
		List<Integer> ans = new ArrayList<>();
		int max = -1;

		// 완전탐색
		// 두번째수가 num의 절반 값보다 적으면 무조건 수열 길이는 3개이므로 제외
		for (int next = num/2; next <= num; next++) {
			List<Integer> chkSeq = function(num, next);

			if (chkSeq.size() > max) {
				max = chkSeq.size();
				ans = chkSeq;
			}
		}
		sb.append(max).append("\n");
		for (int elem : ans) {
			sb.append(elem).append(" ");
		}

		System.out.println(sb.toString());
	}

	public static List<Integer> function(int num1, int num2) {

		List<Integer> seq = new ArrayList<>();

		// 첫번째수 두번째수 수열에 추가
		seq.add(num1);
		seq.add(num2);

		// 다음 수 계산
		while (true) {
			int nextNum = seq.get(seq.size() - 2) - seq.get(seq.size() - 1);

			if (nextNum < 0)
				break;
			seq.add(nextNum);
		}
		return seq;
	}

}
