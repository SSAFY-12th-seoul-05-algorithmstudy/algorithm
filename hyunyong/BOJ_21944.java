import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class BOJ_21944 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		TreeSet<int[]>[] set = new TreeSet[101];
		
		for(int i=0 ; i<101 ; i++) {
			set[i] = new TreeSet<>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[1]==o2[1]) return o2[0]-o1[0];
					return o2[1]-o1[1];
				}
			});
		}
		
		HashMap<Integer, int[]> map = new HashMap<>();
		
		int N = sc.nextInt();
		
		for(int i=0 ; i<N ; i++) {
			int P = sc.nextInt();
			int L = sc.nextInt();
			int G = sc.nextInt();
			
			set[0].add(new int[] {P,L});
			set[G].add(new int[] {P,L});
			map.put(P, new int[] {L,G});
		}
		
		
		int M = sc.nextInt();
		
		for(int i=0 ; i<M ; i++) {
			String comment = sc.next();
			int G = 0;
			int x = 0;
			int L = 0;
			int P = 0;
			switch(comment) {
			case "recommend":
				G = sc.nextInt();
				x = sc.nextInt();
				
				if(x==1) {
					System.out.println(set[G].first()[0]);
				} else {
					System.out.println(set[G].last()[0]);
				}
				break;
			case "recommend2":
				x = sc.nextInt();
				if(x==1) {
					System.out.println(set[0].first()[0]);
				} else {
					System.out.println(set[0].last()[0]);
				}
				break;
			case "recommend3":
				x = sc.nextInt();
				L = sc.nextInt();
				if(x==1) {
					int[] tmp = set[0].lower(new int[] {0,L});
					if(tmp==null) {
						System.out.println(-1);
					} else {
						System.out.println(tmp[0]);
					}
				} else {
					int[] tmp = set[0].ceiling(new int[] {0,L});
					if(tmp==null) {
						System.out.println(-1);
					} else {
						System.out.println(tmp[0]);
					}
				}
				break;
			case "add":
				P = sc.nextInt();
				L = sc.nextInt();
				G = sc.nextInt();
				if(map.containsKey(P)) {
					int[] tmp = map.get(P);
					set[0].remove(new int[] {P,tmp[0]});
					set[tmp[1]].remove(new int[] {P,tmp[0]});
					map.remove(P);
				}
				set[0].add(new int[] {P,L});
				set[G].add(new int[] {P,L});
				map.put(P, new int[] {L,G});
				break;
			case "solved":
				P = sc.nextInt();
				int[] tmp = map.get(P);
				
				set[0].remove(new int[] {P,tmp[0]});
				set[tmp[1]].remove(new int[] {P,tmp[0]});
				map.remove(P);
				break;
			}
		}
	}
}
