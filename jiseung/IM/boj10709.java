import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken()); // 남북방향길이
		int W = Integer.parseInt(st.nextToken()); // 동서방향길이
		
		int [][] sky = new int[H][W];
		for(int i=0;i<H;i++) {
			String str = br.readLine();
			for(int j=0;j<W;j++) {
				if(str.charAt(j)=='c') {
					sky[i][j]=0;
				}
				else {
					sky[i][j]=-1;
				}
			}
		}
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				if(sky[i][j]==0) {
					int count=1;
					while(j+1<W && sky[i][j+1]!=0) {
						sky[i][j+1]=count++;
						j++;
					}
				}
			}
		}
		for(int i=0;i<sky.length;i++) {
			for(int j=0;j<sky[i].length;j++) {
				System.out.print(sky[i][j]+" ");
			}
			System.out.println();
		}
	}	
}