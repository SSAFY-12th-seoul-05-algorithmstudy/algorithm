import java.io.*;
import java.util.*;
 
 
public class Main {
   static Node[] tree;
   static int remove;
   static int answer;
   public static void main(String[] args) throws IOException {
      //입력
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(in.readLine());
      StringTokenizer st = new StringTokenizer(in.readLine());
      remove = Integer.parseInt(in.readLine());
 
      //초기화
      tree = new Node[N];
      for(int i=0;i<N;i++)
         tree[i] = new Node(i);
 
      //트리생성
      int parent,root=0;
      for(int i=0;i<N;i++){
         parent = Integer.parseInt(st.nextToken());
         if(parent==-1) {
            root = i;
            continue;
         }
         tree[parent].addChild(tree[i]);
      }
 
      //지운 노드 제외하고 리프노드 탐색
      if(root!=remove) search(tree[root]);
 
      //출력
      System.out.println(answer);
   }
 
   public static void search(Node curr){
      int size = curr.list.size();
      for(Node next:curr.list){
         if(next.idx == remove){
            size--;
            continue;
         }
         search(next);
      }
      if(size==0) answer++;
   }
 
   static class Node {
      int idx;
      ArrayList<Node> list = new ArrayList<>();
      Node(int idx){
         this.idx = idx;
      }
      void addChild(Node child){
         list.add(child);
      }
   }
}