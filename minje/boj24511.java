package baekjoon;
import java.util.Scanner;

public class queuestack {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr_queuestack = new int[N];
		int[] arr_in = new int[N];

		for (int i = 0; i < N; i++) {
			arr_queuestack[i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			arr_in[i] = sc.nextInt();
		}
		int M = sc.nextInt();
		int[] arr_input = new int[M];
		int tmp = 0;
		for (int i = 0; i < M; i++) {
			arr_input[i] = sc.nextInt();
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (arr_queuestack[j] == 0) {
					tmp = arr_input[i];
					arr_input[i] = arr_in[j];
					arr_in[j] = tmp;
				}
			}
			System.out.print(arr_input[i] + " ");
		}

		sc.close();
	}
}
