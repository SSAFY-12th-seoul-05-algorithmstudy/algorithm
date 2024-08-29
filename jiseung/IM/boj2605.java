import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); // 학생 수
        
        StringTokenizer st = new StringTokenizer(br.readLine()); // 학생이 뽑은 번호
        
        List<Integer> list = new ArrayList<>();	// 리스트 생성
        
        for (int i=0; i<N; i++) {
        	int num = Integer.parseInt(st.nextToken());	// 뽑은 번호
        	list.add(i-num,i+1);	// 리스트에 넣을 때, 인덱스는 i(원래들어갈자리)-num(앞으로가는만큼), 값은 i+1
        }
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                // 마지막 요소일 경우 공백을 출력하지 않음
                System.out.print(list.get(i));
            } else {
                System.out.print(list.get(i) + " ");
            }
        }
    }
}