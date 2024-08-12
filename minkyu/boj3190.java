import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 뱀의 이동 방향 미리 선언 우측으로 회전시 +1, 좌측으로 회전시 - 1 (모둘러 연산 이용)
		int[] dr = {0,1,0,-1};
		int[] dc = {1,0,-1,0};
		int dir = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 보드의 크기
		int n = Integer.parseInt(br.readLine());
		// 뱀으로 사용할 큐 선언
		Deque<position> snake = new ArrayDeque<>();
		// 뱀의 초기 위치 선언
		snake.offer(new position(1,1));
		//사과의 개수 받아오기
		int appleCnt = Integer.parseInt(br.readLine());
		List<position> applePositions = new ArrayList<>();
		// 사과 위치 지정
		for (int i = 0; i < appleCnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			applePositions.add(new position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		// 방향을 변환하는 횟수를 확인한다.
		int actionCnt = Integer.parseInt(br.readLine());
		Map<Integer, String> actions = new HashMap<>();
		
		for (int i = 0; i < actionCnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			actions.put(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		
		int time = 0;
		main : while(true) {
			if (actions.containsKey(time)) {
				if (actions.get(time).equals("D"))
					dir = (dir + 1) % 4;
				else
					dir = (dir - 1 + 4) % 4;
			}
			
			position firstPos = snake.peekFirst().deepCopy();
			firstPos.add(dr[dir], dc[dir]);
			
			time++;
			
			if (firstPos.isOutOfBound(n))
				break main;
			
			boolean isEatApple = false;
			for (int k = 0; k < applePositions.size(); k++) {
				if (applePositions.get(k).isEqual(firstPos)) {
					isEatApple = true;
					applePositions.remove(k);
					break;
				}
			}
			
			// 뱀과의 충돌 확인
			int snakeSize = snake.size();
			int lastR = 0;
			int lastC = 0;
			for (int k = 0; k < snakeSize; k++) {
				position curPart = snake.pollFirst();
				// 자기 자신과 충돌한 경우
				if (firstPos.isEqual(curPart))
					break main;
				
				if (k == 0)
					snake.offerLast(new position(curPart.r + dr[dir], curPart.c + dc[dir]));
				else
					snake.offerLast(new position(lastR, lastC));
				
				lastR = curPart.r;
				lastC = curPart.c;
			}
			
			//사과 먹은 경우 길이 늘리기
			if (isEatApple)
				snake.offerLast(snake.peekLast().deepCopy().add(-dr[dir], -dc[dir]).deepCopy());
		}
		
		System.out.println(time);
	}
}

class position{
	int r;
	int c;
	position(int r, int c){
		this.r = r;
		this.c = c;
	}
	
	public boolean isEqual(position comparer) {
		return (comparer.r == this.r && comparer.c == this.c);
	}
	
	public position add(int rVal, int cVal) {
		this.r += rVal;
		this.c += cVal;
		return this;
	}
	
	public boolean isOutOfBound(int size) {
		if (r > 0 && r <= size && c > 0 && c <= size)
			return false;
		else
			return true;
	}
	
	public position deepCopy() {
		return new position(this.r, this.c);
	}
}