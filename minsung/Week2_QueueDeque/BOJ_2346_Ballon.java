import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BOJ_2346_Ballon {
    static class Balloon {
        int number;
        int move;
        
        Balloon(int number, int move) {
            this.number = number;
            this.move = move;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Deque<Balloon> deque = new ArrayDeque<>();
        
        for (int i = 1; i <= N; i++) {
            int move = sc.nextInt();
            deque.add(new Balloon(i, move));
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (!deque.isEmpty()) {
            Balloon current = deque.pollFirst();
            sb.append(current.number).append(" ");
            
            if (deque.isEmpty()) break;
            
            if (current.move > 0) {
                for (int i = 0; i < current.move - 1; i++) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                for (int i = 0; i < Math.abs(current.move); i++) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }
        
        System.out.println(sb.toString().trim());
    }
}