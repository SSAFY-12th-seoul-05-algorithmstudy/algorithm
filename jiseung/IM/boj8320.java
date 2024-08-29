import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 정사각형 갯수
		System.out.print(rectangle(N));

	}

	static int rectangle(int N) {
		if (N == 1) {
			return 1;
		} else {
			return rectangle(N - 1) + (int)Math.ceil((double)factorization(N)/2);
		}
	}

	static int factorization(int N) {
	    if (N == 1) {
	        return 1;
	    } else {
	        int count = 1;
	        int i = 2;
	        int result = 1;
	        while (i * i <= N) { // i^2 <= N 까지 반복
	            count = 1;
	            while (N % i == 0) { // i가 N의 약수일 때까지 반복
	                N /= i;
	                count++;
	            }
	            result *= count; // (a1 + 1)을 곱해줌
	            i++;
	        }
	        // N이 소수로 남아 있는 경우 처리
	        if (N > 1) {
	            result *= 2; // 소수이므로 (1 + 1)을 곱해줌
	        }
	        return result;
	    }
	}
}