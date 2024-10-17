import java.util.HashMap;
import java.util.Scanner;

public class boj1351 {
	
	static HashMap<Long, Long> hs;
	static Long N, P, Q;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		 N = sc.nextLong(); //찾아야하는 수
		 P = sc.nextLong(); //N/P
		 Q = sc.nextLong(); //N/Q
		
		hs = new HashMap<>();
		
		long result = find(N);
		
		System.out.println(result);
	}//main
	
	static long find(long n) {
		if(n==0) { //n이 0이면 값은 1
			
			return 1;
		}
		
		if(hs.containsKey(n)) { //해쉬맵에 N 가지고 있으면 
			return hs.get(n); //그 값가지고 옴
		}
		
		
		hs.put(n, find(n/P)+find(n/Q)); //재귀 돌리면서 해쉬맵에 저장
		
		return hs.get(n); //반환 
		
	}

}
