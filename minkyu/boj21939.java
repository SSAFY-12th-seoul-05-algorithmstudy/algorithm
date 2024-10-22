import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		// 난이도 오름차순, 난이도 동일한 경우 문제 번호 오름차순
		TreeSet<Problem> tree = new TreeSet<Problem>(new Comparator<Problem>() {
			@Override
			public int compare(Problem o1, Problem o2) {
				if (o1.hardness == o2.hardness)
					return Integer.compare(o1.no, o2.no);
				return Integer.compare(o1.hardness, o2.hardness);
			}
		});
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int no = Integer.parseInt(st.nextToken());
			int hardness = Integer.parseInt(st.nextToken());
			
			tree.add(new Problem(no, hardness));
			map.put(no, hardness);
		}
		
		int M = Integer.parseInt(br.readLine());
		
		int curNo;
		int curHardness;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			switch(cmd) {
			case "recommend":
				if (Integer.parseInt(st.nextToken()) == 1)
					System.out.println(tree.last().no);
				else
					System.out.println(tree.first().no);
				break;
			case "add":
				curNo = Integer.parseInt(st.nextToken());
				curHardness = Integer.parseInt(st.nextToken());
				tree.add(new Problem(curNo, curHardness));
				map.put(curNo, curHardness);
				break;
			case "solved":
				curNo = Integer.parseInt(st.nextToken());
				curHardness = map.get(curNo);
				tree.remove(new Problem(curNo, curHardness));
				map.remove(curNo);
				break;
			}
		}
	}
	
}

class Problem{
	int no;
	int hardness;
	public Problem(int no, int hardness) {
		this.no = no;
		this.hardness = hardness;
	}
}