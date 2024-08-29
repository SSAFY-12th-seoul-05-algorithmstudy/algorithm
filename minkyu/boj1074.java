import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int searchCnt;
	static int targetRow;
	static int targetCol;
	static boolean isFound = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arrSize = Integer.parseInt(st.nextToken());
		targetRow = Integer.parseInt(st.nextToken());
		targetCol = Integer.parseInt(st.nextToken());

		search((int) Math.pow(2, arrSize), 0, 0);
		System.out.println(searchCnt);
	}

	public static void search(int curSize, int startRow, int startCol) {
		if (isFound)
			return;

		if (curSize == 1) {
			if (startRow == targetRow && startCol == targetCol) {
				isFound = true;
				return;
			}
			searchCnt++;
			return;
		}

		int nextSize = curSize / 2;
		for (int i = 0; i < 2; i++) {
			int curStartRow = startRow + i * nextSize;
			for (int j = 0; j < 2; j++) {
				int curStartCol = startCol + j * nextSize;
				if (isFound)
					return;
				if (curStartRow <= targetRow && targetRow < curStartRow + nextSize &&
						curStartCol <= targetCol && targetCol < curStartCol + nextSize)
					search(nextSize, curStartRow, curStartCol);
				else
					searchCnt += nextSize * nextSize;
			}
		}
	}
}