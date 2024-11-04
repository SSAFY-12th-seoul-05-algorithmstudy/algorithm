import java.util.*;
import java.io.*;

public class Main {
	static int[] childCnt;
	static List<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++)
			list[i] = new ArrayList<>();

		childCnt = new int[N + 1];
		Arrays.fill(childCnt, 1);

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());

			list[U].add(V);
			list[V].add(U);
		}
		recur(R, -1);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			int idx = Integer.parseInt(br.readLine());
			sb.append(childCnt[idx]).append("\n");
		}
		System.out.println(sb);
	}

	static void recur(int idx, int parent) {
		for (int i = 0; i < list[idx].size(); i++)
			if (parent != list[idx].get(i)) recur(list[idx].get(i), idx);

		if (parent != -1)
			childCnt[parent] += childCnt[idx];
	}
}