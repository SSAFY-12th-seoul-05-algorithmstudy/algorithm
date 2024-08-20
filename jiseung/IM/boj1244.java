import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 스위치 갯수
		
		
		int[] arr = new int[N];
		
		
		
		StringTokenizer st1 = new StringTokenizer(br.readLine()); // 스위치정보
		for(int i=0;i<N;i++){
			arr[i]=Integer.parseInt(st1.nextToken());
		}
		
		int student = Integer.parseInt(br.readLine()); // 학생 수
		
		for (int i=0;i<student;i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st2.nextToken());
			int num = Integer.parseInt(st2.nextToken());
			if(sex==1) { // 남학생이면
				for (int j=1;(j*num)-1<N;j++) {
					arr[(j*num)-1]= (arr[(j*num)-1]+1)%2;
				}
			}
			else { // 여학생이면
				arr[num-1]= (arr[num-1]+1)%2;
				int count=1;
				while(num-1+count<N && num-1-count>=0) {
					if(arr[num-1+count]==arr[num-1-count]) {
						arr[num-1+count] = (arr[num-1+count]+1)%2;
						arr[num-1-count] = (arr[num-1-count]+1)%2;
						count++;
					}
					else {
						break;
					}
				}
			}
		}
		int num = N/20;
		for(int i=0;i<=num;i++) {
			if(i==num) {
				for(int j=0;j<N%20;j++) {
					System.out.print(arr[i*20+j]+" ");
				}
			}
			else {
				for(int j=0;j<20;j++) {
					System.out.print(arr[i*20+j]+" ");
				}
				System.out.println();
			}
		}
		
	}
}