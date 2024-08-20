import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st1 = new StringTokenizer(br.readLine());	// 전체정보

        int total = Integer.parseInt(st1.nextToken()); // 총 인원
        int limit = Integer.parseInt(st1.nextToken()); // 방 인원제한
        		
        int count = 0; //방의 갯수
        
    	int[] male = new int[7]; // 남학생
    	int[] female = new int[7]; //여학생
    	
        // total 만큼 반복
        for (int i=1;i<=total;i++) {
        	StringTokenizer st2 = new StringTokenizer(br.readLine());	// 학생정보
        	
        	int sex = Integer.parseInt(st2.nextToken());	// 성별
        	int grade = Integer.parseInt(st2.nextToken());	// 학년
        	
        	// 남자면 남자배열의 학생인덱스의 값++
        	if (sex==1) {
        		male[grade]++;
        	}
        	// 여자면 여자배열의 학생인덱스의 값++
        	else {
        		female[grade]++;
        	}
        }
        for(int j=1;j<=6;j++) {	//1학년부터6학년까지 방갯수 세기
    		count += (int) Math.ceil((double) male[j]/limit);
    		count += (int) Math.ceil((double) female[j]/limit);
    	}
        System.out.println(count);
    }
}