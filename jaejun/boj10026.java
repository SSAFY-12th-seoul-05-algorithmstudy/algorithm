package boj;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class boj10026 {
    static char[][] map;
    static int N, num, numC;
    static boolean[][] check;
    static boolean[][] colorCheck;
    static int[] dr = { 1, 0, -1, 0 };
    static int[] dc = { 0, -1, 0, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new char[N][N];

        for (int r = 0; r < N; r++) {
            String str = sc.next();
            for (int c = 0; c < N; c++) {
                map[r][c] = str.charAt(c);
            }
        }

        check = new boolean[N][N];
        colorCheck = new boolean[N][N];

        bfs(0, 0);
        colorbfs(0, 0);
        
        System.out.println(num + " " + numC);
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!check[i][j]) {
                    num++;
                    check[i][j] = true;
                    q.offer(new int[] { i, j });

                    while (!q.isEmpty()) {
                        int[] now = q.poll();
                        int nx = now[0];
                        int ny = now[1];

                        for (int k = 0; k < 4; k++) {
                            int ox = nx + dr[k];
                            int oy = ny + dc[k];

                            if (ox >= 0 && oy >= 0 && ox < N && oy < N) {
                                if (!check[ox][oy] && map[ox][oy] == map[nx][ny]) {
                                    check[ox][oy] = true;
                                    q.add(new int[] { ox, oy });
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    static void colorbfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!colorCheck[i][j]) {
                    numC++;
                    colorCheck[i][j] = true;
                    q.offer(new int[] { i, j });

                    while (!q.isEmpty()) {
                        int[] now = q.poll();
                        int nx = now[0];
                        int ny = now[1];

                        char color = map[nx][ny];

                        for (int k = 0; k < 4; k++) {
                            int ox = nx + dr[k];
                            int oy = ny + dc[k];

                            if (ox >= 0 && oy >= 0 && ox < N && oy < N) {
                                if (!colorCheck[ox][oy] && (color == 'R' || color == 'G')) {
                                    if (map[ox][oy] == 'R' || map[ox][oy] == 'G') {
                                        colorCheck[ox][oy] = true;
                                        q.add(new int[] { ox, oy });
                                    }
                                } else if (!colorCheck[ox][oy] && map[ox][oy] == 'B') {
                                    colorCheck[ox][oy] = true;
                                    q.add(new int[] { ox, oy });
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
