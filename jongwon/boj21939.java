package P_1021;
import java.util.*;

public class boj21939 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Node> treeSet = new TreeSet<>();
        Map<Integer, Node> hashMap = new HashMap<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            int l = sc.nextInt();
            Node node = new Node(p, l);
            if (hashMap.containsKey(p)) {
                Node getNode = hashMap.get(p);
                hashMap.remove(p);
                treeSet.remove(getNode);
            }
            hashMap.put(p, node);
            treeSet.add(node);
        }

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String s = sc.next();
            if (s.equals("add")) {
                int p = sc.nextInt();
                int l = sc.nextInt();
                Node node = new Node(p, l); //새로 만들고
                if (hashMap.containsKey(p)) { //있으면 제거
                    Node getNode = hashMap.get(p);
                    hashMap.remove(p);
                    treeSet.remove(getNode);
                }
                hashMap.put(p, node); //그리고 넣어
                treeSet.add(node); // 넣어

            } else if (s.equals("recommend")) {
                int num = sc.nextInt();
                if (num == 1) {
                    //맨 처음 꺼내
                    System.out.println(treeSet.first().p);
                } else if (num == -1) {
                    System.out.println(treeSet.last().p);
                }
            } else if (s.equals("solved")) {
                int num = sc.nextInt();
                Node node = hashMap.get(num);
                hashMap.remove(num);
                treeSet.remove(node);
            }
        }
    }

    static class Node implements Comparable<Node> {
        int p;
        int l;

        public Node(int p, int l) {
            this.p = p;
            this.l = l;
        }

        @Override
        public int compareTo(Node o) {
            if (this.l == o.l) {
                return o.p - this.p;
            }
            return o.l - this.l;
        }
    }


}
