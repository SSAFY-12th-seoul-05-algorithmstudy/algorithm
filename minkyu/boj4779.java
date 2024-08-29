import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = br.readLine()) != null) {
			int n = Integer.parseInt(line);
			int barCnt = (int)(Math.pow(3, n));
			char[] curLine = new char[barCnt];
			for (int i = 0; i < barCnt; i++)
				curLine[i] = '-';
			
			cantour(curLine, barCnt, 0, barCnt - 1);
			
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < barCnt; i++)
				sb.append(curLine[i]);
			System.out.println(sb);
		}
	}
	
	public static void cantour(char[] curLine, int curLength, int start, int end) {
		if (start == end || curLength == 1)
			return;
		
		curLength /= 3;
		
		for (int i = start + curLength; i <= end - curLength; i++)
			curLine[i] = ' ';
		
		cantour(curLine, curLength, start, start + curLength - 1);
		cantour(curLine, curLength, end - curLength + 1, end);
	}
}