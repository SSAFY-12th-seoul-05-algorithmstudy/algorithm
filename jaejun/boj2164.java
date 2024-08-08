package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj2164 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1;i<=N;i++) {
		q.add(i);	
		}
		
		while(q.size()!=1) {
			q.poll();
			q.add(q.poll());
			
		}
		
		sb.append(q.poll());
		System.out.println(sb);
	}
}
