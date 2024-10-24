import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); 

        // 최대 힙: 작은 값들을 계속 넣으면서 가장 큰 값 체크하기 위한 부분
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        // 최소 힙: 큰 값들을 계속 넣으면서 가장 작은 값 체크하기 위한 부분
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            
            // 최대 힙에 먼저 추가
            maxHeap.offer(num);

            // 최대 힙 내 최댓값이 최소 힙의 최솟값보다 크면 교환
            if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                minHeap.offer(maxHeap.poll());
            }

            // 힙 크기 조정: 최대 힙의 크기가 최소 힙보다 2 이상 커지면 균형을 다시 맞춰주기
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }

            // 현재 중간값 출력
            System.out.println(maxHeap.peek());
        } // for문 
        
    } // main 
} // class 
