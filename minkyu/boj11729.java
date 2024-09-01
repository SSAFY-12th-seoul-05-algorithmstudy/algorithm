import java.util.Scanner;

public class boj11729 {
	static int towerCnt = 0;
	static int moveCnt = 0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		towerCnt = sc.nextInt();
		moveHanoi(towerCnt, 2, 1, 3);
		System.out.println(moveCnt);
		System.out.println(sb);
	}
	
	public static void moveHanoi(int leftCnt, int leftPos, int curPos, int tarPos) {
		if (leftCnt == 0)
			return;
		moveHanoi(leftCnt - 1, tarPos, curPos, leftPos);
		sb.append(curPos).append(" ").append(tarPos).append("\n");
		moveCnt++;
		moveHanoi(leftCnt - 1, curPos, leftPos, tarPos);
	}
}
