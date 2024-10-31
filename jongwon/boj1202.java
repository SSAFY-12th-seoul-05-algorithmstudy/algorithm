package P_1021;

import java.util.*;

public class boj1202 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        // n개의 정보가 주어질 것이다!
        List<Jew> jewList = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            jewList.add(new Jew(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(jewList); // 정렬

        int[] bags = new int[k];
        for(int i = 0 ; i < k ; i++){
            bags[i] = sc.nextInt();
        } // 일단 받아
        // bags는 작은놈부터 순서대로 할고야~
        Arrays.sort(bags);
        // 일단 값을 받아
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());


        long ans = 0;
        // 가방을 모두 돌 것이다.
        for (int i = 0, j = 0; i < k; i++) {
            // j인덱스가 총 개수를 넘으면 안돼
            // bags의 크기가 무조건 넣어야 할 jew보다 커야해
            // 다 넣고 j인덱스를 기억해
            while (true) {
                if(j >= n ) break; //인덱스 체크가 먼저
                if(jewList.get(j).mass > bags[i]) break; // 그다음 넣을게 없을 때 넣어라
                pq.offer(jewList.get(j++).value);
            }

            // 넣을 것을 다 넣으면 뺄 때 제일 앞에 있는놈이 제일 클 것이다.! value를 걍넣ㄹ는ㄱ야
            if (!pq.isEmpty()) {
                ans += pq.poll();
            }
        }


        System.out.println(ans);
        sc.close();
    }

    static class Jew implements Comparable<Jew>{
        int mass;
        int value;

        public Jew(int mass, int value) {
            this.mass = mass;
            this.value = value;
        }
        @Override
        public int compareTo(Jew o) {
            if(this.mass == o.mass){
                // 무게가 같다면 돈이 더 나가는 놈이 앞으로 와라
                return o.value - this.value;
            }
            // 무게가 작은놈 부터 앞으로와라~
            return this.mass - o.mass;
        }
    }

}