import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class BOJ_21939 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		TreeSet<int[]> set = new TreeSet<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) return o2[0]-o1[0];
				return o2[1]-o1[1];
			}
		});
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i=0 ; i<N ; i++) {
			
			int P = sc.nextInt();
			int L = sc.nextInt();
			set.add(new int[] {P,L});
			map.put(P, L);
		}
		
		int M = sc.nextInt();
		sc.nextLine();
		for(int i=0 ; i<M ; i++) {
			String[] comment = sc.nextLine().split(" ");
			switch(comment[0]) {
			case "add":
				set.add(new int[] {Integer.parseInt(comment[1]),Integer.parseInt(comment[2])});
				map.put(Integer.parseInt(comment[1]),Integer.parseInt(comment[2]));
				break;
			case "solved":
				int L = map.get(Integer.parseInt(comment[1]));
				set.remove(new int[] {Integer.parseInt(comment[1]),L});
				map.remove(Integer.parseInt(comment[1]));
				break;
			case "recommend":
				if(comment[1].equals("1")) {
					System.out.println(set.first()[0]);
				} else {
					System.out.println(set.last()[0]);
				}
				break;
			}
		}
	}
}
