import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1525 {
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String ans = "123456780";
		
		String start = "";
		
		for(int i=0 ; i<9 ; i++) {
			start += sc.next();
		}
		
		HashMap<String,Integer> map = new HashMap<>();
		
		map.put(start, 0);
		
		Queue<String> queue = new LinkedList<>();
		
		queue.add(start);
		
		int res = -1;
		
		out :
		while(!queue.isEmpty()) {
			String pos = queue.poll();
			
			if(pos.equals(ans)) {
				res = map.get(pos);
				break out;
			}
			
			int n = pos.indexOf("0");
			
			int r = n / 3;
			int c = n % 3;
			
			for(int d=0 ; d<4 ; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr<0 || nr>=3 || nc<0 || nc>=3) continue;
				
				int t = 3*nr + nc;
				char s = pos.charAt(t);
				
				String next = new String(pos);
				next = next.replace(s, 'e');
				next = next.replace('0', s);
				next = next.replace('e', '0');
				
				if(next.equals(ans)) {
					res = map.get(pos)+1;
					break out;
				}
				
				if(!map.containsKey(next)) {
					map.put(next, map.get(pos)+1);
					queue.add(next);
				}
			}
			
		}
		
		System.out.println(res);
	}
}
