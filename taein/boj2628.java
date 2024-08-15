import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class boj2628 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int C = sc.nextInt(); // 가로 -> 열
        int R = sc.nextInt(); // 세로 -> 행 
        
        int n = sc.nextInt(); // 자르는 갯수
        ArrayList<Integer> rCut = new ArrayList<>(); // 가로 자르기 -> 행이 바뀜
        ArrayList<Integer> cCut = new ArrayList<>(); // 세로 자르기 -> 열이 바뀜
        
        rCut.add(0); // 맨 위는 이미 잘라져 있음
        cCut.add(0); // 맨 왼쪽은 이미 잘라져 있음
        
        for (int i = 0; i < n; i++) {
            int dir = sc.nextInt();
            int cutPst = sc.nextInt();
            if (dir == 0) {
                rCut.add(cutPst);
            } else {
                cCut.add(cutPst);
            }
        }
        
        rCut.add(R); // 맨 아래는 이미 잘라져 있음
        cCut.add(C); // 맨 오른쪽은 이미 잘라져 있음
        
        Collections.sort(rCut);
        Collections.sort(cCut);
        
        int maxHeight = 0; // 가장 큰 조각 구하기
        for (int i = 1; i < rCut.size(); i++) {
            maxHeight = Math.max(maxHeight, rCut.get(i)-rCut.get(i-1));
        }
        
        int maxWidth = 0;
        for (int i = 1; i < cCut.size(); i++) {
            maxWidth = Math.max(maxWidth, cCut.get(i)-cCut.get(i-1));
        }
        
        int maxArea = maxHeight * maxWidth;
        System.out.println(maxArea);        
    }
}
