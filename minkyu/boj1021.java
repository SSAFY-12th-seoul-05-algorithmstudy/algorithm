import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = sc.nextInt();
		// 각 뽑아내고자 하는 원소들의 위치
		int[] pos = new int[cnt];
		for (int i = 0; i < cnt; i++)
			pos[i] = sc.nextInt() - 1;
		
		int sum = 0;
		for (int i = 0; i < cnt; i++) {
			int diff = 0;
			if (pos[i] > N - pos[i]) {
				diff = N - pos[i];
				for (int j = i; j < cnt; j++) {
					pos[j] += diff;
					if (pos[j] >= N)
						pos[j] -= N;
					pos[j]--;
				}
			}
			else {
				diff = pos[i];
				for (int j = i; j < cnt; j++) {
					pos[j] -= diff;
					if (pos[j] < 0)
						pos[j] += N;
					pos[j]--;
				}
			}
			sum += diff;
			N--;
		}
		System.out.println(sum);
	}
}