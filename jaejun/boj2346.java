package baekjoon;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class boj2346 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deque<balloon> d = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			int pap = sc.nextInt();
			d.add(new balloon(i, pap));
		}
		while (!d.isEmpty()) {
			sb.append(d.getFirst().no).append(" ");
			int pap = d.poll().pap;
			if (d.isEmpty()) {
				break;
			}
			if (pap > 0) {
				for (int j = 1; j < pap; j++) {
					d.addLast(d.pollFirst());
				}
			} else { // 왼쪽으로 갈때는 이미 d.poll로 인해서 이미 오른쪽으로 한칸 갔기 때문에 k=0부터 시작
				for (int k = 0; k < Math.abs(pap); k++) {
					d.addFirst(d.pollLast());
				}
			}
		}
		System.out.println(sb.toString());
	}
// main
}

class balloon {
	int no;
	int pap;

	public balloon(int no, int pap) {
		super();
		this.no = no;
		this.pap = pap;
	}
}