package P_1031;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj2617 {
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //총 숫자의 갯수를 받아
        int m = sc.nextInt(); //쌍의 갯수를 받아.
        List<List<Integer>> parentList = new ArrayList<>();
        List<List<Integer>> childList = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) {
            parentList.add(new ArrayList<>()); //부모 리스트
            childList.add(new ArrayList<>()); // 애기 리스트
        }

        for(int i = 0 ; i < m ; i++) {
            int bigger = sc.nextInt() - 1;
            int smaller = sc.nextInt() - 1 ;
            parentList.get(smaller).add(bigger);
            childList.get(bigger).add(smaller);
        }
        int realAnswer = 0 ;
        // 방문했더라면 안들어가도 괜찮아가 필요해.
        visited = new boolean[n];
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                visited[j] = false;
            }
            int upAnswer = dfs(i,parentList,0);
            int downAnswer = dfs(i,childList,0);
            if(upAnswer > n/2 || downAnswer > n/2) {
                realAnswer++;
            }
        }
        System.out.println(realAnswer);
    }

    static int dfs(int x, List<List<Integer>> arrayList, int cnt) {
        for (int i = 0; i < arrayList.get(x).size(); i++) {
            if (!visited[arrayList.get(x).get(i)]) {
                visited[arrayList.get(x).get(i)] = true;
                cnt += dfs(arrayList.get(x).get(i), arrayList, 1);
            }
        }
        return cnt;
    }
}