package com.ssafy.ws.step3;

import java.util.Arrays;
import java.util.Scanner;

public class BuildingTest {

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        for (int s=1;s<=T;s++) {
            
        
        // N을 입력받음
        int N = sc.nextInt();
        sc.nextLine();
        String[][] land = new String[N][N];
        
        // N*N개의 입력을 받고 배열에 저장
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                land[i][j] = sc.next();
            }
        }
        for (int k = 0; k < N; k++) {
            System.out.println(Arrays.toString(land[k]));
        }
        
        // 결과를 저장할 매트릭스
        int[][] result = new int[N][N];
        
        for ( int a=0 ; a<N ; a++ ) {
            out: for ( int b=0 ; b<N ; b++ ) {
                 for (int i = a - 1; i <= a + 1; i++) {
                    for (int j = b - 1; j <= b + 1; j++) {
                        if (i >= 0 && i < N && j >= 0 && j < N) {
                            if (land[i][j].equals("G")) {
                                result[a][b] = 2;
                                continue out;
                            }                            
                        }
                    }
                    
                }
                // 계산식
                int cnt = 0;
                for (int l=0;l<N;l++) {
                    if(land[a][l].equals("B")){
                        cnt++;
                    }
                    if(land[l][b].equals("B")){
                        cnt++; 
                    }
                    result[a][b] = cnt-1;
                }
                
                
            }
        }
        // 최대값 찾기
        int max = result[0][0];        
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N;j++) {
                if (result[i][j] > max) {
                    max = result[i][j];
                }
            }
        }
        
        System.out.println("#"+s+" "+max);
        }
    }
}
/*
G B G G B B
G B G G B G
B B B B G B
B G B B B B 
G B B B B G
G B B B B G
*/

/*
G B G G B
G B G G B
B B B B G
B G B B B
G B B B B
*/

/*
G G B
G B B
B B B
*/