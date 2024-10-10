import java.io.*;
import java.util.*;

public class Main {

	static class Date implements Comparable<Date> {
		int month, day;

		Date(int month, int day) {
			this.month = month;
			this.day = day;
		}

		public int compareTo(Date other) {
			if (this.month != other.month) {
				return Integer.compare(this.month, other.month);
			} else {
				return Integer.compare(this.day, other.day);
			}
		}
	}

	static class Flower implements Comparable<Flower> {
		Date start, end;

		Flower(Date start, Date end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Flower other) {
			if (this.start != other.start) {
				return this.start.compareTo(other.start);
			} else {
				return this.end.compareTo(other.end);
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Flower> flower = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			flower.add(new Flower(new Date(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())),
					new Date(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))));
		}

		PriorityQueue<Date> date = new PriorityQueue<>(Collections.reverseOrder());
		Date until = new Date(3, 1);
		Date target = new Date(11, 30);
		int count = 0;
		boolean possible = false;

		while (!flower.isEmpty()) {
			// 현재 꽃
			Flower current = flower.poll();
			
			// 못덮으면 다음으로
			if (current.end.compareTo(until) < 0) {
				continue;
			}
			
			// 덮은부분에서 시작하면 일단 date에 추가
			if (current.start.compareTo(until) <= 0) {
				date.add(current.end);
			}
			// 시작이 덮은부분을 넘어가면
			else {
				// date가 비어있으면 break;
				if(date.isEmpty()) {
					break;
				}
				// 비어있지 않으면 꺼내봄(최대로 덮은곳)
				else {
					Date last = date.peek();
					// 덮은지점 초기화
					until = last;
					
					if(current.start.compareTo(until)<=0) {
						count++;
						date.add(current.end);
					}
					else {
						break;
					}
				}
				
			}
			Date last = date.peek();
			if (last.compareTo(new Date(11, 30)) > 0) {
				count++;
				possible = true;
				break;
			}
		}
		if (possible) {
			System.out.println(count);
		} else {
			System.out.println(0);
		}
	}
}