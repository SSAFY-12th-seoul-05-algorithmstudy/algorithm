
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static List<EnemyInfo> enemyPositions = new ArrayList<>();
	static int rowCnt;
	static int colCnt;
	static int archerRange;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		rowCnt = Integer.parseInt(st.nextToken());
		colCnt = Integer.parseInt(st.nextToken());
		archerRange = Integer.parseInt(st.nextToken());
		
		// 적의 초기 위치 구하기
		int enemyNo = 1;
		for (int i = 0; i < rowCnt; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < colCnt; j++) {
				if (Integer.parseInt(st.nextToken()) == 1)
					enemyPositions.add(new EnemyInfo(enemyNo++, new int[] {i,j}));
			}
		}
		
		int maxKillCnt = 0;
		// 궁수가 서 있을 수 있는 모든 위치 검사
		for (int i = 0; i < colCnt - 2; i++) {
			for (int j = i + 1; j < colCnt - 1; j++) {
				for (int k = j + 1; k < colCnt; k++) {
					// 각 위치별로 궁수가 존재하는 곳에서 검사할 것
					int killCnt = getKillCnt(i,j,k);
					if (maxKillCnt < killCnt)
						maxKillCnt = killCnt;
				}
			}
		}
		System.out.println(maxKillCnt);
	}
	
	public static int getDist(int[] pos1, int[] pos2) {
		return Math.abs(pos2[0] - pos1[0]) + Math.abs(pos2[1] - pos1[1]);
	}
	
	public static int getKillCnt(int archer1, int archer2, int archer3) {
		int killCnt = 0;
		List<EnemyInfo> tmpEnemyPositions = new ArrayList<>(enemyPositions);
		while(tmpEnemyPositions.size() > 0) {
			Set<Integer> killedEnemyIdx = new HashSet<>();
			// 1번 궁수가 죽이는 경우
			boolean isKilled = false;
			int closeDist = rowCnt + colCnt;
			int enemyCol = colCnt;
			int enemyNo = 0;
			for (int i = 0; i < tmpEnemyPositions.size(); i++) {
				int curDist = getDist(tmpEnemyPositions.get(i).pos, new int[] {rowCnt, archer1});
				if (curDist <= archerRange ) {
					if ((closeDist > curDist) || (closeDist == curDist && enemyCol >= tmpEnemyPositions.get(i).pos[1])) {
						closeDist = curDist;
						enemyCol = tmpEnemyPositions.get(i).pos[1];
						isKilled = true;
						enemyNo = tmpEnemyPositions.get(i).no;
					}
				}
			}
			if (isKilled)
				killedEnemyIdx.add(enemyNo);
			
			isKilled = false;
			closeDist = rowCnt + colCnt;
			enemyCol = colCnt;
			for (int i = 0; i < tmpEnemyPositions.size(); i++) {
				int curDist = getDist(tmpEnemyPositions.get(i).pos, new int[] {rowCnt, archer2});
				if (curDist <= archerRange ) {
					if ((closeDist > curDist) || (closeDist == curDist && enemyCol >= tmpEnemyPositions.get(i).pos[1])) {
						closeDist = curDist;
						enemyCol = tmpEnemyPositions.get(i).pos[1];
						isKilled = true;
						enemyNo = tmpEnemyPositions.get(i).no;
					}
				}
			}
			if (isKilled)
				killedEnemyIdx.add(enemyNo);
			
			isKilled = false;
			closeDist = rowCnt + colCnt;
			enemyCol = colCnt;
			for (int i = 0; i < tmpEnemyPositions.size(); i++) {
				int curDist = getDist(tmpEnemyPositions.get(i).pos, new int[] {rowCnt, archer3});
				if (curDist <= archerRange ) {
					if ((closeDist > curDist) || (closeDist == curDist && enemyCol >= tmpEnemyPositions.get(i).pos[1])) {
						closeDist = curDist;
						enemyCol = tmpEnemyPositions.get(i).pos[1];
						isKilled = true;
						enemyNo = tmpEnemyPositions.get(i).no;
					}
				}
			}
			if (isKilled)
				killedEnemyIdx.add(enemyNo);
			
			killCnt += killedEnemyIdx.size();
			
			// 경기장 벗어나는 적들 삭제
			for (int i = 0; i < tmpEnemyPositions.size(); i++) {
				if (tmpEnemyPositions.get(i).pos[0] + 1 == rowCnt)
					killedEnemyIdx.add(tmpEnemyPositions.get(i).no);
			}
			
			// 죽거나 벗어난 적들 삭제
			for (int enNo : killedEnemyIdx) {
				for (int i = 0; i < tmpEnemyPositions.size(); i++) {
					if (tmpEnemyPositions.get(i).no == enNo) {
						tmpEnemyPositions.remove(i);
						break;
					}
				}
			}
			
			// 죽지 않은 적들 위치 이동
			for (int i = 0; i < tmpEnemyPositions.size(); i++) {
				EnemyInfo curInfo = tmpEnemyPositions.get(i);
				EnemyInfo newInfo = new EnemyInfo(curInfo.no, new int[] {curInfo.pos[0] + 1, curInfo.pos[1]});
				tmpEnemyPositions.set(i, newInfo);
			}
		}
		
		return killCnt;
	}
}

class EnemyInfo{
	int no;
	int[] pos;
	EnemyInfo(int no, int[] pos){
		this.no = no;
		this.pos = pos;
	}
}