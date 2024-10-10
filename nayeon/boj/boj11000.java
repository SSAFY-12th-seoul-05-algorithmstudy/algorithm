import java.util.*;

// boj11000_강의실배정
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        // 시작, 종료 시간 저장
        int[][] arr = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt(); // 시작 시간
            arr[i][1] = sc.nextInt(); // 종료 시간
        }
        
        // 1. 시작 시간 기준 정렬 (시작 시간이 같으면 종료 시간 기준 정렬)
        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1]; // 시작 시간이 같으면 종료 시간 오름차순
            }
            return a[0] - b[0]; // 시작 시간 오름차순
        });

        // 2. 우선순위 큐 생성 -> 종료 시간이 작은 것부터 처리
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // 첫 번째 강의의 종료 시간을 큐에 추가 
        pq.offer(arr[0][1]);
        
        // 3. 나머지 강의들 처리
        for (int i = 1; i < N; i++) {
            // 강의실을 비울 수 있는지 확인
            // 현재 강의의 시작 시간이 가장 빠르게 종료되는 강의의 종료 시간보다 크거나 같으면
            if (pq.peek() <= arr[i][0]) {
                pq.poll(); // 강의실 비우기
            }
            // 새로운 종료 시간 넣기 
            pq.offer(arr[i][1]);
        }
        
        // 최종 큐에 남아있는 강의실 개수 = 최소로 필요한 강의실 수
        System.out.println(pq.size());
    }
}
