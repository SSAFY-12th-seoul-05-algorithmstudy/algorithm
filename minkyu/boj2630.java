import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] paperInfo = {};
    static int blueCnt = 0;
    static int whiteCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int paperSize = Integer.parseInt(br.readLine());
        paperInfo = new int[paperSize][paperSize];
        for (int i = 0; i < paperSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < paperSize; j++) {
                paperInfo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        paperRecur(paperSize, 0, 0);
        System.out.println(whiteCnt);
        System.out.println(blueCnt);
    }

    public static void paperRecur(int curSize, int rowStart, int colStart) {
    	if (curSize == 1) {
    		if (paperInfo[rowStart][colStart] == 0)
    			whiteCnt++;
    		else
    			blueCnt++;
    		return;
    	}
    	
        int curColor = paperInfo[rowStart][colStart];        
        boolean isSame = true;
        main : for (int i = 0; i < curSize; i++) {
            for (int j = 0; j < curSize; j++) {
                if (curColor != paperInfo[rowStart + i][colStart + j]) {
                    isSame = false;
                    break main;
                }
            }
        }
        if (isSame) {
            if (curColor == 0)
                whiteCnt++;
            else
                blueCnt++;
            return;
        }
        
        int nextSize = curSize / 2;
        for (int i = 0; i < 2; i++) {
        	int curRowStart = rowStart + i * nextSize;
        	for (int j = 0; j < 2; j++) {
        		int curColStart = colStart + j * nextSize;
        		paperRecur(nextSize, curRowStart, curColStart);
        	}
        }
    }
}