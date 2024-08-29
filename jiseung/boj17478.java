import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String[] question;
	static String answer = "라고 답변하였지.";
	static String str="";
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		
		String[] question = new String[5];
		question[0]= "\"재귀함수가 뭔가요?\"";
		question[1]= "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
		question[2]= "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
		question[3]= "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
		question[4]= "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
		String answer = "라고 답변하였지.\n";
		for (int i=0;i<4;i++) {
			System.out.println(question[i]);
        }
		System.out.println(recursion1(N,question));
		System.out.println(recursion2(N,answer));
	}

	public static String recursion1(int a,String question[]) {
		str = str + "____";
		if(a==1) {
			return str+question[0]+"\n"+str+question[4]+"\n"+str+answer;
		}
		else {
			for (int i=0;i<question.length-1;i++) {
	            System.out.println(str+question[i]);
	        }
		}
		return recursion1(a-1,question);
	}

	public static String recursion2(int a,String answer) {
		str = str.substring(4);
		if(a==1) {
			return answer;
		}
		else {
			return str+answer+recursion2(a-1,answer);
		}
	}
}