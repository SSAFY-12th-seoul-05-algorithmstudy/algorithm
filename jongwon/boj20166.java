import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class boj20166 {

	static int[] dr = { 0,-1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { 0,-1, 0, 1, -1, 1, -1, 0, 1 };

	static Map<String, Set<Node>> hashMap;
	
	static int n, m;
	
	static char[][] matrix;
	
	static int startR , startC;
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int k = sc.nextInt();
		hashMap = new HashMap<>();
		matrix = new char[n][m];

		for (int i = 0; i < n; i++) {
			String s = sc.next();
			for (int j = 0; j < m; j++) {
				matrix[i][j] = s.charAt(j);
			}
		}

		for (int l = 0; l < k; l++) {
			String s = sc.next();
			if (hashMap.containsKey(s)) {
				System.out.println(hashMap.get(s).size());
				continue;
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(matrix[i][j] == s.charAt(0)) {						
						startR = i;
						startC = j;
						dfs(1, i, j, s, 0);
					}
				}
			}
			
			if (!hashMap.containsKey(s)) {
				System.out.println(0);
			} else {
				System.out.println(hashMap.get(s).size());
			}
		}
		sc.close();
	}
	
	// 굳이 만들필요없이 바로 들어가.
	static void dfs(int depth, int r, int c, String target, int hashNum) {
		
		if (depth == target.length()) {
			// 이정도 깊이까지 들어왔다면 성공
			Node newNode = new Node(startR, startC, hashNum);
			
//			\System.out.println("startR : " + startR + ", startC : " + startC + ", hashNum : " + hashNum);
			
			if (!hashMap.containsKey(target)) {
				hashMap.put(target, new HashSet<>());
				hashMap.get(target).add(newNode);
			} else {
				hashMap.get(target).add(newNode);
			}
			return;
		}

		
		// start안박고 시작했네 
		
		for (int d = 1; d <= 8; d++) {
			int newR = (r + dr[d] + n) % n;
			int newC = (c + dc[d] + m) % m;
			
			// shift시켜주고 시작해
			// 만약에 해당 순서랑 같으면 집어 넣고 다음 depth에 들어가
			
			if (matrix[newR][newC] == target.charAt(depth)) {
				dfs(depth + 1, newR, newC, target, hashNum + (int)(Math.pow(10, depth) * d));
			}
		}
	}
	
	static class Node {
		private int startR;
		private int startC;
		private int hashNum;
		public Node(int startR, int startC, int hashNum) {
			super();
			this.startR = startR;
			this.startC = startC;
			this.hashNum = hashNum;
		}
		@Override
		public String toString() {
			return "Node [startR=" + startR + ", startC=" + startC + ", hashNum=" + hashNum + "]";
		}
	}
}
