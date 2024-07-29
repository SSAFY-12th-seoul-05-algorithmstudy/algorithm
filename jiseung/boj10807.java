import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();	// 첫번째 변수 : 배열의 길이 = N
        int[] arr = new int[N];	// 배열 생성, 길이는 N만큼

        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();			 // 두번째 변수 : 입력한 정수들 배열에 넣어주기
        }
        int v = sc.nextInt();				 // 세번째 변수 : v가 몇개인지
        
        int count = 0;	// count = 0부터 시작
        for(int j = 0; j < arr.length; j++){ // 배열 길이만큼 반복문 돌리면서 v 와 같은 숫자 찾기.
            if(v == arr[j]){
                count++;	// 같으면 count 변수 1씩 증가
            }
        }
        System.out.println(count);
    }
}
