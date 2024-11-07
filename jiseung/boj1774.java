import java.util.*;
import java.io.*;

public class Main {
	static int[] parent;
	static int[][] god;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        god = new int[N+1][2];
        
        for(int i=1;i<=N;i++) {
        	st = new StringTokenizer(br.readLine());
        	god[i][0] = Integer.parseInt(st.nextToken());
        	god[i][1] = Integer.parseInt(st.nextToken());
        }
        
        parent = new int[N+1];
        for(int i=1;i<=N;i++) {
        	parent[i]=i;
        }
        
        for(int i=0;i<M;i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	union(a,b);
        }
        
        List<double[]> list = new ArrayList<>();
        for(int i=1;i<N;i++) {
        	for(int j = i+1;j<=N;j++) {
        		list.add(new double[] {i,j,dist(i,j)});
        	}
        }
        Collections.sort(list,(o1,o2)->o1[2]<o2[2]?-1:1);
        
        double result=0;
        for(int i=0;i<list.size();i++) {
        	if(union((int)list.get(i)[0],(int)list.get(i)[1])) {
        		result += list.get(i)[2];
        	}
        }
        System.out.println(String.format("%.2f",result));
        
    }
    static int find(int a) {
    	if(parent[a]==a) return a;
    	return parent[a]=find(parent[a]);
    }
    
    static boolean union(int a, int b) {
    	a = find(a);
    	b = find(b);
    	if(a==b) return false;
    	if(a<b) parent[b]=a;
    	else parent[a]=b;
    	return true;
    }
    static double dist(int a, int b) {
    	return Math.sqrt(Math.pow((god[a][0]-god[b][0]),2)+Math.pow((god[a][1]-god[b][1]),2));
    }
}