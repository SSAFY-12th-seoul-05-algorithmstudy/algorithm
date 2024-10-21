import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int num;
        Node left, right;

        Node(int num) {
            this.num = num;
        }

        Node(int num, Node left, Node right) {
            this.num = num;
            this.left = left;
            this.right = right;
        }
        
        // 삽입
        void insert(int n) {
            if (n < this.num) {
                if (this.left == null) {
                    this.left = new Node(n);
                }
                else {
                	this.left.insert(n);
                }
            } else {
                if (this.right == null) {
                	
                    this.right = new Node(n);
                }
                else {
                	this.right.insert(n);
                }
            }
        }
    }
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Node root = new Node(Integer.parseInt(br.readLine()));
        
        String str;
        while (true) {
            str = br.readLine();
            if (str == null || str.equals(""))
                break;
            root.insert(Integer.parseInt(str));
        }

        postOrder(root);
        System.out.println(sb);
    }

    static void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.num).append("\n");
    }
}