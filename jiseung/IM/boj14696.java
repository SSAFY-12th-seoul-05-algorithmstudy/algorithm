import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 라운드 수
		
		
		for(int i=0;i<N;i++) {
			StringTokenizer stA = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stA.nextToken());
			
			StringTokenizer stB = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(stB.nextToken());
			
			
			int[] count = new int[5]; // 4,3,2,1 순으로 카운팅배열에 숫자를 센다.
			
			for (int p=0;p<a;p++) {
				int A = Integer.parseInt(stA.nextToken());
				for (int j=4;j>0;j--) {
					if (A == j) {
						count[j]++;
					}
				}
			}
			for (int p=0;p<b;p++) {
				int B = Integer.parseInt(stB.nextToken());
				for (int j=4;j>0;j--) {
					if (B == j) {
						count[j]--;
					}
				}
			}
			for (int j=4;j>0;j--) {
				if (count[j]>0) {
					System.out.println("A");
					break;
				}
				else if (count[j]<0) {
					System.out.println("B");
					break;
				}
				else {
					if(j==1) {
						System.out.println("D");
					}
					continue;
				}
			}
		}
	}
}