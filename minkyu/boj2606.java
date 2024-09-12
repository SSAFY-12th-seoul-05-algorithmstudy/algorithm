import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int comCnt = Integer.parseInt(br.readLine());
		int lineCnt = Integer.parseInt(br.readLine());
		List<Integer>[] adjList = new ArrayList[comCnt + 1];
		for (int i = 1; i <= comCnt; i++)
			adjList[i] = new ArrayList<>();
		for (int i = 0; i < lineCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjList[a].add(b);
			adjList[b].add(a);
		}
		
		boolean[] hasVisited = new boolean[comCnt + 1];
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(1);
		hasVisited[1] = true;
		int cnt = 0;
		while(!q.isEmpty()) {
			int tmp = q.poll();
			for (int i = 0; i < adjList[tmp].size(); i++) {
				int curNum = adjList[tmp].get(i);
				if (!hasVisited[curNum]) {
					q.offer(curNum);
					hasVisited[curNum] = true;
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}