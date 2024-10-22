import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 보석 개수
        int K = sc.nextInt(); // 가방 개수
        long sum = 0; // 총합

        // 보석 정보를 저장할 배열 (무게, 가격)
        int[][] jewels = new int[N][2];
        for (int i = 0; i < N; i++) {
            jewels[i][0] = sc.nextInt(); // 보석 무게
            jewels[i][1] = sc.nextInt(); // 보석 가격
        }

        // 가방 정보를 저장할 배열
        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = sc.nextInt(); // 가방의 최대 무게
        }

        // 보석을 무게 기준 오름차순 정렬
        Arrays.sort(jewels, Comparator.comparingInt(o -> o[0]));

        // 가방을 무게 기준 오름차순 정렬
        Arrays.sort(bags);

        // 가방에 담을 수 있는 보석들을 저장할 우선순위 큐 (가격이 높은 순)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int jewelIdx = 0;
        for (int i = 0; i < K; i++) {
            int currentBag = bags[i]; // 현재 가방

            // 현재 가방에 담을 수 있는 보석들을 우선순위 큐에 추가
            while (jewelIdx < N && jewels[jewelIdx][0] <= currentBag) {
                pq.add(jewels[jewelIdx][1]); // 보석의 가격 추가
                jewelIdx++;
            }

            // 담을 수 있는 보석 중 가장 비싼 것을 선택
            if (!pq.isEmpty()) {
                sum += pq.poll();
            }
        }

        // 최종 결과 출력
        System.out.println(sum);
    }
}
