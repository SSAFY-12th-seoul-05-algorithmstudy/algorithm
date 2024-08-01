import java.io.*;
import java.util.*;
public class Main {
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int count = 0;
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            check(s);
            // A 또는 B의 개수가 홀수가 아닐 때만
            if (s.length() % 2 == 0) {
               stack.push(s.charAt(0));
               for (int i = 1; i < s.length(); i++) {
                  if (stack.size() > 0 && stack.peek() == s.charAt(i)) {
                     stack.pop();
                  } else {
                     stack.push(s.charAt(i));
                  }
               } // 안쪽 for문
               // count 어떻게 ,,,, 
               // 코드 필요 !!!
            } // if문
       } // for문
       System.out.print(count);
    }
 }
