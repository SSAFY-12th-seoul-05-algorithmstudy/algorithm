import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj11729 {

    static int n;
    static StringBuilder sb;
    static int count;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        hanoi(n, 1, 2, 3);

        bw.write(String.valueOf(count));
        bw.write("\n");
		bw.write(sb.toString());

		br.close();
		bw.close();
	}

    static void hanoi(int k, int start, int sub, int dest) {
        count++;

        if (k == 1) {
            sb.append(start).append(" ").append(dest).append("\n");
            return;
        }

        hanoi(k - 1, start, dest, sub);

        sb.append(start).append(" ").append(dest).append("\n");

        hanoi(k - 1, sub, start, dest);
    }
}
