import java.io.*;
import java.util.*;

public class Main {
	static class Robot {
		int r,c,dir;
		Robot(int r, int c, int dir){
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
	
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int count=0;
	static boolean[][] cleaned;
	static Robot robot;
	static int N,M;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		cleaned = new boolean[N][M];
		st = new StringTokenizer(br.readLine());
		
		robot = new Robot(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(true) {
			if(!clean()) {
				break;
			}
		}
		System.out.println(count);
	}
	
	static boolean clean() {
		// 청소 안됐으면 청소
		if(!cleaned[robot.r][robot.c]) {
			cleaned[robot.r][robot.c]=true;
			count++;
		}
		// 반시계로 회전하며 벽이아니고 청소안된곳으로 이동
		for(int i=1;i<=4;i++) {
			int nextdir = (robot.dir-i+4)%4;
			int nextr = robot.r + dr[nextdir];
			int nextc = robot.c + dc[nextdir];
			if(nextr >=0 && nextr <N && nextc >=0 && nextc <M && map[nextr][nextc]!=1 && !cleaned[nextr][nextc]) {
				robot.r = nextr;
				robot.c = nextc;
				robot.dir = nextdir;
				return true;
			}
		}
		
		// 여기까지왔으면 주변 4칸 청소 안된거니까
		int nextdir = (robot.dir+2)%4;
		int nextr = robot.r + dr[nextdir];
		int nextc = robot.c + dc[nextdir];
		// 후진할 수 있으면
		if (nextr >=0 && nextr <N && nextc >=0 && nextc <M && map[nextr][nextc]!=1) {
			robot.r = nextr;
			robot.c = nextc;
			return true;
		}
		return false;
	}
	
}