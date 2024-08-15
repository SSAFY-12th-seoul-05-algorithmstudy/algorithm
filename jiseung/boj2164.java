import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); // 카드 수
        Queue<Integer> queue = new LinkedList<>();
        
        // 큐에 1부터 N까지 넣음
        for (int i=1; i<=N; i++) {
        	queue.add(i);
        }
        
        // 카드꺼내고 뒤로보내는 작업을 N-1번 반복해서 1장만 남게함
        for (int i=1; i<N; i++) {
        	queue.poll();
        	queue.add(queue.poll());
        }
        
        // 남은 1장 확인
        System.out.println(queue.peek());
    }
}
