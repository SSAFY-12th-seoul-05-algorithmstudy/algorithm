import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st1 = new StringTokenizer(br.readLine());

		int width = Integer.parseInt(st1.nextToken());
		int height = Integer.parseInt(st1.nextToken());

		int T = Integer.parseInt(br.readLine()); // 상점의 갯수
		int[][] store = new int[T][2];
		for (int i = 0; i < T; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			store[i][0] = Integer.parseInt(st2.nextToken()); // 상점 방향
			store[i][1] = Integer.parseInt(st2.nextToken()); // 상점 위치
		}
		StringTokenizer st3 = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st3.nextToken()); // 동근이 방향
		int b = Integer.parseInt(st3.nextToken()); // 동근이 위치
		
		int result = 0;
		for(int i=0; i<T;i++) {
			int length = 0;
			if(a==1) {
				if(store[i][0]==1){
					length+=Math.abs(store[i][1]-b);
				}
				else if(store[i][0]==2) {
					length+=height+Math.min(store[i][1]+b,2*width - (store[i][1]+b));
				}
				else if(store[i][0]==3){
					length+=store[i][1]+b;
				}
				else {
					length+=store[i][1]+(width-b);
				}
			}
			else if(a==2){
				if(store[i][0]==1) {
					length+=height+Math.min(store[i][1]+b,2*width-(store[i][1]+b));
				}
				else if(store[i][0]==2){
					length+=Math.abs(store[i][1]-b);
				}
				else if(store[i][0]==3) {
					length+=(height-store[i][1])+b;
				}
				else {
					length+=(height-store[i][1])+(width-b);
				}
			}
			else if(a==3) {
				if(store[i][0]==1) {
					length+=store[i][1]+b;
				}
				else if(store[i][0]==2){
					length+=(height-b)+store[i][1];
				}
				else if(store[i][0]==3) {
					length+=Math.abs(store[i][1]-b);
				}
				else {
					length+=width+Math.min(store[i][1]+b,2*height-(store[i][1]+b));
				}
			}
			else {
				if(store[i][0]==1) {
					length+=(width-store[i][1])+b;
				}
				else if(store[i][0]==2){
					length+=(height-b)+(width-store[i][1]);
				}
				else if(store[i][0]==3) {
					length+=width+Math.min(b+store[i][1],2*height-(b+store[i][1]));
				}
				else {
					length+=Math.abs(store[i][1]-b);
				}
			}
			result+=length;
		}
		System.out.println(result);
	}
}