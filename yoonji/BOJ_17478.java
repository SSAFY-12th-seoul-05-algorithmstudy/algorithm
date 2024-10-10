import java.util.Scanner;

public class BOJ_17478 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		System.out.println("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.");
		responseBot(n);
		
	}
	
	static String s = "____";
	static int count = 0;
	
	static void responseBot(int n) {
		
		if(n == 0) {
			System.out.println(s.repeat(count)+"\"����Լ��� ������?\"");
			System.out.println(s.repeat(count)+"\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"");
			System.out.println(s.repeat(count)+"��� �亯�Ͽ���.");
			return;
		}
		
		System.out.println(s.repeat(count)+"\"����Լ��� ������?\"");
		System.out.println(s.repeat(count)+"\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.");
		System.out.println(s.repeat(count)+"���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.");
		System.out.println(s.repeat(count)+"���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"");
		
		count++;
		responseBot(n-1);
		
		System.out.println(s.repeat(--count)+"��� �亯�Ͽ���.");
		
	}
}
