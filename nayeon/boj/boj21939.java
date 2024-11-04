import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    // 문제 정보를 저장하는 클래스 (문제 번호와 난이도)
    public static class Problem implements Comparable<Problem> {
        int number; // 문제 번호
        int level; // 문제 난이도

        // 생성자 -> 문제 번호와 난이도를 받아서 초기화
        public Problem(int problemId, int difficulty) {
            this.number = problemId;
            this.level = difficulty;
        }

        // 난이도가 같으면 문제 번호, 다르면 난이도 정렬
        @Override
        public int compareTo(Problem other) {
            if (this.level == other.level) {
                return Integer.compare(this.number, other.number);
            } else {
                return Integer.compare(this.level, other.level);
            }
        }
    } // Problem

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder result = new StringBuilder(); 

        int numCount = sc.nextInt(); // 처음 입력받을 문제의 개수

        TreeSet<Problem> problemsSet = new TreeSet<>(); // 문제를 저장하는 TreeSet (자동 정렬)
        HashMap<Integer, Integer> problemMap = new HashMap<>(); // 문제 번호와 난이도를 저장하는 HashMap

        // 초기 문제들을 입력받아 TreeSet과 HashMap에 저장
        for (int i = 0; i < numCount; i++) {
            int problemId = sc.nextInt(); // 문제 번호
            int difficulty = sc.nextInt(); // 문제 난이도
            problemsSet.add(new Problem(problemId, difficulty)); // TreeSet에 추가
            problemMap.put(problemId, difficulty); // HashMap에 추가
        }

        int strCount = sc.nextInt(); // 명령어의 개수

        // 명령어 처리
        for (int i = 0; i < strCount; i++) {
            String str = sc.next(); // 명령어 입력

            if (str.equals("recommend")) {
                int order = sc.nextInt(); // 추천할 문제의 기준 (1: 가장 어려운 문제, -1: 가장 쉬운 문제)
                if (order == 1) {
                    result.append(problemsSet.last().number).append("\n"); // 가장 어려운 문제 출력
                } else {
                    result.append(problemsSet.first().number).append("\n"); // 가장 쉬운 문제 출력
                }
            } else if (str.equals("add")) {
                int problemId = sc.nextInt(); // 추가할 문제 번호
                int difficulty = sc.nextInt(); // 추가할 문제 난이도

                problemsSet.add(new Problem(problemId, difficulty)); // 새로운 문제 추가
                problemMap.put(problemId, difficulty); // HashMap에 추가
            } else if (str.equals("solved")) {
                int problemId = sc.nextInt(); // 해결된 문제 번호
                int difficulty = problemMap.get(problemId); // 문제 번호로 난이도 가져오기

                problemsSet.remove(new Problem(problemId, difficulty)); // TreeSet에서 제거
                problemMap.remove(problemId); // HashMap에서 제거
            }
        }

        // 결과 출력
        System.out.println(result);

    } // main
} // class 
