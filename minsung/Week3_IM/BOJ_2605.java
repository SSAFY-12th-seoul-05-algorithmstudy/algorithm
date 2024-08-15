import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BOJ_2605 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		List<Integer> students = new ArrayList<>();

		for (int i = 0; i < N; i++) {

			if (students.isEmpty()) {
				students.add(i + 1);
				continue;
			}
			students.add(students.size() - arr[i], i + 1);

		}

		for (int i = 0; i < N; i++) {
			System.out.print(students.get(i)+" ");

		}

	}

}
