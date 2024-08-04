import java.util.Stack;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] stack = new int[10001]; // 명령이 10000개까지라 길이가10000인 배열
	static int size;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 테스트케이스
		
		
		for (int tc=0; tc<T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "push":
				push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				System.out.println(pop());
				break;
			case "size":
				System.out.println(size());
				break;
			case "empty":
				System.out.println(empty());
				break;
			case "top":
				System.out.println(top());
				break;
			}
		}
	}
	public static void push(int num) {
		stack[size] = num;
		size++;
	}
	public static int pop() {
		if (size==0) {
			return -1;
		}
		else {
			int P = stack[size-1];
			size--;
			return P;
		}
	}
	public static int size() {
		return size;
	}
	public static int empty() {
		if (size==0) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public static int top() {
		if (size==0) {
			return -1;
		}
		else {
			int T = stack[size-1];
			return T;
		}
	}
	
}