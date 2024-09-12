import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] map;
	// 델타 우하좌상
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int num = 2; // num은 2부터
	// 간선을 저장할 배열
	static List<Edge> edges;
	// 대표를 저장할 배열
	static int[] p; 
	
	// 간선 클래스
	static class Edge implements Comparable<Edge> {
		int island1, island2, length;

		Edge(int island1, int island2, int length) {
			super();
			this.island1 = island1;
			this.island2 = island2;
			this.length = length;
		}

		@Override
		public int compareTo(Edge o) {
			return this.length - o.length;
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		// 지도정보 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 섬에 번호 부여
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					islandDFS(i, j); // 1로 된 섬 발견 시 DFS 실행
					num++; // 다음 섬을 위한 번호 증가
				}
			}
		}
		
		edges = new ArrayList<>();
		// 다리 내리면서 간선 배열에 추가
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] > 1) { // 섬 번호인 곳에서
					bridgeCheck(i, j, map[i][j]); // 다리 탐색
				}
			}
		}
		// 크루스칼 제1장 정렬
		Collections.sort(edges);

		// 크루스칼 제2장 V-1개의 간선을 뽑아라
		p = new int[num];

		// 반복문 하나를 통해 make set을 구현
		for (int i = 0; i < num; i++) {
			p[i] = i;
		}

		int ans = 0; // 최소비용
		int pick = 0; // 뽑은 간선의 개수
		
		// union을 하기전에 대표자를 내려보내기
		for (Edge E : edges) {
			int px = findSet(E.island1);
			int py = findSet(E.island2);

			// 사이클 발생하지않도록
			if (px != py) {
				union(px, py);
				ans += E.length;
				pick++;
			}
			// 다 뽑았으면 끝 2번부터 num-1까지 섬이 있고, 간선은 num-3개 존재한다.
			if (pick == (num - 3))
				break;
		}
		if (pick != num - 3) {
            System.out.println(-1); // 연결이 불가능한 경우
        } else {
            System.out.println(ans); // 최소비용 출력
        }
	}

	// row와 column값을 입력받음
	static void islandDFS(int r, int c) {
		// 섬을 돌며 섬에 번호를 매김
		map[r][c] = num; // 현재 좌표에 섬 번호를 매김

		for (int d = 0; d < 4; d++) {
			int nextr = r + dr[d];
			int nextc = c + dc[d];

			if (nextr >= 0 && nextr < N && nextc >= 0 && nextc < M && map[nextr][nextc] == 1) {
				islandDFS(nextr, nextc);
			}
		}
	}

	// row와 column 그리고 섬 번호를 입력받음.
	static void bridgeCheck(int r, int c, int islandnum) {
		for (int d = 0; d < 4; d++) {
			int nextr = r;
			int nextc = c;
			int length = 0;

			while (true) {
				nextr += dr[d];
				nextc += dc[d];
				// 해안선과 수직방향으로 다리를 내려, 범위안쪽 && 자기자신이 아닌지 확인
				if (nextr < 0 || nextr >= N || nextc < 0 || nextc >= M) {
					break;
				}
				if (map[nextr][nextc] == islandnum) {
					break;
				}
				// 다른섬에 도착하면 길이가 2 이상인지 확인하여 간선배열에 넣음
				if (map[nextr][nextc] > 1) {// 다른섬
					if (length > 1) {
						edges.add(new Edge(islandnum,map[nextr][nextc],length));
					}
					break;
				}
				length++;
			}
		}
	}
	static int findSet(int x) {
		if (x != p[x])
			p[x] = findSet(p[x]);
		return p[x];
	}

	static void union(int x, int y) {
        p[y] = x;
    }
}

// 1. DFS혹은 BFS를 돌며 섬에 번호를 부여
// 2. 각 섬에서 해안선에 수직한 방향으로 다리를 내려 섬과 만나는 지 확인, 그 섬의 번호로 간선 연결
// 3. 크루스칼 알고리즘을 통해 MST의 최소비용을 찾음.
// 4. 뽑은 간선의 갯수가 MST의 간선 개수가 아니면 -1출력, 같다면 최소비용 출력