import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine()); // 자료구조의 개수 N

		// 수열의 자료구조
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st1.nextToken());
		}
		// 자료구조의 초기상태
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		Deque<Integer> deque = new ArrayDeque<>();
		
		// 타입이 큐일때만 입력받는다.
		for (int i=0; i<N;i++) {
			if(arr[i]==0) {
				deque.addLast(Integer.parseInt(st2.nextToken()));
			}
			else {
				st2.nextToken();
			}
		}
		// 입력수열 길이
		int length = Integer.parseInt(br.readLine());

		// 입력값
		StringTokenizer st3 = new StringTokenizer(br.readLine());
		
		// 결국 a를 addFirst하고 pollLast를 출력하는것과 같다.
		for (int i = 0; i < length; i++) {
			int a= Integer.parseInt(st3.nextToken());	// 입력값
			deque.addFirst(a);
			sb.append(deque.pollLast()).append(" ");
		}
		System.out.println(sb);
	}
}
// 1번줄 : 자료구조 갯수
// 2번줄 : 자료구조들의 상태 (0:큐 / 1:스택)
// 3번줄 : 길이N의 수열 -> 초기상태
// 4번줄 : 삽입할 수열의 길이
// 5번줄 : 삽입할 수열
// https://oesnuj.tistory.com/ent...

// 1 4 | a = 2
// 4 2 | a = 1
// 2 1 | a = 4
// 결국 a를 addFirst하고 pollLast를 출력하는것과 같다.