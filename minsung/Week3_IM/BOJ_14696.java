import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int t = 1; t <= N; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arrA = new int[4];
			int A = Integer.parseInt(st.nextToken());
			for (int a = 0; a < A; a++) {
				arrA[Integer.parseInt(st.nextToken()) - 1]++;

			}
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int[] arrB = new int[4];
			int B = Integer.parseInt(st2.nextToken());
			for (int b = 0; b < B; b++) {
				arrB[Integer.parseInt(st2.nextToken()) - 1]++;

			}
			boolean drawFlag = true;
			for (int i = 3; i >= 0; i--) {
				if (arrA[i] == arrB[i]) {
					continue;
				} else if (arrA[i] > arrB[i]) {
					System.out.println("A");
					drawFlag = false;
					break;
				} else {
					System.out.println("B");
					drawFlag = false;
					break;
				}

			}
			if (drawFlag) {
				System.out.println("D");
			}
		}

	}
}
