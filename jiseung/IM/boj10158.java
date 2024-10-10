import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st1.nextToken());
		int h = Integer.parseInt(st1.nextToken());
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st2.nextToken());
		int q = Integer.parseInt(st2.nextToken());
		
		int T = Integer.parseInt(br.readLine());
		
		int T1 = T-(w-p);
		int T2 = T-(h-q);
		
		if(T1>=0) {
			if((T1/w)%2 == 0) p = w-(T1%w);
			else p = T1%w;
		} else p = p+T;
		
		if(T2>=0) {
			if((T2/h)%2 == 0) q = h-(T2%h);
			else q = T2%h;
		} else q = q+T;

		System.out.println(p + " " + q);
	}
}