import java.io.*;
import java.util.*;

public class Main {
	static HashMap<Long, Long> map;
	static long P,Q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		P = Long.parseLong(st.nextToken());
		Q = Long.parseLong(st.nextToken());
		
		map = new HashMap<>();
		
		map.put(0L,1L);
		
		System.out.println(solve(N));
		
	}
	public static long solve(long n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        long left = solve(n / P);
        long right = solve(n / Q);
        map.put(n, left + right);
        return map.get(n);
    }
}