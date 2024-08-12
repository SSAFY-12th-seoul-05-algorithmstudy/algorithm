<<<<<<< HEAD
<<<<<<< HEAD
=======
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
>>>>>>> 30e3e44dc02f02563e89496518413f8a4321adae

public class boj1158 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); // 입력 띄어쓰기 인식
		StringBuilder rst = new StringBuilder(); // 답 출력
		Queue<Integer> queue = new LinkedList<>(); // 큐 선언

<<<<<<< HEAD
=======
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1158 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); // 입력 띄어쓰기 인식
		StringBuilder rst = new StringBuilder(); // 답 출력
		Queue<Integer> queue = new LinkedList<>(); // 큐 선언

=======
>>>>>>> 30e3e44dc02f02563e89496518413f8a4321adae
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		rst.append("<"); // 출력 형식 맞추기
		for(int i=1; i<=N; i++) {
			queue.add(i); // 1부터 N까지의 숫자 queue에 add
		}
		
		while(!queue.isEmpty()) {
			
			for(int i=0; i<K-1; i++) { // K번째 숫자가 나올 때까지
				queue.add(queue.poll()); // 첫번째 숫자를 마지막으로 보냄
			}
			rst.append(queue.poll()); // K번째 숫자 결과에 추가

			if(!queue.isEmpty()) {
				rst.append(", "); // 출력 형식 맞추기
			}
		}
		rst.append(">"); // 출력 형식 맞추기
		
		System.out.println(rst); // 결과 출력
	}
<<<<<<< HEAD
>>>>>>> f4661210b1e540768f0f169f939d106cf5b5e1eb
=======
>>>>>>> 30e3e44dc02f02563e89496518413f8a4321adae
}
