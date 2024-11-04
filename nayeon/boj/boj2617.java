import java.util.Scanner;

public class Main {
    static int N, M;
    static boolean[][] heavy;
    static boolean[][] light;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 구슬 개수
        M = sc.nextInt(); // 비교 횟수

        heavy = new boolean[N + 1][N + 1]; // 무거운 구슬 관계
        light = new boolean[N + 1][N + 1]; // 가벼운 구슬 관계

        // 모든 관계 초기화 -> 자기 자신과의 관계는 제외 
        for (int i = 1; i <= N; i++) {
            heavy[i][i] = true; 
            light[i][i] = true;
        }

        // 입력된 구슬 비교 정보 처리
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt(); // 구슬 a
            int b = sc.nextInt(); // 구슬 b
            heavy[a][b] = true;  // a가 b보다 무겁다
            light[b][a] = true;  // b가 a보다 가볍다
        }

        // 모든 구슬 간의 관계 계산 -> 관계가 있으면 true, 없으면 false
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    heavy[i][j] = heavy[i][j] || (heavy[i][k] && heavy[k][j]);
                    light[i][j] = light[i][j] || (light[i][k] && light[k][j]);
                }
            }
        }

        int mid = (N + 1) / 2; // 중간 구슬의 기준
        int result = 0;

        // 각 구슬에 대해 무거운 구슬과 가벼운 구슬의 개수 확인
        for (int i = 1; i <= N; i++) {
            int heavyCount = 0;
            int lightCount = 0;

            // i번 구슬보다 무거운 구슬, 가벼운 구슬 개수 세기
            for (int j = 1; j <= N; j++) {
                if (heavy[i][j]) heavyCount++; // i번 구슬보다 무거운 구슬
                if (light[i][j]) lightCount++; // i번 구슬보다 가벼운 구슬
            }

            // 중간 순서보다 무겁거나 가벼운 구슬이 있으면 결과에 카운트
            if (heavyCount > mid || lightCount > mid) {
                result++;
            }
        }

        System.out.println(result);
    }
}
