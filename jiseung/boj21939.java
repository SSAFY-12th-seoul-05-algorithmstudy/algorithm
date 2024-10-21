import java.io.*;
import java.util.*;

public class Main {
	static class Problem implements Comparable<Problem>{
		int num,level;
		
		Problem(int num, int level){
			this.num=num;
			this.level=level;
		}
		
		@Override
		public int compareTo(Problem other) {
			if(this.level!=other.level) {
				return Integer.compare(this.level, other.level);
			}
			return Integer.compare(this.num, other.num);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] problems = new int[100001];
		PriorityQueue<Problem> hard = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Problem> easy = new PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int level = Integer.parseInt(st.nextToken());
			hard.add(new Problem(num,level));
			easy.add(new Problem(num, level));
			problems[num]=level;
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			switch(command) {
			case("recommend"):
				int difficulty = Integer.parseInt(st.nextToken());
			if(difficulty==1) {
				while(true) {
					Problem hardP = hard.peek();
					if(hardP.level==problems[hardP.num]) {
						sb.append(hardP.num).append("\n");
						break;
					}
					hard.poll();
				}
			}
			else {
				while(true) {
					Problem easyP = easy.peek();
					if(easyP.level==problems[easyP.num]) {
						sb.append(easyP.num).append("\n");
						break;
					}
					easy.poll();
				}
			}
			break;
			case("add"):
				int num = Integer.parseInt(st.nextToken());
				int level = Integer.parseInt(st.nextToken());
				hard.add(new Problem(num,level));
				easy.add(new Problem(num,level));
				problems[num]=level;
				break;
			case("solved"):
				int solved = Integer.parseInt(st.nextToken());
				problems[solved]=0;
				break;
			}
		}
		System.out.print(sb);
	}
}