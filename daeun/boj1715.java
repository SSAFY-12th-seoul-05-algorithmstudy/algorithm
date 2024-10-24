import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>(); // 기본 오름차순

		int N= Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());

			pq.add(num);
		}

		int count = 0;
		while (pq.size()>1) {
			int sum1 = pq.poll();
			int sum2 = pq.poll();
			int sum = sum1+sum2;
			count += sum;
			pq.add(sum);
		}

	

		System.out.println(count);
	}// main
}
