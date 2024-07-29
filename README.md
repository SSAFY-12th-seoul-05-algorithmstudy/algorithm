![header]([https://capsule-render.vercel.app/api?type=waving&height=200&section=header&text=TODO%20App%20Project%203조&color=gradient](https://capsule-render.vercel.app/api?type=waving&height=300&color=gradient&text=SSAFY%2012th%20서울5반))

# 📖SSAFY_서울 5반 알고리즘 스터디

`SSAFY 12기_서울_5반` 을 위한 알고리즘 스터디입니다.

참여 희망자는 `@김지승[서울_5반]` 에게 MM 주시면 됩니다.
<br>



---

### Team Profile (추가예정?)

<br><br>



---

## 📜진행방식

### Git
0. 자리 옮긴 후, git 계정 설정 방법
    -   <sub style="color: rgba(0, 0, 0, 0.8); margin-left: 20px;"> 자격 증명 관리자 내 일반 자격 증명 모두 삭제</sub>
    -   <sub style="color: rgba(0, 0, 0, 0.8); margin-left: 20px;">바탕화면에서 git bash 실행</sub>
    -   <sub style="color: rgba(0, 0, 0, 0.8); margin-left: 20px;">git config --global user.email [본인 이메일]</sub> 
    -   <sub style="color: rgba(0, 0, 0, 0.8); margin-left: 20px;">설정 후, git config user.email로 이메일 잘 바뀌었는지 확인</sub>
    -   <sub style="color: rgba(0, 0, 0, 0.8); margin-left: 20px;">git config --global user.name [본인 닉네임]</sub>
    -   <sub style="color: rgba(0, 0, 0, 0.8); margin-left: 20px;">이후, 첫 push할 때, 로그인</sub>

1. git clone 레포지토리주소로 로컬에 복제
2. 해당 폴더에서 git bash 열고 branch 생성 후 이동 (git checkout -b 브랜치 이름)
    -   <sub style="color: rgba(0, 0, 0, 0.8); margin-left: 20px;"> 브랜치 생성 : git checkout -b kjs</sub>
    -   <sub style="color: rgba(0, 0, 0, 0.8); margin-left: 20px;"> 브랜치 이동 : git checkout main</sub>
3. 알고리즘문제 해결 후 작업 끝나면 add -> commit -> push (이 때, 브랜치 확인 필수)





상세설명 :
<br>
※ GIT 기초 ((https://vivacious-coyote-b68.notion.site/Git-c7bf18f26a7a489d837fe7d3ed0837b4))

1. [Eclipse로 시작하기 튜토리얼](.docs/GETTING_STARTED.md)


2. [IntelliJ로 시작하기 튜토리얼](.docs/GETTING_STARTED_intellJ.md)


3. [PR 가이드](.docs/PULL_REQUESTS_GUIDE.md)


4. [코드리뷰 가이드](.docs/CODE_REVIEW_GUIDE.md)


5. [본인 폴더만 Clone 하기](.docs/Only_My_Folder_Clone_Guide.md)


<br>

### 진행방식 (수정예정)

※ 참고 
바킹독 알고리즘 강의 (https://blog.encrypted.gg/category/%EA%B0%95%EC%A2%8C/%EC%8B%A4%EC%A0%84%20%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98?page=3)

바킹독 백준 문제 모음(https://www.acmicpc.net/workbook/by/BaaaaaaaaaaarkingDog)

1. 주 2회 진행하며, 하루는 강의듣고 발표 + 3문제 코드리뷰, 하루는 4문제 코드리뷰를 진행한다.

    -   <sub style="color: rgba(0, 0, 0, 0.8); margin-left: 20px;"> 매 주 마다 스터디 담당자를 선정하여 스터디 담당자는 발표와 문제공유를 담당한다.</sub>

2. 모임시간 전까지 문제를 풀고 PR한다. (3문제 / 4문제)

    -   <sub style="color: rgba(0, 0, 0, 0.8); margin-left: 20px;"> 풀지 못한 문제의 경우에도 시도한 코드를 PR 날린다.</sub>

3. 각자 푼 문제에 대한 간단한 리뷰를 진행한다.

4. 이후 페어와 코드를 리뷰한다.

    -   <sub style="color: #808080; margin-left: 20px;"> 많은 사람과의 코드 리뷰를 위해 페어는 매 주 변경된다.</sub>
    -   <sub style="color: #808080; margin-left: 20px;"> 코드 리뷰의 원활한 진행을 위해 언어는 `JAVA`를 사용한다.</sub>

5. PR 수정이 끝나고, 본인의 branch는 본인이 관리한다!
  
6. 남는 시간엔 페어와 협의 후 조별스터디를 진행한다.
<br>

※ 페어가 아닌 다른 사람의 코드리뷰를 받고 싶으면,  `Discussions` 를 이용하여 요청하거나, 개인 MM을 이용한다.

<br>
※ 문제해결에 도움되는 반례를 생성했거나 반례가 필요한 경우, `Discussions` 를 이용한다.

<br><br>




### 파일 생성 규칙

폴더 명 : "본인 영문 이름"
하위 폴더 명 : "Site 약자"
<br>
파일 명 : "Site 약자"  +  "문제번호" 

ex)
`jiseung/boj/boj1004.java` <br>
`jiseung/swea/swea1004.java`
<br><br>

### 커밋 규칙

- Commit subject : [태그] 문제번호 / 걸린시간(선택)

| 태그 | 설명 |
| --- | --- |
| [solved] | 해결 |
| [fix] | 수정 |
| [docs] | 문서 |
| [chore] | 빌드, 설정 파일 |

ex)

1. Commit subject : `[solved] boj28354 / 50분`
2. Commit subject : `[solved] boj28354`
3. Commit subject : `[fix] boj28354` 

<br><br>

### PR 규칙

PR Title : 이름 / 주차 / 요일

ex)  `김지승 / 8월 1주차 / 목`

PR Comment : 

(자유) , 문제를 풀면서 어려웠던 점이나 코드리뷰를 통해 알게된 점을 기록하면 좋을 것 같다.

<br>

### 스터디 규칙

- 본인의 실력이 부족함에 자책하지말고, 노력하기
- 상대방의 코드를 존중!!
- 의견제시
    - 잘했다고 생각하는 부분
    - 이렇게 하면 더 좋을 것 같다고 생각하는 부분
    - 왜 이렇게 풀었는지 궁금한 부분
    - 또 다른 풀이 방식 제시

<br>

### 📌스터디 목표

1. 다가오는 IM테스트에서 IM등급따고, A 혹은 A+ 노리기!!
2. 스터디원들과 함께 공부하며 성장하기!!
3. 5반 BOJ 그룹 (https://www.acmicpc.net/group/21409) 에 문제 올리기!


---

### 건의사항

`Discussions` 나 MM채널, 개인 MM을 이용한다.


---
