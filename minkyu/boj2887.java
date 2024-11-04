import java.util.*;
import java.io.*;

public class Main {
	static int[] p = {};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		// 서로소 집합 구현용
		p = new int[N];
		// 초기화
		for (int i = 0; i < N; i++)
			p[i] = i;
		
		List<int[]> xList = new ArrayList<>();
		List<int[]> yList = new ArrayList<>();
		List<int[]> zList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			xList.add(new int[] {i, Integer.parseInt(st.nextToken())});
			yList.add(new int[] {i, Integer.parseInt(st.nextToken())});
			zList.add(new int[] {i, Integer.parseInt(st.nextToken())});
		}
		
		// 오름 차순으로 정렬해서 인접한 것의 행성끼리만 간선을 생성해서 비교해주면 된다.
		Collections.sort(xList, (o1,o2) -> {
			return Integer.compare(o1[1], o2[1]);
		});
		Collections.sort(yList, (o1,o2) -> {
			return Integer.compare(o1[1], o2[1]);
		});
		Collections.sort(zList, (o1,o2) -> {
			return Integer.compare(o1[1], o2[1]);
		});
		
		List<int[]> tunnels = new ArrayList<>();
		for (int i = 0; i < N - 1; i++) {
			tunnels.add(new int[] {xList.get(i)[0], xList.get(i + 1)[0], Math.abs(xList.get(i)[1] - xList.get(i+1)[1])});
			tunnels.add(new int[] {yList.get(i)[0], yList.get(i + 1)[0], Math.abs(yList.get(i)[1] - yList.get(i+1)[1])});
			tunnels.add(new int[] {zList.get(i)[0], zList.get(i + 1)[0], Math.abs(zList.get(i)[1] - zList.get(i+1)[1])});
		}
		// 걸리는 비용에 대해 오름차순 정렬
		Collections.sort(tunnels, (o1,o2) ->{
			return Integer.compare(o1[2], o2[2]);
		});
		
		int cnt = 0;
		long sum = 0;
		for (int i = 0; i < tunnels.size(); i++) {
			int x = findSet(tunnels.get(i)[0]);
			int y = findSet(tunnels.get(i)[1]);
			int cost = tunnels.get(i)[2];
			if (x != y) {
				union(x, y);
				sum += cost;
				cnt++;
			}
			
			if (cnt == N - 1)
				break;
		}
		
		System.out.println(sum);
	}
	
	// 서로소 집합 대표자 확인
	public static int findSet(int x) {
		if (p[x] != x)
			p[x] = findSet(p[x]);
		return p[x];
	}
	
	// 서로소 집합 병합
	public static void union(int x, int y) {
		p[y] = x;
	}
}