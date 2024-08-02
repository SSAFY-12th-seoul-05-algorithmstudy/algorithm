import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Cnt = Integer.parseInt(br.readLine());
		int[] stack = new int[Cnt];
		int pos = 0;
		for (int tc = 0; tc < Cnt; tc++) {
			String line = br.readLine();
			if (line.contains("push")) {
				stack[pos++] = (Integer.parseInt(line.split(" ")[1]));
				continue;
			}
			if (line.equals("pop")){
				if (pos == 0)
					System.out.println(-1);
				else
					System.out.println(stack[--pos]);
			}else if (line.equals("size")) {
				System.out.println(pos);
			}else if (line.equals("empty")) {
				if (pos == 0)
					System.out.println(1);
				else
					System.out.println(0);
			}else if (line.equals("top")) {
				if (pos == 0)
					System.out.println(-1);
				else
					System.out.println(stack[pos - 1]);
			}
		}
	}
}