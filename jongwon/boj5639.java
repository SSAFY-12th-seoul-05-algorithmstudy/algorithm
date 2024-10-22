package P_1021;

import java.util.Scanner;

public class boj5639 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node rootNode = new Node(sc.nextInt());

        while (sc.hasNext()) {
            String s = sc.next();
            if(s.equals(""))break;
            int num = Integer.parseInt(s);

            Node node = new Node(num);
            Node parent = rootNode;
            while (true) {
                if(parent.value > num){
                    if(parent.left == null){
                        parent.left = node;
                        break;
                    }
                    else{
                        parent = parent.left;
                    }
                }else{
                    if(parent.right == null){
                        parent.right = node;
                        break;
                    }
                    else {
                        parent = parent.right;
                    }
                }
            }
            // 입력 다 받고
        }
        post(rootNode);
        System.out.println(sb);
        sc.close();

    }
    private static void post(Node root) {
        if (root.left != null) post(root.left);
        if (root.right != null) post(root.right);
        sb.append(root.value).append('\n');
    }

    static class Node {
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}