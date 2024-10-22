package P_1021;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class boj21944 {
    static Map<Integer, Node> hashMap = new HashMap<>();
    static TreeSet<Node> allTreeSet = new TreeSet<>();
    static Map<Integer, TreeSet<Node>> classification = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            int l = sc.nextInt();
            int g = sc.nextInt();
            add(p, l, g);
        }
        int times = sc.nextInt();
        for (int i = 0; i < times; i++) {
            String s = sc.next();
            switch (s) {
                case "recommend":
                    int g = sc.nextInt();
                    int x1 = sc.nextInt();
                    System.out.println(recommend(g, x1));
                    break;
                case "recommend2":
                    int x2 = sc.nextInt();
                    System.out.println(recommend2(x2));
                    break;
                case "recommend3":
                    int x3 = sc.nextInt();
                    int l = sc.nextInt();
                    System.out.println(recommend3(x3, l));
                    break;
                case "add":
                    int pa = sc.nextInt();
                    int la = sc.nextInt();
                    int ga = sc.nextInt();
                    add(pa, la, ga);
                    break;
                case "solved":
                    int ps = sc.nextInt();
                    solved(ps);
                    break;
                default:
                    System.out.println("안돼..");
            }
        }
        sc.close();
    }
    static int recommend(int G, int x) {
        // G그룹에 첫 빠따
        if (x == 1) {
            return classification.get(G).first().P;
        }
        // G그룹에 마지막
        return classification.get(G).last().P;
    }
    static int recommend2(int x) {
        // 모든 것들중에서 첫빠따.
        if (x == 1) {
            return allTreeSet.first().P;
        }
        // 모든 것들중에서 마지막
        return allTreeSet.last().P;
    }
    static int recommend3(int x, int l) {
        // 문제 난이도가 L보다 높은 것을 골라라!
        int num = 0;
        // x == 1 이면
        if (x == 1) {
            try {
                num = allTreeSet.lower(new Node(0, l, 0)).P;
            } catch (Exception e) {
                return -1;
            }
        } else {
            try {
                num = allTreeSet.ceiling((new Node(0, l, 0))).P;
            } catch (Exception e) {
                return -1;
            }
        }
        return num;
    }
    static void add(int p, int l, int g) {
        Node node = new Node(p, l, g);
        // 문제 번호와 node를 넣어라
        hashMap.put(p, node);
        allTreeSet.add(node);// 모든 트리셋에 넣어
        if (!classification.containsKey(g)) {
            classification.put(g, new TreeSet<>());
        }
        classification.get(g).add(node);
    }

    static void solved(int p) {
        // 번호 p가 들어오면 해결해버려

        if (!hashMap.containsKey(p)) {
            return;
        }
        Node getNode = hashMap.get(p);
        allTreeSet.remove(getNode);
        classification.get(getNode.G).remove(getNode);
        // 일일이 돌면서 제거
        hashMap.remove(p); // 제거

    }

    static class Node implements Comparable<Node> {
        int P;
        int L;
        int G;

        public Node(int p, int l, int g) {
            super();
            this.P = p;
            this.L = l;
            this.G = g;
        }

        @Override
        public int compareTo(Node o) {
            if (o.L == this.L) {
                return o.P - this.P;
            }
            return o.L - this.L;
        }

    }
}
