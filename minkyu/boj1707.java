import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			// 인접리스트 목록 정리
			List<Integer>[] adjList = new ArrayList[V + 1];
			for (int i = 1; i <= V; i++)
				adjList[i] = new ArrayList<>();
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adjList[a].add(b);
				adjList[b].add(a);
			}
			
			int[] color = new int[V + 1];
			Queue<int[]> q = new ArrayDeque<>();
			boolean isBinary = true;
			main : for (int j = 1; j <= V; j++) {
				if (color[j] == 0) {
					q.offer(new int[] {j,1});
					color[j] = 1;
					while(!q.isEmpty()) {
						int[] tmp = q.poll();
						for (int i = 0; i < adjList[tmp[0]].size(); i++) {
							int nextVal = adjList[tmp[0]].get(i);
							// 다음 번 색상이 비어있는 경우
							if (color[nextVal] == 0) {
								// 전의 값과 반대되는 색상을 넣는다.
								color[nextVal] = -tmp[1];
								q.offer(new int[] {nextVal, -tmp[1]});
							// 전과 색상이 같은 곳이 존재하면 이분 그래프가 아니다.
							}else if (color[nextVal] == tmp[1]) {
								isBinary = false;
								break main;
							}
						}
					}
				}
			}
			
			
			if (isBinary)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}