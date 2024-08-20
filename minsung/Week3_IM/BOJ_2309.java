import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		int index1;
		int index2;

		out: for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - arr[i] - arr[j] == 100) {
					arr[i] = 0;
					arr[j] = 0;
					break out;
				}
			}
		}

		Arrays.sort(arr);
		for (int i = 2; i < 9; i++) {
			System.out.println(arr[i]);
		}
	}

}
