import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String stick = br.readLine();
		Stack<Character> stickInfo = new Stack<Character>();
		for (int i = stick.length() - 1; i >= 0; i--)
			stickInfo.push(stick.charAt(i));
		
		int pieceCnt = 0;
		//레이저 판별용
		boolean isStickEnd = false;
		int stickCnt = 0;
		for (int i = 0; i < stick.length(); i++) {
			char curChar = stickInfo.pop();
			if (curChar == '(') {
				isStickEnd = false;
				stickCnt++;
			}else {
				//레이저인 경우
				if (!isStickEnd) {
					stickCnt--;
					pieceCnt += stickCnt;
					isStickEnd = true;
				}else {
					stickCnt--;
					pieceCnt++;
				}
			}
		}
		System.out.println(pieceCnt);
	}
}