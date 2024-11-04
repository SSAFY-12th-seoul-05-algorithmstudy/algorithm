import java.util.*;
import java.lang.*;
import java.io.*;

public class Main { 
    public static void main(String[] args) {
        // input
        Scanner sc = new Scanner(System.in);

        int peopleNum = sc.nextInt(); // 총 사람 수
        int partyNum = sc.nextInt();  // 총 파티 수

        int knowingPeopleNum = sc.nextInt(); // 진실을 아는 사람의 수

        // 진실을 아는 사람이 아무도 없으면, 모든 파티에서 비밀 유지 가능
        if(knowingPeopleNum == 0){
            System.out.println(partyNum);
            return;
        }

        // 진실을 아는 사람들의 리스트
        List<Integer> knowingPeople = new ArrayList<>();
        for(int i = 0; i < knowingPeopleNum; i++){
            knowingPeople.add(sc.nextInt());
        }

        // 파티 리스트 -> 각 파티는 참석자의 리스트로 구성
        List<List<Integer>> partyGraph = new ArrayList<>();
        for(int i = 0; i < partyNum; i++){
            int num = sc.nextInt(); // 현재 파티에 참석하는 사람 수
            List<Integer> row = new ArrayList<>();
            
            for(int j = 0; j < num; j++){
                row.add(sc.nextInt());
            }

            partyGraph.add(row);
        }
        // 입력 완료

        int idx = 0;
        
        // 알고 있는 사람 리스트가 업데이트되는 동안 반복
        while(knowingPeople.size() > idx && partyGraph.size() != 0){
            int nowKnowingPerson = knowingPeople.get(idx); // 현재 알고 있는 사람
            int size = partyGraph.size();

            // 파티 리스트를 순회하면서 진실을 아는 사람이 포함된 파티를 찾음
            for(Iterator<List<Integer>> pgItr = partyGraph.iterator(); pgItr.hasNext();){
                List<Integer> nowParty = pgItr.next();
                // 현재 파티에 진실을 아는 사람이 있으면
                if(nowParty.contains(nowKnowingPerson)){
                    pgItr.remove(); // 비밀이 밝혀질 수 있는 파티는 제거
                    
                    // 파티의 모든 참석자를 순회하여 진실을 아는 사람 리스트에 추가
                    Iterator<Integer> npItr = nowParty.iterator();
                    while(npItr.hasNext()){
                        int element = npItr.next();
                        
                        // 아직 진실을 모르는 사람만 리스트에 추가
                        if(!knowingPeople.contains(element)) 
                            knowingPeople.add(element);
                    }
                }
            }
            idx++;
        }

        System.out.println(partyGraph.size());
    } // main
} // class

