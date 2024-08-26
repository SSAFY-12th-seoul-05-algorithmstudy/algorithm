import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4779 {
	static int N;
	static StringBuilder answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		
		while((str = br.readLine()) != null) {
			N = Integer.parseInt(str);
			answer = new StringBuilder();
			int length = (int) Math.pow(3, N);
			
			for(int i=0; i<length; i++) {
				answer.append("-");
			}
			
			Cantor(0, length);
			System.out.println(answer);
		}
	} // main
	
	public static void Cantor(int start, int size) {
		
		if(size == 1)
			return;
		
		int newSize = size/3;
		
		for(int i=start + newSize; i<start+newSize*2; i++) {
			answer.setCharAt(i, ' ');
		}
		
		Cantor(start, newSize); // 앞
		Cantor(start+newSize*2, newSize); // 뒤
	}
}
