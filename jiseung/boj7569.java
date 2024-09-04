import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = { 0, 0, 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0, 0, 0 };
    static int[] dz = { 0, 0, 1, -1, 0, 0 };
    static int[][][] tomato;
    static int N, M, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomato = new int[H][M][N];
        for (int z = 0; z < H; z++) {
            for (int y = 0; y < M; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < N; x++) {
                    tomato[z][y][x] = Integer.parseInt(st.nextToken());
                }
            }
        }

        int result = bfs();
        System.out.println(result);
    }

    public static int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();

        // 큐에 초기 익은 토마토의 위치들을 추가
        for (int z = 0; z < H; z++) {
            for (int y = 0; y < M; y++) {
                for (int x = 0; x < N; x++) {
                    if (tomato[z][y][x] == 1) {
                        queue.offer(new int[] { x, y, z, 0 });
                    }
                }
            }
        }

        // 날짜
        int days = 0;

        // BFS 수행
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            days = Math.max(days, current[3]);

            for (int d = 0; d < 6; d++) {
                int nextX = current[0] + dx[d];
                int nextY = current[1] + dy[d];
                int nextZ = current[2] + dz[d];
                int nextdays = current[3]+1;
                // 범위 안쪽일때
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && nextZ >= 0 && nextZ < H) {
                    // 안익은 토마토가 있으면
                	if (tomato[nextZ][nextY][nextX] == 0) {
                        tomato[nextZ][nextY][nextX] = 1; // 익게 만듦
                        queue.offer(new int[] { nextX, nextY, nextZ, nextdays }); // 큐에 추가
                    }
                }
            }
        }

        // BFS가 끝난 후, 익지 않은 토마토가 있는지 확인
        for (int z = 0; z < H; z++) {
            for (int y = 0; y < M; y++) { 
                for (int x = 0; x < N; x++) {
                    if (tomato[z][y][x] == 0) {
                        return -1; // 아직 익지 않은 토마토가 있으면 -1 반환
                    }
                }
            }
        }

        return days; // 모든 토마토가 익는 데 걸린 최대 일수 반환
    }
}