import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder rst = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int cnt=1;
		
		Stack<Integer> S = new Stack<>();
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			while(true) {
				if(S.empty() || S.peek()<num) {
					S.push(cnt++);
					rst.append("+\n");
				}				
				if(S.peek() == num) {
					S.pop();
					rst.append("-\n");
					break;
				}
				if(S.peek() > num) {
					bw.write("NO");
					bw.flush();
					return;
				}
			}
		}
		
		System.out.println(rst);
	}
}
