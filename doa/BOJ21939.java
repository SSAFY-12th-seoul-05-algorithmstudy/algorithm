import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ21939 {

	static class prob implements Comparable<prob> {
		int problem, difficulty, count;

		public prob(int problem, int difficulty) {
			super();
			this.problem = problem;
			this.difficulty = difficulty;
		}

		 @Override
	        public int compareTo(prob o) {
	            // 난이도가 높은 것부터 먼저 오도록
	            if (this.difficulty != o.difficulty) {
	                return Integer.compare(this.difficulty, o.difficulty);
	            }
	            // 난이도가 같을 경우 문제 번호가 큰 것 우선
	            return this.problem - o.problem;
	        }

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		PriorityQueue<prob> low = new PriorityQueue<prob>();
		PriorityQueue<prob> high = new PriorityQueue<prob>(Collections.reverseOrder());
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			int P = sc.nextInt();
			int L = sc.nextInt();
			low.add(new prob(P, L));
			high.add(new prob(P, L));
			map.put(P,L);
		}

		N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			String commend = sc.next();

			if (commend.equals("recommend")) {
				int num = sc.nextInt();
				if (num == 1) {
					while(!high.isEmpty()) {
						prob top = high.peek();
						 if (map.containsKey(top.problem) && map.get(top.problem) == top.difficulty) {
	                            System.out.println(top.problem);
	                            break;
	                        }
						 high.poll();
					}


				} else {

					while(!low.isEmpty()) {
						prob top = low.peek();
						 if (map.containsKey(top.problem) && map.get(top.problem) == top.difficulty) {
	                            System.out.println(top.problem);
	                            break;
	                        }
						low.poll();
					}
					
					

				}
			} else if (commend.equals("solved")) {
				int num = sc.nextInt();
				map.remove(num);

			}
			//추가할 경우
			else {
				int P = sc.nextInt();
				int L = sc.nextInt();
				low.add(new prob(P, L));
				high.add(new prob(P, L));
				map.put(P,L);
			}

		}

	}


}
