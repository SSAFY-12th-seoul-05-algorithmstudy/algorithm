import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 색종이 수
        
        int[][] area = new int[1001][1001];	// 색종이가 놓일 공간배열
        int[] result = new int[N];	// 최종결과 색종이의 면적
        
        for(int i=1;i<=N;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine()); // 색종이 정보를 읽어온다.
        	
        	int r = Integer.parseInt(st.nextToken());	// x좌표
        	int c = Integer.parseInt(st.nextToken());	// y좌표
        	int width = Integer.parseInt(st.nextToken());	// 가로
        	int length = Integer.parseInt(st.nextToken());	// 세로
        	
        	// area에 (r,c)에서 x=width,y=length만큼 색종이번호를 기록
        	for (int a=0;a<width;a++) {
        		for(int b=0;b<length;b++) {
        			area[a+r][b+c]=i; // 색종이 번호를 입력, 겹치면 더 높은 숫자가 쌓인다.
        		}
        	}
        }
        // area에 적힌 색종이번호를 색종이의 면적 배열에 넣는다.
        for(int i=0;i<area.length;i++) {
        	for(int j=0;j<area[0].length;j++) {
        		for(int num=1;num<=N;num++) {
        			if (area[i][j]==num)
        				result[num-1]++;
        		}
        	}
        }
        // 배열을 원하는 형태로 출력
        for (int i=0;i<N;i++) {
        	System.out.println(result[i]);
        }
    }
}