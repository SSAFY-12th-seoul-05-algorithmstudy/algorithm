import java.util.*;
import java.io.*;

public class Main {
	static int[] p = {};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int peopleCnt = Integer.parseInt(st.nextToken());
		int partyCnt = Integer.parseInt(st.nextToken());
		 
		p = new int[peopleCnt + 1];
		for (int i = 1; i <= peopleCnt; i++)
			p[i] = i;
		st = new StringTokenizer(br.readLine());
		Set<Integer> trueSet = new HashSet<>();
		int trueCnt = Integer.parseInt(st.nextToken());
		for (int i = 0; i < trueCnt; i++)
			trueSet.add(Integer.parseInt(st.nextToken()));
		
		int[][] parties = new int[partyCnt][];
		
		// 각 파티별로 합치기
		for (int i = 0; i < partyCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int curCnt = Integer.parseInt(st.nextToken());
			int[] curParty = new int[curCnt];
			int first = Integer.parseInt(st.nextToken());
			curParty[0] = first;
			int x = findSet(first);
			for (int j = 1; j < curCnt; j++) {
				curParty[j] = Integer.parseInt(st.nextToken());
				int y = findSet(curParty[j]);
				if (x != y)
					union(x, y);
			}
			parties[i] = curParty;
		}
		// 파인드셋으로 엮인 참 그룹의 대리자가 어떤 것인지 파악
		Set<Integer> trulySet = new HashSet<>();
		for (int i : trueSet)
			trulySet.add(findSet(i));
		
		int cnt = 0;
		// 각 파티별로 참인 그룹에 속하는 것이 있는지 파악
		main : for (int i = 0; i < partyCnt; i++) {
			for (int j = 0; j < parties[i].length; j++) {
				if (trulySet.contains(findSet(parties[i][j])))
					continue main;
			}
			cnt++;
		}
		System.out.println(cnt);
	}
	
	public static int findSet(int x) {
		if (p[x] != x)
			p[x] = findSet(p[x]);
		return p[x];
	}
	
	public static void union(int x, int y) {
		p[y] = x;
	}
}