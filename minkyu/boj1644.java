import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		// 에라토스테네스의 체
		boolean[] isPrime = new boolean[num + 1];
        
        for(int i = 0; i < isPrime.length; i++)
            isPrime[i] = true;
        isPrime[0] = false; 
        isPrime[1] = false;
        
        for(int i = 2; i <= Math.sqrt(num); i++){ 
            if(isPrime[i]){ 
                for(int j = i*i; j<= num; j += i){
                    isPrime[j] = false;
                }
            }
        }
        
        // 구하고자 하는 수 아래에 있는 소수들의 모임
        List<Integer> primes = new ArrayList<>();
        for (int i = 0; i <= num; i++)
        	if (isPrime[i]) primes.add(i);
        
        // 경우의 수
        int cnt = 0;
        int N = primes.size();
        primes.add(0);
        
        int left = 0;
        int right = 0;
        int sum = 0;
        while(left <= N && right <= N) {
			if (sum == num) 
				cnt++;
            if(sum < num) 
            	sum += primes.get(right++);
            else 
            	sum -= primes.get(left++);
        }
        
        System.out.println(cnt);
	}
}