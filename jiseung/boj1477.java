import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        
        int[] rest= new int[N+2];
        rest[N+1]=L;
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
        	rest[i]= Integer.parseInt(st.nextToken());
        }
        Arrays.sort(rest);
        
        int left = 1;
        int right = L;
        
        while(left<=right) {
        	int mid = (left+right)/2;
        	int sum =0;
        	for(int i=1;i<=N+1;i++) {
        		sum += ((rest[i]-rest[i-1]-1)/mid);
        	}
        	if(sum>M) {
        		left=mid+1;
        	}
        	else {
        		right=mid-1;
        	}
        }
        System.out.println(left);
    }
}
