import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine()); // 참외의 갯수
        int N = 6;
        int[] arr = new int[N];
        int maxwidth=0;
        int maxheight=0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken()); // 방향
            int length = Integer.parseInt(st.nextToken()); // 길이
            if(i%2==0) {
            	arr[i]=length;
            	maxwidth= Math.max(maxwidth, length);
            }
            else {
            	arr[i]=length;
            	maxheight=Math.max(maxheight, length);
            }
        }
        int width =0;
        int height = 0;
        for(int i=0;i<N;i++) {
        	if(i%2==0 &&arr[i]==maxwidth) {
        		width = Math.abs(arr[(i+5)%6]-arr[(i+1)%6]);
        	}
        	else if(i%2==1 && arr[i]==maxheight) {
        		height = Math.abs(arr[(i+5)%6]-arr[(i+1)%6]);
        	}
        }
        int result = (maxwidth*maxheight - width*height)*K;
        System.out.println(result);
        
    }
}