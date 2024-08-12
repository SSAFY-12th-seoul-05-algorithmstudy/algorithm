package Deque_Queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Document{
	int idx;
	int importance;
	
	public Document(int idx, int importance) {
		super();
		this.idx = idx;
		this.importance = importance;
	}
}


public class BOJ_1966 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<T+1; tc++) {
			int N = sc.nextInt(); // 문서 개수
			int M = sc.nextInt(); // 뽑고자 하는 문서의 idx
			
			Queue<Document> queue = new LinkedList<>();
			int[] seq = new int[N]; // 중요도 배열
			
			// 배열, 큐에 입력값 넣어주기
			for(int i=0; i<N; i++) {
				seq[i] = sc.nextInt();
				queue.add(new Document(i, seq[i]));
			}
			
			Arrays.sort(seq); // 오름차순으로 정렬한다
			
			int cnt = 0;
			int idx = N-1; // 배열의 가장 마지막 idx(최대값)부터 접근
			while(true) {
				// 1. 일단 하나 빼서 확인한다
				Document doc = queue.poll();
				
				// 2. 중요도 배열이 가리키는 값과 중요도가 같은지 확인한다
				if(doc.importance != seq[idx]) { // 다르면
					// 뽑으면 안되는 문서이므로 뒤로 간다
					queue.add(doc);
				} else { // 같으면
					// 해당 문서를 뽑으므로 cnt++
					cnt++;
					idx--; // 중요도 배열의 다음 요소로 넘어간다
                    
					// 찾고자 하는 idx와 같으면 while문 종료
					if(doc.idx == M)
						break;
				}
			} //while
			System.out.println(cnt);
		} // tc
	}//main
}
