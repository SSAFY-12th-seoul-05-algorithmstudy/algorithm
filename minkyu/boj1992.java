import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[][] data = {};
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int dataSize = Integer.parseInt(br.readLine());
		data = new char[dataSize][dataSize];
		// 데이터 저장
		for (int i = 0; i < dataSize; i++) {
			String curLine = br.readLine();
			for (int j = 0; j < dataSize; j++) {
				data[i][j] = curLine.charAt(j);
			}
		}

		condensing(dataSize, 0, 0);

		System.out.println(sb);
	}

	public static void condensing(int curSize, int startRow, int startCol) {
		if (curSize == 1) {
			sb.append(data[startRow][startCol]);
			return;
		}

		char curVal = data[startRow][startCol];
		boolean isSame = true;
		main: for (int r = 0; r < curSize; r++) {
			for (int c = 0; c < curSize; c++) {
				if (data[startRow + r][startCol + c] != curVal) {
					isSame = false;
					break main;
				}
			}
		}
		if (isSame) {
			sb.append(curVal);
			return;
		}

		int nextSize = curSize / 2;
		// 데이터의 시작 부분
		sb.append('(');
		// 데이터 좌상, 우상, 좌하, 우하 등으로 영상 압축
		for (int i = 0; i < 2; i++) {
			int curStartRow = startRow + i * nextSize;
			for (int j = 0; j < 2; j++) {
				int curStartCol = startCol + j * nextSize;
				condensing(nextSize, curStartRow, curStartCol);
			}
		}
		sb.append(')');

	}
}