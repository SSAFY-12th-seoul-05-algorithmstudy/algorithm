import java.util.*;

// boj1744_수 묶기
public class Main {
    static int N; 
    // 양수와 음수를 각각 저장할 우선순위 큐
    static PriorityQueue<Integer> plusQ = new PriorityQueue<>(Comparator.reverseOrder()); // 양수 : 내림차순
    static PriorityQueue<Integer> minusQ = new PriorityQueue<>(); // 음수 : 오름차순 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); 

        // 양수와 음수로 나누어 저장
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt(); 
            if (num <= 0) {
                // 음수 또는 0인 경우 -> minusQ 큐 추가
                minusQ.add(num);
            } else {
                // 양수인 경우 -> plusQ 큐 추가
                plusQ.add(num);
            }
        }

        int answer = 0; // 초기화

        // 음수 처리 -> 최대값 구하기
        while (!minusQ.isEmpty()) {
            int cur = minusQ.poll(); // 가장 작은 음수
            if (minusQ.isEmpty()) {  // 마지막 음수가 남은 경우
                answer += cur; // 남은 음수는 그냥 더하기 
                break; 
            }
            // 다음 값이 0일 때
            if (minusQ.peek() == 0) {
                // 0은 음수와 곱하면 0이 되므로 제거
                minusQ.poll();
            } else {
                // 두 음수를 곱하여 더하기 (작은 수끼리 묶어서 곱함)
                answer += cur * minusQ.poll();
            }
        }

        // 양수 처리 -> 최대값 구하기
        while (!plusQ.isEmpty()) {
            int cur = plusQ.poll(); // 가장 큰 양수를 꺼내기 
            if (plusQ.isEmpty()) { // 마지막 양수가 남은 경우
                answer += cur; // 남은 양수는 그냥 더하기 
                break; 
            }
            // 1일 때
            if (cur == 1) {
                answer += 1; // 1은 무조건 더하기 -> 곱하기보다 더하는 것이 더 이득 ! 
            } else if (plusQ.peek() == 1) {
                // 다음 묶을 쌍이 1일 때
                answer += cur + plusQ.poll(); // 곱하지 않고 더하기 
            } else {
                // 큰 수들끼리 묶어서 곱하기 
                answer += cur * plusQ.poll();
            }
        }

        System.out.println(answer); // 결과 출력
    } // main 
} // class
