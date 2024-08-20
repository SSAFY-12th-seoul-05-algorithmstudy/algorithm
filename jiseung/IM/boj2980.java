import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st1 = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st1.nextToken());	// 신호등 개수 N
		int L = Integer.parseInt(st1.nextToken());  // 도로의 길이 L
		
		int result = 0;
		int d = 0;
		int D=0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st2.nextToken()); // 신호등 위치 D
			int R = Integer.parseInt(st2.nextToken()); // 빨간불 지속시간 R
			int G = Integer.parseInt(st2.nextToken()); // 초록불 지속시간 G
			result +=(D-d);	// 신호등 위치에 도착 (D-d)
			
			while(result%(R+G)<R) {
				result++;
			}
			d=D; // 신호등위치를 d에 저장
			
			
			// R<(Time+D)<R+G
		}
		result+=(L-D);
		
		System.out.println(result);
	}
}