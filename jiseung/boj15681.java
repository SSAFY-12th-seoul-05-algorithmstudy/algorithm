import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] list, tree;
	static int[] p, size;
	
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        
        p = new int[N+1];
        size = new int[N+1];
        list = new ArrayList[N+1];
        tree = new ArrayList[N+1];
        
        
        for(int i=0;i<N+1;i++) {
        	list[i] = new ArrayList<>();
        	tree[i] = new ArrayList<>();
        }
        
        for(int i=1;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int u = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	
        	list[u].add(v);
        	list[v].add(u);
        }
        
        makeTree(R,-1);
        countSubtreeNodes(R);
        for(int i=0;i<Q;i++) {
        	int num  = Integer.parseInt(br.readLine());
        	sb.append(size[num]).append("\n");
        }
        System.out.println(sb);
    }
    
    static void makeTree(int curNode,int parent) {
    	for(int node : list[curNode]) {
    		if(node!=parent) {
    			tree[curNode].add(node);
    			p[node] = curNode;
    			makeTree(node,curNode);
    		}
    	}
    }
    
    static void countSubtreeNodes(int curNode) {
    	size[curNode]=1;
    	
    	for(int node: tree[curNode]) {
    		countSubtreeNodes(node);
    		size[curNode]+=size[node];
    	}
    }
}