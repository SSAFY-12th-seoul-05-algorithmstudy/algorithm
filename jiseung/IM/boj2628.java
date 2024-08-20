import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int next = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st1 = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st1.nextToken()); // 가로
		int c = Integer.parseInt(st1.nextToken()); // 세로

		int[] row = new int[r+1];	//가로길이배열
		int[] col = new int[c+1];	//세로길이배열
		row[0]++;
		row[r]++;
		col[0]++;
		col[c]++;
		int maxrow = 0;
		int maxcol = 0;
		int T = Integer.parseInt(br.readLine()); // 테스트케이스

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken()); // 가로세로 판별
			int b = Integer.parseInt(st2.nextToken()); // 점선판별
			
			if(a==0) {	// 가로로 자름 (세로좌표확인)
				col[b]++;
			}
			else {
				row[b]++;
			}
		}
		int cnt=0;
		for(int i=0;i<r;i++) {
			if(row[i]==0) {
				cnt++;
				maxrow = Math.max(maxrow, cnt);
			}
			else {
				cnt=0;
			}
		}
		for(int i=0;i<c;i++) {
			if(col[i]==0) {
				cnt++;
				maxcol = Math.max(maxcol, cnt);
			}
			else {
				cnt=0;
			}
		}
		System.out.println((maxrow+1)*(maxcol+1));
	}
}