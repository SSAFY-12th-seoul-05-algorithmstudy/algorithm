import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken()); // 음의 수 N
        int P = Integer.parseInt(st1.nextToken()); // 프랫의 수 P
        		
        
        Stack<Integer>[] stackArr = new Stack[N]; // 스택 배열생성
        for (int i=0; i<N;i++) {
        	stackArr[i]= new Stack<Integer>();
        }
       
        int cnt = 0; // 최종 카운트
        for(int tc=0; tc<N; tc++) {	// 음의 수 만큼 반복
        	StringTokenizer st2 = new StringTokenizer(br.readLine());
        	int sNum = Integer.parseInt(st2.nextToken()); // 쳐야하는 줄의 번호
        	int pNum = Integer.parseInt(st2.nextToken()); // 쳐야하는 프랫의 번호
        	
        	
        	if (stackArr[sNum-1].isEmpty()){	// 줄에 해당하는 스택이 비어있으면
        		stackArr[sNum-1].push(pNum);	// 푸쉬
        		cnt++;	// 카운트+1
        		continue;
        	}
        	
        	else {	// 스택이 비어있지 않을 때
        		// peek == pNum
	        	if(stackArr[sNum-1].peek()==pNum) {	// 같을 경우 손 안움직여도 됨
	        	
	        	}
	        	// peek < pNum
	        	else if(stackArr[sNum-1].peek() < pNum){	// 작으면 푸쉬
	        		stackArr[sNum-1].push(pNum);
	        		cnt++;
	        	}
	        	// peek > pNum
	        	else {	// 더 클때
		        	while(!stackArr[sNum-1].isEmpty() && stackArr[sNum-1].peek() > pNum){ // 가장 위의 값이 pNum과 같거나 더 작을때까지
		        		stackArr[sNum-1].pop(); // pop을한다.
		        		cnt++;	// 카운트+1
		        	}
		        	// pop을 했으므로 다시 비어있을 경우
		        	if (stackArr[sNum-1].isEmpty()) {
		        		stackArr[sNum - 1].push(pNum);  // 비어있으므로 푸시
		                cnt++;
		        	}
		        	// peek == pNum
		        	else if (stackArr[sNum - 1].peek() == pNum) {  // peek 값이 pNum과 같을 때
		            
		        	}
		        	
		        	// peek < pNum
		        	else if (stackArr[sNum - 1].peek() < pNum) {  // peek 값이 pNum보다 작을 때
		        		stackArr[sNum - 1].push(pNum);  // 푸시
		        		cnt++;
		            }
	        	}

        	}
        }
        System.out.println(cnt);
    }
}
