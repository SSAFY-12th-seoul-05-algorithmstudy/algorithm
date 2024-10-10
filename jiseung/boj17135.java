import java.io.*;
import java.util.*;

public class Main {
	static int N, M, D;
	static int[] selected = new int[3];
	static int[][] map;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		comb(0, 0);
		System.out.println(result);
	}

	// 궁수 배치
	static void comb(int idx, int count) {
		// 배치가 다되면 시작
		if (count == 3) {
			start();
			return;
		}

		for (int i = idx; i < M; i++) {
			selected[count] = i;
			comb(i + 1, count + 1);
		}
	}

	// 게임 진행
	static void start() {
		int[][] tempMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			System.arraycopy(map[i], 0, tempMap[i], 0, M);
		}
		int killed = 0; // 점수
		int count = N+1; // 이동횟수
		while (count != 0) {
			killed += attack(tempMap);
			move(tempMap);
			count--;
		}
		// 결과
		result = Math.max(result, killed);
	}

	// 궁수 공격
	static int attack(int[][] tempMap) {
		List<int[]> targets = new ArrayList<>(); 
		// 각 궁수의 공격 대상 선택
		for (int archer : selected) {
			int[] target = findEnemy(tempMap, archer); // 가장 가까운 적 찾기
			if (target != null) {
				targets.add(target);
			}
		}
		// 중복된 적은 한 번만 제거
		int killed = 0;
        for (int[] target : targets) {
            int x = target[0], y = target[1];
            if (tempMap[x][y] == 1) {
                tempMap[x][y] = 0;
                killed++;
            }
        }
		return killed; // 제거된 적의 수 반환

	}

	// 궁수의 사정거리 내에서 가장 가까운 적을 찾는 함수
	static int[] findEnemy(int[][] tempMap, int archer) {
		int[] target = null;
		int range = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 적과 궁수의 거리계산
				if (tempMap[i][j] == 1) {
					int dist = Math.abs(N - i) + Math.abs(archer - j);

					// 적이 사거리 안에 있을경우
					if (dist <= D) {
						// 더 가까운적 또는 더 왼쪽에 있는 적 선택
						if (dist < range || (dist == range && j < target[1])) {
							range = dist; // 거리 갱신
							target = new int[] { i, j };
						}
					}
				}
			}
		}
		return target;
	}

	// 적들 이동
	static void move(int[][] tempMap) {
	    // 맨 윗줄을 비우고 나머지 줄을 아래로 이동
	    for (int i = N - 1; i > 0; i--) {
	        tempMap[i] = Arrays.copyOf(tempMap[i - 1], M); // 한 줄씩 아래로 이동
	    }
	    Arrays.fill(tempMap[0], 0); // 맨 윗줄은 적이 없음
	}
}