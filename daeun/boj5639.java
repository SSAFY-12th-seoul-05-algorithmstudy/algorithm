import java.util.Scanner;

public class boj5639 {

    static class Node {
        int num;
        Node left, right;

        public Node(int num) {
            this.num = num;
        }

        void insert(int input) {
            if (input < this.num) {
                if (this.left == null) {
                    this.left = new Node(input);
                } else {
                    this.left.insert(input);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(input);
                } else {
                    this.right.insert(input);
                }
            }
        }
    }

    static StringBuilder sb = new StringBuilder();

    static void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            sb.append(node.num).append("\n");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = new Node(sc.nextInt());// 류트 입력받음

        sc.nextLine(); // 버퍼 비우기?
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isEmpty()) //입력없으면 종료
                break;

      
                int N = Integer.parseInt(line);
                root.insert(N);
         
        }

        postOrder(root);
        System.out.println( sb);
        
        sc.close(); // Scanner 종료
    }
}
