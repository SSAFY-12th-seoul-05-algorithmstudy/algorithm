import java.io.IOException;
import java.util.Scanner;

class Node {

	Node left;
	Node right;
	int data;

	public Node(int data) {

		this.data = data;

	}

}

class BinaryTree {
	public BinaryTree() {
	}

	Node root;

	void insertTree(int N) {
		if (root == null) {
			root = new Node(N);
		} else {
			recurInsert(root, N);
		}
	}

	private void recurInsert(Node root, int value) {

		if (value < root.data) {
			if (root.left == null)
				root.left = new Node(value);
			else
				recurInsert(root.left, value);

		} else {
			if (root.right == null)
				root.right = new Node(value);
			else
				recurInsert(root.right, value);
		}

	}

}

public class BOJ_5639_Tree {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		BinaryTree tree = new BinaryTree();
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			if (line.isEmpty())
				break; // 빈 줄에서 종료
			int N = Integer.parseInt(line.trim()); // 문자열로 읽고 정수로 변환
			tree.insertTree(N);
		}

		reverse(tree.root);
		System.out.println(sb.toString());

	}

	static StringBuilder sb = new StringBuilder();

	public static void reverse(Node node) {
		if (node.left != null)
			reverse(node.left);
		if (node.right != null)
			reverse(node.right);
		sb.append(node.data).append("\n");
	}

}