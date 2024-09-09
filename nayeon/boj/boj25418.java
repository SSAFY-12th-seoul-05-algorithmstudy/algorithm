import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int K = sc.nextInt();
        
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[K + 1]; // 이미 방문한 숫자를 추적하기 위한 배열
        q.offer(new int[]{A, 0});
        visited[A] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int num = current[0];
            int count = current[1];

            if (num == K) {
                System.out.println(count);
                break;
            }

            if (num + 1 <= K && !visited[num + 1]) {
                visited[num + 1] = true;
                q.offer(new int[]{num + 1, count + 1});
            }

            if (num * 2 <= K && !visited[num * 2]) {
                visited[num * 2] = true;
                q.offer(new int[]{num * 2, count + 1});
            }
        }
    }
}

