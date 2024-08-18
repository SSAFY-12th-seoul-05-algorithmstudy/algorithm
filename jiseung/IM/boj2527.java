import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 4;
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st1.nextToken());
            int y1 = Integer.parseInt(st1.nextToken());
            int x2 = Integer.parseInt(st1.nextToken());
            int y2 = Integer.parseInt(st1.nextToken());
            int p1 = Integer.parseInt(st1.nextToken());
            int q1 = Integer.parseInt(st1.nextToken());
            int p2 = Integer.parseInt(st1.nextToken());
            int q2 = Integer.parseInt(st1.nextToken());

            if (x2 < p1 || y2 < q1 || p2 < x1 || q2 < y1) { // 아예 범위 밖
                System.out.println("d");
            } 
            else if ((x2 == p1 && y2 == q1) || (x1 == p2 && y2 == q1) || (x1 == p2 && y1 == q2) || (x2 == p1 && y1 == q2)) {
                System.out.println("c");
            } 
            else if (x2 == p1 || x1 == p2 || y2 == q1 || y1 == q2) {
                System.out.println("b");
            } 
            else {
                System.out.println("a");
            }
        }
    }
}