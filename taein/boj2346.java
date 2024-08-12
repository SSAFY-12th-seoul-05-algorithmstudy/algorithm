import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj2346 {

    public static void main(String[] args) throws IOException {

<<<<<<< HEAD
        // 콘솔로부터 입력을 읽기 위해 BufferedReader를 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 효율적으로 출력 문자열을 만들기 위해 StringBuilder 사용
        StringBuilder sb = new StringBuilder();

        // 요소의 개수를 읽음
        int num = Integer.parseInt(br.readLine());

        // 위치와 각 위치의 이동 값을 저장할 덱을 초기화
        Deque<int[]> list = new ArrayDeque<>();
        // 입력된 한 줄을 파싱하기 위해 StringTokenizer 사용
=======
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        Deque<int[]> list = new ArrayDeque<>();
>>>>>>> f4661210b1e540768f0f169f939d106cf5b5e1eb
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 첫 번째 위치를 출력에 추가
        sb.append("1 ");
        // 첫 번째 요소의 이동 값을 읽음
        int move = Integer.parseInt(st.nextToken());

        // 남은 위치와 이동 값을 덱에 추가
        for (int i = 2; i <= num ; i++) {
            list.add(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        // 덱이 비어있지 않은 동안 반복
        while (!list.isEmpty()) {
            if (move > 0) { // 이동 값이 양수일 경우

                // 이동 값만큼 덱의 앞에서 뒤로 이동
                for (int x = 1; x < move; x++) {
                    list.add(list.pollFirst());
                }

                // 다음 위치를 덱에서 제거하고 이동 값을 업데이트
                int[] next = list.removeFirst();
                move = next[1];
                sb.append(next[0]).append(" ");
            } else { // 이동 값이 음수일 경우

                // 이동 값만큼 덱의 뒤에서 앞으로 이동
                for (int x = move; x < -1; x++) {
                    list.addFirst(list.pollLast());
                }

                // 다음 위치를 덱에서 제거하고 이동 값을 업데이트
                int[] next = list.removeLast();
                move = next[1];
                sb.append(next[0]).append(" ");
            }
        }

<<<<<<< HEAD
        // 최종 출력 문자열을 콘솔에 출력
=======
>>>>>>> f4661210b1e540768f0f169f939d106cf5b5e1eb
        System.out.println(sb);
    }
}
