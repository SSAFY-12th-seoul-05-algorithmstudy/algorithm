import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int height;
	static int width;
	static int[][] map = {};
	static int islandCnt = 0;

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static List<int[]> bridges;
	
	static int[] p = {};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());

		map = new int[height][width];
		for (int i = 0; i < height; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < width; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		// 섬 정보 확인하면서 각 숫자별로 섬 분류
		checkIsland();

		bridges = new ArrayList<>();
		// 각 섬 개수 별로 각 섬에 연결할 수 있는 다리 길이 설정
		selectBridge();
		
		// 정렬
		Collections.sort(bridges, (o1,o2)->{
			return o1[2] - o2[2];
		});
		
		p = new int[islandCnt + 1];
		for (int i = 1; i <= islandCnt; i++)
			p[i] = i;
		
		int shortLength = 0;
		for (int i = 0; i < bridges.size(); i++) {
			int x = findSet(bridges.get(i)[0]);
			int y = findSet(bridges.get(i)[1]);
			if (x != y) {
				union(x,y);
				shortLength += bridges.get(i)[2];
			}
		}
		
		boolean isConnectable = true;
		if (islandCnt > 1) {
			int firstVal = findSet(1);
			for (int i = 2; i <= islandCnt; i++) {
				if (firstVal != findSet(i)) {
					isConnectable = false;
					break;
				}
			}
		}else
			isConnectable = false;
		
		if (isConnectable)
			System.out.println(shortLength);
		else
			System.out.println(-1);
	}
	
	public static void union(int x, int y) {
		p[y] = x;
	}
	
	public static int findSet(int x) {
		if (p[x] != x)
			p[x] = findSet(p[x]);
		return p[x];
	}

	public static void selectBridge() {
		// 섬 개수별로 각 섬들에 연결 될 수 있는 다리 개수 구하기
		for (int i = 1; i <= islandCnt; i++) {
			int[] bridgeLength = new int[islandCnt + 1];
			for (int j = 1; j <= islandCnt; j++) {
				bridgeLength[j] = Integer.MAX_VALUE;
			}

			for (int r = 0; r < height; r++) {
				for (int c = 0; c < width; c++) {
					if (i == map[r][c]) {
						// 4방 탐색
						for (int k = 0; k < 4; k++) {
							for (int l = 1; l < height + width; l++) {
								int curR = r + dr[k] * l;
								int curC = c + dc[k] * l;
								if (0 > curR || curR >= height || 0 > curC || curC >= width)
									break;
								
								if (map[curR][curC] != 0) {
									if (map[curR][curC] != i && l - 1 > 1) {
										if (bridgeLength[map[curR][curC]] > l - 1)
											bridgeLength[map[curR][curC]] = l - 1;
									}
									break;
								}
							}
						}
					}
				}
			}

			// 다리 정보 추가하기
			for (int j = 1; j <= islandCnt; j++) {
				if (bridgeLength[j] != Integer.MAX_VALUE)
					bridges.add(new int[] { i, j, bridgeLength[j] });
			}
		}
	}

	public static void checkIsland() {
		boolean[][] visited = new boolean[height][width];

		Queue<int[]> q = new ArrayDeque<>();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (!visited[i][j] && map[i][j] != 0) {
					islandCnt++;
					q.offer(new int[] { i, j });
					visited[i][j] = true;
					map[i][j] = islandCnt;
					while (!q.isEmpty()) {
						int[] tmp = q.poll();
						for (int k = 0; k < 4; k++) {
							int r = tmp[0] + dr[k];
							int c = tmp[1] + dc[k];
							if (0 <= r && r < height && 0 <= c && c < width && !visited[r][c] && map[r][c] != 0) {
								q.offer(new int[] { r, c });
								visited[r][c] = true;
								map[r][c] = islandCnt;
							}
						}
					}
				}
			}
		}
	}
}