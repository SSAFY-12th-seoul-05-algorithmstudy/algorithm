import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		int[] type = new int[N];
		for (int tc = 0; tc < N; tc++)
			type[tc] = Integer.parseInt(tokenizer.nextToken());
		
		Deque<Integer> queue = new LinkedList<>();
		tokenizer  = new StringTokenizer(br.readLine());
		for (int tc = 0; tc < N; tc++) {
			int curChar = Integer.parseInt(tokenizer.nextToken());
			if (type[tc] == 0)
				queue.offerFirst(curChar);
		}
		
		StringBuilder sb = new StringBuilder();
		int cnt = Integer.parseInt(br.readLine());
		tokenizer = new StringTokenizer(br.readLine());
		for (int i = 0; i < cnt; i++) {
			queue.offerLast(Integer.parseInt(tokenizer.nextToken()));
			sb.append(queue.pollFirst()).append(" ");
		}
		System.out.println(sb);
	}
}