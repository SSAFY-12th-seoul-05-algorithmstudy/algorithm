// tc는 돌아가나 백준에서 실패라고 뜸

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
			int N = sc.nextInt(); // 문서의 개수
			int M = sc.nextInt(); // 찾고자 하는 문서의 번호
			
			Document[] docs = new Document[N]; // 문서 배열
			Queue<Document> queue = new LinkedList<>(); // 문서 queue
			int[] seq = new int[N]; // 우선순위 배열
			
			int idx=0; // 문서 인덱스 0부터 시작
			for(int i=0; i<N; i++) {
				docs[i] = new Document(idx++, sc.nextInt());
				queue.add(docs[i]);
				seq[i] = docs[i].importance;
			}
			
			Arrays.sort(seq); // 우선순위 배열 정렬해준다
			
			int cnt = 0; // 몇 번째로 뽑히는지 셀 변수
			if(N==1) { // 문서가 한 장이므로 첫번째로 뽑히고 끝난다
				cnt = 1;
			}else {
				for(int i=N-1; i>=1; i--) { // 우선순위 배열 역순회하면서
					if(seq[i] > seq[i-1]) { // 우선순위가 더 높으면
						int max = seq[i]; // 최대값 저장
						// queue 1번째 값의 우선순위가 max와 같아질 때까지
						while(queue.peek().importance != max) {
							queue.add(queue.poll()); // 다시 뒤에 넣어줌
						}
						// while문 빠져나왔으면 queue에서 빠져나가고 cnt++;
						Document doc = queue.poll();
						cnt++;
						if(doc.idx == M) // 방금 뽑은게 찾고자 하는 문서와 같으면 종료
							break;
					} else { // 우선순위가 똑같으면
						while(queue.peek().idx != M) { // 문서번호가 같아질 때까지
							queue.poll(); // 순서대로 빠져나간다
							cnt++;
						}
						queue.poll(); // 뽑고자 하는 문서를 찾았으므로 cnt++ 후 종료
						cnt++;
						break;
				}
			}
			}
			System.out.println(cnt);
		} //tc
	}//main
}
