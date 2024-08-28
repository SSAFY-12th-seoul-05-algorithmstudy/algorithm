import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// BOJ 4779 칸토어 집합
public class boj4779 {
	static StringBuilder sb = new StringBuilder();
	static int length;
	static char[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputLine;

		while ((inputLine = br.readLine()) != null) {
			sb.setLength(0);
			int N = Integer.parseInt(inputLine);

			length = (int) Math.pow(3, N);
			arr = new char[length];

			for (int i = 0; i < length; i++) {
//				sb.append("-"); // 여기서 sb 에 쌓으니까 계속 메모리 초과
				arr[i] = '-';
			}

			func(0, length);
			
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i]);
			}
			
			System.out.println(sb.toString());
			
		}

	} // main

	public static void func(int startIndex, int size) {

		if (size == 1) {
//			return sb.toString();
			return;
		}

		// 삭제하는 로직
		for (int j = startIndex + size / 3; j < startIndex + size / 3 * 2; j++) {
//			sb.setCharAt((int) j, ' '); // sb에 쌓아놓고 나중에 지우기 X
			arr[j] = ' ';
		}

		for (int i = 0; i < 3; i++) {
			func(startIndex + (size / 3) * i, size / 3);
		}

//		return sb.toString();

	}
}
