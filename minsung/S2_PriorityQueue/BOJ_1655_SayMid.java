import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_1655_SayMid {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        // 작은 수들의 최대힙
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // 큰 수들의 최소힙
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            
            // 두 힙의 크기가 같으면 maxHeap에 넣음
            if(maxHeap.size() == minHeap.size()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
            
            // maxHeap의 최대값이 minHeap의 최소값보다 크면 교환
            if(!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                int tmp = maxHeap.poll();
                maxHeap.add(minHeap.poll());
                minHeap.add(tmp);
            }
            
            sb.append(maxHeap.peek()).append('\n');
        }
        
        System.out.print(sb);
    }
}