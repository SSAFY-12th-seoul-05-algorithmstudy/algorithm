import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer> stack = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        
        for(int i=0 ; i<n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    int x = Integer.parseInt(st.nextToken());
                    stack.add(x);
                    break;
                case "pop":
                    if (stack.size() == 0) {
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(stack.remove(stack.size() - 1)).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    sb.append((stack.size() == 0) ? 1 : 0).append("\n");
                    break;
                case "top":
                    sb.append((stack.size() == 0) ? -1 : stack.get(stack.size() - 1)).append("\n");
                    break;
            }
        }
        
        System.out.println(sb.toString());
        
        br.close();
        bw.close();
    }
}
