import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 2178_미로탐색
public class Main {
    // 미로를 저장할 배열
    static int[][] arr;
    // 방문 여부 및 이동 횟수를 저장할 배열
    static int[][] check;
    // 방향 배열
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    // 미로의 크기
    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][M];
        check = new int[N][M];
        
        // 미로 입력 받기
        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }
        
        System.out.println(bfs(0, 0));
    }
    
    public static int bfs(int x, int y) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x, y});
        
        check[x][y] = 1;
        
        while (!que.isEmpty()) {
            int[] current = que.poll();
            int cx = current[0];
            int cy = current[1];
            
            // 목적지 도달
            if (cx == N - 1 && cy == M - 1) break;
            
            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                // 미로 범위 내에 있는지 확인
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    // 길이고 방문하지 않은 곳이라면
                    if (arr[nx][ny] == 1 && check[nx][ny] == 0) {
                        check[nx][ny] = check[cx][cy] + 1;
                        que.add(new int[]{nx, ny});
                    }
                }
            }
        }
        
        return check[N-1][M-1];
    }
}
