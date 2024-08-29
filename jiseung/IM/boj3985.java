import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int L = Integer.parseInt(br.readLine()); // 롤케이크 길이
		
		int N = Integer.parseInt(br.readLine()); // 방청객 수
		
		int[] arr = new int[L];
		int[] count = new int[N];
		
		int explength = 0;
		int exp = 0;
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			if((b-a+1)>explength) {
				exp = i;
				explength = Math.max(b-a+1,explength);
			}
			for(int j=a;j<=b;j++) {
				if(arr[j]==0) {
					arr[j]=i;
					count[i-1]++;
				}
			}
		}
		int reallength=0;
		int real = 0;
		for(int i=0;i<N;i++) {
			if(reallength<count[i]) {
				reallength = Math.max(reallength,count[i]);
				real=i+1;
			}
		}
		System.out.println(exp);
		System.out.println(real);
	}
}
