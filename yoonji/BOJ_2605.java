package IM_Practice;

import java.util.Scanner;

class Student{
	int seqNum; // 순서 정하는 번호
	int studentId; // 학생 번호
	
	public Student(int seqNum, int studentId) {
		super();
		this.seqNum = seqNum;
		this.studentId = studentId;
	}
	
	
}
public class BOJ_2605 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt(); // 학생 수
		Student[] line = new Student[N]; // 줄 서는 배열
		
		for(int i=0; i<N; i++) {
			line[i] = new Student(sc.nextInt(), i+1);
		}
		
		// line 배열에는 (0,1) (1,2), (1,3), (3,4), (2,5) 저장
		
		for(int i=1; i<N; i++) { // 1번 학생은 그자리 그대로 이므로)
			Student s = line[i]; // 해당 학생 저장
			int idx = i - line[i].seqNum; // 현재 배열 index - 그 학생이 뽑은 순번 = 그 학생이 가야하는 idx
			for(int j=i; j>idx; j--) { // 역방향 순회하면서 빈자리 땡겨준다
				Student tmp = line[j-1];
				line[j] = tmp;
			}
			line[idx] = s; // 마지막에 해당 학생이 서야하는 자리에 넣어준다
		}
		
		for(int i=0; i<N; i++) {
			System.out.printf("%d ",line[i].studentId);
		}
		
	} //main
}
