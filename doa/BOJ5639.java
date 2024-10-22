package 알고리즘;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class BOJ5639 {
	
	  static class Node {
	        int key;
	        Node left, right;

	        Node(int key) {
	            this.key = key;
	            left = right = null;
	        }
	    }
	  
	  static Node insertNode(Node node, int num) {
		  
		  if(node == null)
			  return new Node(num);
		  
		  if(num < node.key) {
			  node.left = insertNode(node.left, num);
		  }else {
			  
			  node.right = insertNode(node.right, num);
		  }
		  
		  return node;
		  
	  }
	  
	  static void postOrder(Node num) {
		  
		  if(num!=null) {
			  postOrder(num.left);
			  postOrder(num.right);
			  System.out.println(num.key);
		  }
		  
	  }

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		
		
		//루트 값 입력
		Node now = null;
		
		while((input = br.readLine()) != null && !input.isEmpty()) {
			int num = Integer.parseInt(input);

			now = insertNode(now,num);
			
		}
		
		
		postOrder(now);

	}
	
}



