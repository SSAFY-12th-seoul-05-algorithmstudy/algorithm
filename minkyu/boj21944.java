import java.util.*;
import java.io.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
 
        TreeSet<Problem> ts = new TreeSet<>();
        HashMap<Integer, Problem2> hm = new HashMap<>();
 
        TreeSet<Problem>[] groupArr = new TreeSet[101];
 
        int N = Integer.parseInt(br.readLine());
 
        StringTokenizer st;
 
        for(int i=0; i<101; i++)
            groupArr[i] = new TreeSet<>(); 
 
        for(int i=0; i<N; i++){     
            st = new StringTokenizer(br.readLine());       
            int no = Integer.parseInt(st.nextToken());            
            int hardness = Integer.parseInt(st.nextToken());    
            int group = Integer.parseInt(st.nextToken());            
            
            ts.add(new Problem(no, hardness));
            groupArr[group].add(new Problem(no, hardness));
            hm.put(no, new Problem2(hardness, group));
        }
 
        int M = Integer.parseInt(br.readLine());
 
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
 
            if(command.equals("recommend")){
                int group = Integer.parseInt(st.nextToken());
                int cmd = Integer.parseInt(st.nextToken());
 
                if(cmd == 1){
                    sb.append(groupArr[group].last().no + "\n"); 
                }
                if(cmd == -1){
                    sb.append(groupArr[group].first().no + "\n"); 
                }
            }
 
            if(command.equals("recommend2")){
                int cmd = Integer.parseInt(st.nextToken());
 
                if(cmd == 1){
                    sb.append(ts.last().no + "\n"); 
                }
                if(cmd == -1){
                    sb.append(ts.first().no + "\n"); 
                }
            }
 
            if(command.equals("recommend3")){
                int cmd = Integer.parseInt(st.nextToken());
                int condition = Integer.parseInt(st.nextToken());
 
                if(cmd == 1){
                    Problem tmp = ts.higher(new Problem(0, condition));
                    if(tmp == null){
                        sb.append(-1 + "\n");
                    }else{
                        sb.append(tmp.no + "\n");
                    }
                }
 
                if(cmd == -1){
                    Problem tmp = ts.lower(new Problem(0, condition));
                    if(tmp == null){
                        sb.append(-1 + "\n");
                    }else{
                        sb.append(tmp.no + "\n");
                    }
                }
            }
 
            if(command.equals("add")){
                int no = Integer.parseInt(st.nextToken());
                int hardness = Integer.parseInt(st.nextToken());
                int group = Integer.parseInt(st.nextToken());
 
                ts.add(new Problem(no, hardness));
                groupArr[group].add(new Problem(no, hardness));
                hm.put(no, new Problem2(hardness, group));                
            }
 
            if(command.equals("solved")){
                int no = Integer.parseInt(st.nextToken());
                int hardness = hm.get(no).hardness;
                int group = hm.get(no).group;
 
                ts.remove(new Problem(no, hardness));
                hm.remove(no);
                groupArr[group].remove(new Problem(no, hardness));
                
            }
        }
 
        System.out.println(sb);
    }
 
    static class Problem implements Comparable<Problem>{
        int no = 0;
        int hardness = 0;
 
        Problem(int a, int b){
            no = a;
            hardness = b;
        }
 
        @Override
        public int compareTo(Problem o2){
        	if (this.hardness == o2.hardness)
        		return Integer.compare(this.no, o2.no);
        	return Integer.compare(this.hardness, o2.hardness);
        }
 
    }
 
    static class Problem2{
        int hardness = 0;
        int group = 0;
 
        Problem2(int a, int b){
            hardness = a;
            group = b;
        }
    }
 
}