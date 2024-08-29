import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String str;
		// 다음 줄을 읽었을 때 null이 아닐때 까지
		while((str = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(str);
			if(st.hasMoreTokens()) {
			int N = Integer.parseInt(st.nextToken());
			System.out.println(cantor(N));
			}
			else {
				break;
			}
		}
	}
	
	// cantor 집합 만들기
	public static String cantor(int N) {
		// 0일땐 "-"하나 출력
		if(N==0) {
			return "-";
		}
		// 그 외엔 cantor(N-1)+" "*(3^(n-1))+cantor(N-1)
		else {
			StringBuilder sb = new StringBuilder();
			sb.append(cantor(N-1));
			int num = (int) Math.pow(3,N-1);
			for(int i=0;i<num;i++) {
				sb.append(" ");
			}
			sb.append(cantor(N-1));		
			return sb.toString();
		}
	}
}