import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj2346 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); 
		

		// 풍선의 종이 값 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine());		

		// 큐에 (풍선번호, 종이 값)로 추가
		Deque<int[]> d = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			d.add(new int[] { i + 1, Integer.parseInt(st.nextToken())});
		}

		// 터뜨린 풍선번호 기록
		StringBuilder sb = new StringBuilder();
		// d가 빌때까지 반복
		while (!d.isEmpty()) { 
			int[] now = d.poll(); // 제일 앞 풍선 제거(=터뜨리기)
			sb.append(now[0]).append(" "); // sb에 제거된 풍선 번호 기록 

			// 이동
			if (d.size() > 0) {
				int move = now[1]; // 터뜨린 풍선 종이 값 = 이동
				
				if (move > 0) {
					// 오른쪽 방향 이동
					for (int i = 0; i < move - 1; i++) {
						d.add(d.poll());
					}
				} else { // 0 고려x
					// 왼쪽 방향 이동 
					for (int i = 0; i < -move; i++) {
						d.addFirst(d.pollLast());
					}
				}
			}
		}
		System.out.println(sb.toString());
	}// main
}
