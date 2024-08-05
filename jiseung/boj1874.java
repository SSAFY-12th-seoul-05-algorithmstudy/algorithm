import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine()); // 테스트케이스
        
        Stack<Integer> stack = new Stack<>(); // 스택 생성
        
        boolean check = true;	// 마지막에 스택수열이 가능하면 true그대로, 불가능하면 false
        
        int p = 1;	// 1부터 스택에 넣음
        
        for(int tc=0; tc<T; tc++) {	// 테스트케이스만큼 반복
        	
        	int num = Integer.parseInt(br.readLine()); // num을 입력받는다.
        	
        	// 세가지 가능성이 있다.
        	// p < num : p==num이 될때까지 push 
        	// p ==num : pop 실행
        	// p > num : 정상적이라면 p == num만 가능하다. 이런 경우가 아니면 "NO"를 출력해야하므로 가능성을 체크해야함
        	while(p<=num) {	// p가 입력받은 num이 될때까지 스택에 푸쉬하고, p 값을 올림
        		stack.push(p);
        		sb.append("+").append("\n");	// push하고 +를 append
        		p++;
        	}
        	
        	// p==num 일 경우
        	if (stack.peek()==num) {
        		stack.pop();	// pop한다.
        		sb.append("-").append("\n");	// pop했으므로 -를 append
        		continue;
        	}
        	else {	// p>num인 상태이고, 5다음 3을 pop 할 수 없는 것처럼 불가능한 상태이므로 check=false;
        		check = false;
        	}
        }
        if (check) {	// 정상적으로 수열이 완성이 되면 sb를 출력
        	System.out.println(sb);
        }
        else{	// check=false이므로 "NO"를 출력
        	System.out.println("NO");
        }
    }
}
