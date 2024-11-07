package P_1031;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class boj5214 {
    static HashMap<Integer, HashSet<Integer>> hashMap;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 역의 수
        int k = sc.nextInt(); // 하나의 하이퍼튜브가 서로 연결하는 역의 수
        int m = sc.nextInt(); // 하이퍼튜브 수

        hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hashMap.put(i, new HashSet<>());
        }

        // m개를 연결 할 것인데 총 몇개?
        for (int i = 0; i < m; i++) {
            List<Integer> tempList = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                tempList.add(sc.nextInt() - 1);
            }
            for (int l = 0; l < k - 1; l++) {
                for (int o = l + 1; o < k; o++) {
                    hashMap.get(tempList.get(l)).add(tempList.get(o));
                    hashMap.get(tempList.get(o)).add(tempList.get(l));
                }
            }
        }
        //각각에 다 넣어주고 이제 bfs돌려버려


        //체크해라 마지막역까지 갈 수 있는지?
        Queue<int[]> que = new LinkedList<>();
        boolean[] visited= new boolean[n];


        que.add(new int[] {0,1});
        visited[0] = true;
        int answer = -1;
        while(!que.isEmpty()) {
            int[] pollItem = que.poll();

            if(pollItem[0] == n-1) {
                answer = pollItem[1];
                System.out.println(answer);
                break;
            }
            //만약 꺼내진게 조건에 맞으면 그냥 털어버려
            HashSet<Integer> set = hashMap.get(pollItem[0]);
            Integer[] arr = set.toArray(new Integer[0]);

            for(int i = 0 ; i < arr.length; i++) {
                if(!visited[arr[i]]) {
                    que.add(new int[] {arr[i] ,pollItem[1] +1});
                }
            }
        }
    }
}