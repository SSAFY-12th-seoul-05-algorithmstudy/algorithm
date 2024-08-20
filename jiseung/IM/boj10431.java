import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int P = Integer.parseInt(br.readLine()); // 테스트케이스 수
		
		for(int tc=1; tc<=P;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int[] arr = new int[20];
			
			arr[0]=Integer.parseInt(st.nextToken()); // 처음사람은 바로 들어감
			int count = 0;
			for (int i=1;i<20;i++) {
				int next = Integer.parseInt(st.nextToken());
				for(int j=0;j<i;j++) {
					if(arr[j]>next) {
						int temp = arr[j];
						arr[j]=next;
						for(int k=j+1;k<=i;k++) {
							next = temp;
							temp = arr[k];
							arr[k]=next;
							count++;
						}
					}
					else {
						arr[i]=next;
					}
				}
			}
			System.out.println(num+" "+count);
		}
	}
}