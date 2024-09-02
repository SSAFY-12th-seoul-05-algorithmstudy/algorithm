import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int targetNum;
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int curNum = sc.nextInt();
		int targetNum = sc.nextInt();
		// 숫자와 해당 숫자까지 가는 가장 빠른 횟수 저장
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[] visitCheck = new boolean[targetNum + 1];
		// 시작지점 위치 추가
		queue.add(new int[] {curNum,0});
		// 시작지점 방문 기록
		visitCheck[curNum] = true;
		// 더 이상 방문하지 못하는 곳이 없을때까지 계속 반복
		while (!queue.isEmpty()) {
			int[] curInfo = queue.poll();
			int curno = curInfo[0];
			int curShortWay = curInfo[1];
			// 현재 도달하고자 하는 번호에 도달한 경우엔 최단 거리 기록
			if (curno == targetNum) {
				System.out.println(curShortWay);
				return;
			}
			// 현재 숫자에서 2배를 한 경우 먼저 기록(타겟 번호보다 작거나 같은경우만)
			if (curno * 2 <= targetNum) {
				visitCheck[curno * 2] = true;
				queue.add(new int[]{curno * 2, curShortWay + 1});
			}
			// 전에 빠르게 방문한 적이 없는 경우
			if (!visitCheck[curno + 1])
				queue.add(new int[] {curno + 1, curShortWay + 1});
		}
	}
	

}