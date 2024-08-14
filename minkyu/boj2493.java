import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> towers = new Stack<>();
		for (int i = 0; i < T; i++)
			towers.push(Integer.parseInt(st.nextToken()));
		
		Stack<Integer> results = new Stack<>();
		Stack<Integer> idx = new Stack<>();
		int[] resultArr = new int[T];
		int curidx = 0;
		while(towers.size() != 0) {
			int curVal = towers.pop();
			while(results.size() > 0 && results.peek() < curVal) {
				results.pop();
				resultArr[idx.pop()] = T - curidx; 
			}
			results.push(curVal);
			idx.push(T - 1 -curidx);
			curidx++;
		}
		
		while(results.size() != 0) {
			results.pop();
			resultArr[idx.pop()] = 0;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < resultArr.length; i++)
			sb.append(resultArr[i]).append(" ");
		System.out.println(sb);
	}
}