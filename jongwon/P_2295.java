import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        HashSet<Integer> hashSet = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < n ; j++){
                hashSet.add(arr[i] + arr[j]);
            }
        }

        int max = -1;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(hashSet.contains(arr[i] - arr[j])){
                    max = Math.max(arr[i],max);
                }
            }
        }

        System.out.println(max);


    }
}