import java.io.*;
import java.util.*;

public class Main {
	static Map<Long, Long> map = new HashMap<>();
	static long N;
	static long P;
	static long Q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		map.put(0L, 1L);
		
		N = Long.parseLong(st.nextToken());
		P = Long.parseLong(st.nextToken());
		Q = Long.parseLong(st.nextToken());
		
		System.out.println(getResult(N));
	}
	
	public static long getResult(long target) {
		if (map.containsKey(target))
			return map.get(target);
		else {
			map.put(target, getResult(target / P) + getResult(target / Q));
			return map.get(target);
		}
	}
}