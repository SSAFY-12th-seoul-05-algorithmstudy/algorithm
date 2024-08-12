import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int idx = sc.nextInt();
			int val = 0;
			int[] cnt = new int[10];
			Queue<Integer> queue = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				int curVal = sc.nextInt();
				queue.offer(curVal);
				cnt[curVal]++;
				if (idx == i)
					val = curVal;
			}

			int printCnt = 0;
			main: for (int i = 0; i < N; i++) {
				int maxCnt = 0;
				int curMaxVal = 0;
				for (int j = 9; j > 0; j--) {
					if (cnt[j] != 0) {
						maxCnt = cnt[j];
						curMaxVal = j;
						cnt[j] = 0;
						break;
					}
				}

				while (true) {
					// 현재 맨 앞에 위치해 있던 값
					int curVal = queue.poll();
					// 현재 위치의 값이 최대인 경우
					if (curVal == curMaxVal) {
						// 찾고자 하는 위치의 값인 경우
						if (val == curVal && idx == 0) {
							printCnt++;
							break main;
						} else {
							printCnt++;
							maxCnt--;
						}
						// 현재 위치의 값이 최대가 아닌 경우 위치만 갱신
					} else
						queue.offer(curVal);

					// 찾고자 하는 값의 인덱스 갱신
					if (idx == 0)
						idx = queue.size() - 1;
					else
						idx--;
					// 프린트 하는 최대 값이 없는 경우 탈출
					if (maxCnt == 0)
						break;
				}
			}

			System.out.println(printCnt);
		}
	}
}