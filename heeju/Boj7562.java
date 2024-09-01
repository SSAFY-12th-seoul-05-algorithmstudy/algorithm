import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7562 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
		StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            // 1. 입력 및 초기화
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()); // 출발 위치
            int c = Integer.parseInt(st.nextToken());

            boolean[][] visited = new boolean[n][n]; // 방문한적 있는지 확인
            visited[r][c] = true;

            st = new StringTokenizer(br.readLine());
            int nr = Integer.parseInt(st.nextToken()); // 도착 위치
            int nc = Integer.parseInt(st.nextToken());

            // 2. 로직
            Queue<Knight> que = new ArrayDeque<>();
            que.offer(new Knight(r, c, 0));

            int[][] directions = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1},
                                  {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};

            Knight knight;
            int ans = 0;
            int cr;
            int cc;
            
            out : while (!que.isEmpty()) {
                knight = que.poll();
                if (knight.r == nr && knight.c == nc) {
                    ans = knight.count;
                    break;
                }
                for (int[] d : directions) {
                    cr = knight.r + d[0];
                    cc = knight.c + d[1];
                    if (cr == nr && cc == nc) { // 목적 위치에 도착했을 때
                        ans = knight.count + 1;
                        break out;
                    }
                    if (!isValid(cr, cc, n) || visited[cr][cc]) { // 말이 범위를 벗어났거나, 이미 방문했을 때
                        continue;
                    }
                    visited[cr][cc] = true;
                    que.offer(new Knight(cr, cc, knight.count + 1));
                }
            }

            // 3. 출력
            sb.append(ans).append("\n");
        }
        
		bw.write(sb.toString());

		br.close();
		bw.close();
	}

    static boolean isValid(int r, int c, int n) {
        return 0 <= r && r < n && 0 <= c && c < n;
    }
}

class Knight {

    int r;
    int c;
    int count;
    
    public Knight(int r, int c, int count) {
        this.r = r;
        this.c = c;
        this.count = count;
    }
}
