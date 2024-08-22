import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(hanoi(N));
		move(N,1,3);
		
		bw.flush();
	}
	
	// 원판 옮긴 횟수를 계산하는 메서드
	public static int hanoi(int N) {
		if (N==1) {
			return 1;
		}
		return 2*(hanoi(N-1))+1;
	}
	
	// N번 원판을 현재위치에서 다음위치로 옮기는 메서드
	public static void move(int N,int now,int next) throws IOException {
		if(N==1) {	// 1개남았으면
			bw.write(now+" "+next+"\n");
		}
		else {	
			move(N-1,now,(6-now-next)); // N-1원판을 통째로 현재위치에서 현재위치와 다음위치가 아닌 곳을 옮김
			bw.write(now+" "+next+"\n"); // 현재위치 원판을 next위치로 옮김
			move(N-1,(6-now-next),next); // N-1원판을 다시 옮겨옴
		}
	}
}
