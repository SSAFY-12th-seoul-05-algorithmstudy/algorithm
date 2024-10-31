import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_20166_HoSuk {

    static HashMap<String, Integer> map = new HashMap<>();
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static int n, m;
    static char[][] land;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        land = new char[n][m];

        for (int i = 0; i < n; i++) {
            land[i] = br.readLine().toCharArray();
        }

        //모든 곳에서 시작
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j, 1, land[i][j] + "");
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < k; i++) {
            String s = br.readLine();
            sb.append(map.getOrDefault(s, 0)).append("\n");
        }

        System.out.print(sb);
    }

    private static void dfs(int x, int y, int len, String now) {
    	
    	
    	//getOrDefault 쩌네
        map.put(now, map.getOrDefault(now, 0) + 1);

        if (len == 5) {
            return;
        }

        for (int i = 0; i < 8; i++) {
            int nx = (x + dx[i] + n) % n;
            int ny = (y + dy[i] + m) % m;

            dfs(nx, ny, len + 1, now + land[nx][ny]);
        }
    }
}