import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class BOJ_13023 {
    
    static int N, M;
    static List<Integer>[] friend;
    static boolean[] visited;
    static boolean flag;
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 사람 수
		M = sc.nextInt(); // 관계 수

        friend = new ArrayList[N];
        
        for(int i=0; i<N; i++){
            friend[i] = new ArrayList<>();
        } // 리스트 초기화 완료

		for(int i=0; i<M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
            friend[A].add(B);
            friend[B].add(A);
		} // 입력완료
        
		visited = new boolean[N];
        flag = false;
        
        for(int i=0; i<N; i++){
           if(!flag){
              dfs(i,1);
           }   
        }
        
        if(flag){
            System.out.println(1);
        } else{
            System.out.println(0);
        }
	}
    
    private static void dfs(int row, int cnt){
        
        if(cnt >= 5){
            flag = true;
            return;
        }
        
        // 방문체크
        visited[row] = true;
       
        for(int num : friend[row]){
            // 아직 확인하지 않았고 B와 연관있는 애들
            if(!visited[num]){
                if(!flag){
                    dfs(num, cnt+1);
                }
            }
        }
        
        visited[row] = false;
    }
}
