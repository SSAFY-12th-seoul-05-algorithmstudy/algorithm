import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        // 수열
        int[] arr = new int[N];
        
        for(int i=0;i<N;i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        
        List<Integer> sum = new ArrayList<>();
        
        for(int i=0;i<N;i++) {
        	for(int j=i;j<N;j++) {
        		sum.add(arr[i]+arr[j]);
        	}
        }
        
        Collections.sort(sum);
        
        int answer=-1;
        for(int i=N-1;i>=0;i--) {
        	for(int j=0;j<=i;j++) {
        		int num = arr[i]-arr[j];
        		
        		int left = 0;
        		int right = sum.size()-1;
        		while(left<=right) {
        			int mid = (left+right)/2;
        			if(sum.get(mid)>num) {
        				right = mid-1;
        			}
        			else if(sum.get(mid)<num) {
        				left= mid+1;
        			}
        			else {
        				answer = Math.max(answer, arr[i]);
        				break;
        			}
        		}
        		
        	}
        }
        System.out.println(answer);
    }
}