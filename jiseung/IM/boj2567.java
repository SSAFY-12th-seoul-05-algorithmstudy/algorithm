import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// 델타 상 - 우 - 하 - 좌
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 색종이 수

        int[][] area = new int[101][101]; // 색종이가 놓일 공간배열 0: 흰색 1: 검은색

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); // 색종이 정보를 읽어온다.

            int r = Integer.parseInt(st.nextToken()); // x좌표
            int c = Integer.parseInt(st.nextToken()); // y좌표
            int width = 10; // 가로
            int length = 10;// 세로

            // area에 (r,c)에서 x=width,y=length 색종이를 붙여서 원소값을 1로 바꾼다.
            for (int a = 0; a < width; a++) {
                for (int b = 0; b < length; b++) {
                    area[a + r][b + c] = 5;
                }
            }
        }
        int count=0;
        for (int a = 0; a < 101; a++) {
            for (int b = 0; b < 101; b++) {
            	for(int d=0;d<4;d++) {	// 델타4방향확인
            		if(a+dr[d]>=0 && a+dr[d]<100 && b+dc[d]>=0 && b+dc[d]<100 && area[a+dr[d]][b+dc[d]]==5 && area[a][b]!=5) {
            			count++;
            		}
            	}
            }
        }
        System.out.println(count);
    }
}