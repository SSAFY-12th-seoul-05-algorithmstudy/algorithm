import java.util.*;
import java.io.*;

public class Main {
	public static int[] tree = new int[10000];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int idx = 0;
		String line;
		while((line = br.readLine()) != null) {
			tree[idx++] = Integer.parseInt(line);
		}
		postOrder(0,idx);
	}
	
	static void postOrder(int start, int end) {
		int idx;
		if (start>=end) return;
		
		for (idx = start + 1; idx < end; idx++) {
			if (tree[start] < tree[idx]) break;
		}
		postOrder(start+1, idx);
		postOrder(idx, end);
		System.out.println(tree[start]);
		return;
	}
}