import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static boolean visited[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 구슬 갯수(1부터)
		int M = sc.nextInt(); // 몇번 올렸는지(=간선
		ArrayList<Integer>[] heavy = new ArrayList[N+1];
		ArrayList<Integer>[] light = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++){
		heavy[i] = new ArrayList<>();
		light[i] = new ArrayList<>();
		}
			
		for (int i = 0; i < M; i++) {
			int H = sc.nextInt(); // 무거운거
			int L = sc.nextInt(); // 가벼운거
			heavy[H].add(L);
			light[L].add(H);
		}
		int margino = (N + 1) / 2;
		int notmiddle=0;

		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			int hcnt = bfs(heavy, i);
			int lcnt = bfs(light, i);

			if (hcnt >= margino || lcnt >= margino) {
				notmiddle++;
			}
		}
		System.out.println(notmiddle);

	}// main

	static int bfs(ArrayList<Integer>[] list, int num) {
		Queue<Integer> q = new LinkedList<>();
		q.add(num);
		visited[num] = true;
		int cnt = 0;
		while (!q.isEmpty()) {
			int curr = q.poll();
			cnt++;
			for (int next : list[curr]) {
				if (!visited[next]) {
					visited[next] = true;
					q.add(next);
				}
			}
		}
		return cnt-1;
	}
}
