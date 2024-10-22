import java.io.*;
import java.util.*;

public class Main {
    static class Problem implements Comparable<Problem> {

        int num,level,category;

        public Problem(int num, int level,int category) {
            this.num = num;
            this.level = level;
            this.category= category;
        }

        @Override
        public int compareTo(Problem other) {
            if (this.level == other.level) {
                return Integer.compare(this.num, other.num);
            }
            return Integer.compare(this.level, other.level);
        }
    }
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		TreeSet<Problem> problems = new TreeSet<>();
		List<TreeSet<Problem>> group = new ArrayList<>();
		for(int i=0;i<=100;i++) {
			group.add(new TreeSet<Problem>());
		}
		Map<Integer,int[]> problemInfo = new HashMap<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int level = Integer.parseInt(st.nextToken());
			int category = Integer.parseInt(st.nextToken());
			
			problems.add(new Problem(num,level,category));
			group.get(category).add(new Problem(num,level,category));
			problemInfo.put(num, new int[] {level,category});
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			int order;
			switch(command) {
			case("recommend"):
				int groupNum = Integer.parseInt(st.nextToken());
				order = Integer.parseInt(st.nextToken());
			if(order==1) {
				sb.append(group.get(groupNum).last().num).append("\n");
			}
			else {
				sb.append(group.get(groupNum).first().num).append("\n");
			}
			break;
			case("recommend2"):
				order = Integer.parseInt(st.nextToken());
			if(order==1) {
				sb.append(problems.last().num).append("\n");
			}
			else {
				sb.append(problems.first().num).append("\n");
			}
			break;
			case("recommend3"):
				order = Integer.parseInt(st.nextToken());
				int difficulty = Integer.parseInt(st.nextToken());
			if(order==1) {
				if (problems.ceiling(new Problem(0, difficulty, 0)) == null) {
					sb.append("-1\n");
				}
                else {
                	sb.append(problems.ceiling(new Problem(0, difficulty, 0)).num).append("\n");
                }
            } else {
                if (problems.lower(new Problem(0, difficulty, 0)) == null) {
                	sb.append("-1\n");
                }
                else {
                	sb.append(problems.lower(new Problem(0, difficulty, 0)).num).append("\n");
                }
			}
			break;
			case("add"):
				int num = Integer.parseInt(st.nextToken());
				int level = Integer.parseInt(st.nextToken());
				int category = Integer.parseInt(st.nextToken());
				problems.add(new Problem(num,level,category));
				group.get(category).add(new Problem(num,level,category));
				problemInfo.put(num, new int[] {level,category});
				break;
			case("solved"):
				int solNum = Integer.parseInt(st.nextToken());
				if(problemInfo.containsKey(solNum)) {
					int solLev = problemInfo.get(solNum)[0];
					int solCat = problemInfo.get(solNum)[1];
					problemInfo.remove(solNum);
					problems.remove(new Problem(solNum,solLev,solCat));
					group.get(solCat).remove(new Problem(solNum,solLev,solCat));
				}
				break;
			}
		}
		System.out.print(sb);
	}
}
