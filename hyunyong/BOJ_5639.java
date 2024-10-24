import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5639 {
	static class Node {
		int value;
		Node left;
		Node right;
		
		public Node(int value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
		
		void insertNode(int value) {
			if(value<this.value) {
				if(this.left != null) {
					this.left.insertNode(value);
				} else {
					this.left = new Node(value, null, null);
				}
			} else {
				if(this.right != null) {
					this.right.insertNode(value);
				} else {
					this.right = new Node(value, null, null);
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		Node root = new Node(Integer.parseInt(br.readLine()),null,null);
		
		String input;
		while(true) {
			input = br.readLine();
            if (input == null || input.equals(""))
                break;
			
			root.insertNode(Integer.parseInt(input));
		}
		
		postOrder(root);
	}
	
	static void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }
}
