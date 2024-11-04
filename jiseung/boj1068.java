import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int num;
		List<Node> list = new ArrayList<>();

		Node(int num) {
			this.num = num;
		}
		void insert(Node child) {
			list.add(child);
		}
	}

	static Node[] tree;
	static int remove;
	static int answer;

	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		remove = Integer.parseInt(br.readLine());

		tree = new Node[N];
		for (int i = 0; i < N; i++) {
			tree[i] = new Node(i);
		}

		int root = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num == -1) {
				root = i;
				continue;
			}
			tree[num].insert(tree[i]);
		}

		if (root != remove)
			search(tree[root]);

		System.out.println(answer);

	}

	public static void search(Node curr) {
		int size = curr.list.size();
		for (Node next : curr.list) {
			if (next.num == remove) {
				size--;
				continue;
			}
			search(next);
		}

		if (size == 0)
			answer++;
	}
}