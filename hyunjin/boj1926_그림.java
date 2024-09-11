package BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// BOJ1926_그림
public class boj1926_그림 {
	static int N, M;
	static boolean[][] isChecked; // 탐색
	static int[] dr = new int[] { -1, 1, 0, 0 };
	static int[] dc = new int[] { 0, 0, -1, 1 };
	static List<Integer> pictureSizeList = new ArrayList<>(); // 그림 크기를 저장할 리스트

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		 N = sc.nextInt();
		 M = sc.nextInt();

		isChecked = new boolean[N][M];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (sc.nextInt() == 1) {
					isChecked[r][c] = true;
				} else {
					continue;
				}
			}
		}

		bfs();
		
		System.out.println(pictureSizeList.size()); // 그림 개수 출력

		Collections.sort(pictureSizeList); // 오름차순으로 정렬
		
		// 그림이 하나도 없는 경우
		if(pictureSizeList.size() == 0) {
			System.out.println(0); // 0 출력
		}else {			
			System.out.println(pictureSizeList.get(pictureSizeList.size() - 1)); // 가장 마지막 == 가장 큰 그림의 사이즈
		}

	} // main

	private static void bfs() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!isChecked[i][j]) {
					continue;
				}

				int size = 0;

				Queue<int[]> queue = new LinkedList<>();
				queue.offer(new int[] { i, j });
				isChecked[i][j] = false; // 처음 지점 방문 완료 == False로 바꿈. // TRUE인 곳들만 찾아다님

				// TRUE가 이어진 곳들 돌면서 탐색 완료
				while (!queue.isEmpty()) {
					int[] tmp = queue.poll();

					int currentR = tmp[0]; // 현재 R 위치
					int currentC = tmp[1]; // 현재 C 위치

					size++; // TRUE (1)인 값을 하나 뺐으니까 그림 사이즈++

					// 이 위치로부터 사방탐색 시작
					for (int dir = 0; dir < 4; dir++) {
						int nr = currentR + dr[dir];
						int nc = currentC + dc[dir];

						if (nr < 0 || nr >= N || nc < 0 || nc >= M)
							continue;
						if (!isChecked[nr][nc])
							continue;

						// TRUE인 곳에 갔다면 -> 탐색 완료 했으니 false로 변경해주기
						isChecked[nr][nc] = false;

						// 해당 위치 queue에 추가
						queue.offer(new int[] { nr, nc });
					}
				} // while

				// TRUE가 이어진 곳들 탐색하면서 size++ 시킴
				pictureSizeList.add(size); // List에 그림 크기 추가하기

				// 이후 다시 for 문 돌면서 borad에서 TRUE인 곳 찾아서 다시 bfs 반복
			}
		}

	} // bfs

}
