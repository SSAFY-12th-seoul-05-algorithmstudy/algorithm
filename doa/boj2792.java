import java.util.Scanner;

public class boj2792 {
	

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		//아이들의 수 N과 색상의 수 M
		int N = sc.nextInt();
		int M = sc.nextInt();
	
		int[] jewl = new int[M];
		
		long max =0;
		for(int i=0 ;i<M ; i++) {
			
			jewl[i] = sc.nextInt();
			max = Math.max(max,jewl[i]);
			
		}
		
		long left = 1;
		long right = max;
		long answer = max;
		
		while(left<=right) {
			long mid = (left+right)/2;
			
			long num=0;
			for(int j : jewl) {
				if(j%mid==0) num +=j/mid;
				else num +=(j/mid) +1;
				
			}

			if(num<=N) {
				right = mid-1;
				answer = mid;
			}else {
				left = mid +1;
			}
			
		}
		
		System.out.println(answer);
	}
	


}
