import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] house;
    static int[][][] dp;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        house = new int[N][N];
        dp = new int[N][N][3]; // dp 배열 초기화
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = dfs(0, 1, 0);
        System.out.println(result);
    }

    static int dfs(int r, int c, int d) {
        if (r == N - 1 && c == N - 1) {
            return 1;
        }
        
        if (dp[r][c][d] != 0) return dp[r][c][d];
        
        int count = 0;

        // 가로 방향
        if (d == 0 || d == 1) {
            if (c + 1 < N && house[r][c + 1] == 0) {
                count += dfs(r, c + 1, 0);
            }
        }
        
        // 세로 방향
        if (d == 2 || d == 1) {
            if (r + 1 < N && house[r + 1][c] == 0) {
                count += dfs(r + 1, c, 2);
            }
        }
        
        // 대각선 방향
        if (r + 1 < N && c + 1 < N && house[r][c + 1] == 0 && house[r + 1][c] == 0 && house[r + 1][c + 1] == 0) {
            count += dfs(r + 1, c + 1, 1);
        }
        
        return dp[r][c][d] = count;
    }
}
