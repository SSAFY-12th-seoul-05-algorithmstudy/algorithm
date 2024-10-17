package P_1014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj7453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(br.readLine());
        int[][] totalArr = new int[n][4];
        StringTokenizer st;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 4 ; j++){
                totalArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] AB = new int[n * n ];
        int[] CD = new int[n * n ];
        int idx = 0 ;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                AB[idx] = totalArr[i][0] + totalArr[j][1];
                CD[idx] = totalArr[i][2] + totalArr[j][3];
                idx++;
            }
        }
        Arrays.sort(AB);
        Arrays.sort(CD);

        int left = 0;
        int right = n * n - 1;
        long cnt = 0;

        while(left < n * n && right >= 0) {
            int leftVal = AB[left];
            int rightVal = CD[right];
            int tmp = leftVal + rightVal;


            if(tmp < 0) {
                while(++left < n * n && AB[left] == leftVal) {
                    // do nothing
                }
            } else if(tmp > 0) {
                while(--right >= 0 && CD[right] == rightVal) {
                    // do nothing
                }
            } else {
                long leftCnt = 1;
                long rightCnt = 1;

                while(++left < n * n && AB[left] == leftVal) {
                    leftCnt++;
                }

                while(--right >= 0 && CD[right] == rightVal) {
                    rightCnt++;
                }

                cnt += leftCnt * rightCnt;
            }
        }

        System.out.println(cnt);




    }
}
