import java.util.Scanner;

//가운데 공백 치환, 투사이드에서 다시 반복 => 재귀
// 기저조건 : 3으로 계속 나눠서 길이 1
public class boj4779 {
	static char[] cantor;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			int n = sc.nextInt(); // 0이상 12이하
			
			int len = (int)Math.pow(3, n);
			cantor = new char[len];
			for(int i = 0; i < len; i++) {
				cantor[i] = '-';
			}
			
			func(0, len);
			System.out.println(cantor);
		}
		
	}
	
	static void func(int s, int e) {
		if(e - s == 1) return;
		
		// 가운데 공백 치환
		int len = (e-s)/3;
		for(int i = s+len; i < e-len; i++) {
			cantor[i] = ' '; 
		}
		
		func(s, s+len);
		func(e-len, e);
	}

}
