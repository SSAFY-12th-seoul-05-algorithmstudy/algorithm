import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Document{
	int docIdx;
	int docNum;
	public Document(int docInt, int docNum) {
		this.docIdx = docInt;
		this.docNum = docNum;
	}
}

public class boj1966 {

    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	
    	int T = sc.nextInt();
    	
    	for(int tc=1; tc<=T; tc++) {
    		int N = sc.nextInt(); // 문서의 갯수
    		int M = sc.nextInt(); // 궁금한 문서의 문서 인덱스
    		Queue<Document> queue = new LinkedList<>();
    		
    		for(int i=0; i<N; i++) {
    			queue.add(new Document(i,sc.nextInt())); // 인덱스와 중요도를 큐에 삽입
    		}
    		
    		int cnt = 0;
    		
    		while(!queue.isEmpty()) {
    			Document current = queue.poll(); // 큐의 맨 위 문서 확인
    			boolean isFound = false; // 판별을 위한 flag
    			
    			for(Document doc : queue) {
    				if(doc.docNum > current.docNum) { // 중요도 비교
    					isFound = true;
    					break;
    				}
    			}
    			
    			if(isFound) { // 더 높은 중요도의 문서 발견
    				queue.add(current); // 맨 위 문서 맨 뒤로 보냄
    			} else {
    				cnt++; //높은 중요도의 문서 인쇄됨
        			if(current.docIdx == M) { // 원하는 인덱스의 문서가 인쇄됨
        				System.out.println(cnt);
        				break;
        			}
    			}
    			
    		}
    	}
    }
}