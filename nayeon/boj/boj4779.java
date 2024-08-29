import java.util.Scanner;

// 칸토어.4779
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextInt()) {
			int n = sc.nextInt();
			System.out.println(칸토어(n));
		}

		sc.close();

		// scanner.hasNextInt() 사용
		// 입력이 더 있는지 확인
		// 반복문을 돌면서 n을 입력받고, 칸토어 함수를 호출하여 결과 출력
		// 입력이 더 이상 없으면 프로그램 종료

	}

	public static String 칸토어(int n) {
		if (n == 0) {
			return "-";
		}

		String prev = 칸토어(n - 1);

		// StringBuilder를 사용하여 메모리 효율 개선
		StringBuilder sb = new StringBuilder();
		sb.append(prev);

		// 공백 추가
		for (int i = 0; i < prev.length(); i++) {
			sb.append(" ");
		}

		sb.append(prev);

		return sb.toString();
	}

	// 아래 방식은 메모리 초과 뜸 ,,,
//	public static String 칸토어(int n) {
//		if (n == 0) {
//			return "-";
//		}
//
//		// 전단계 규칙 : prev
//		String prev = 칸토어(n - 1);
//
//		String p = "";
//		for (int i = 0; i < prev.length(); i++) {
//			p += " ";
//		}
////		String p = " ".repeat(prev.length());
//
//		return prev + p + prev;
//
//	}

}

// 칸토어(N-1) + 전 단계 문자열 길이만큼 공백 + 칸토어(N-1)
