import java.util.*;

import java.util.*;

public class CandidateKey {
    int answer = 0;
    List<Integer> keySet = new ArrayList<>(); // 후보키 집합

    public int solution(String[][] relation) {
        int rowCount = relation.length;
        int colCount = relation[0].length;

        // 1. 모든 칼럼 조합에 대한 비트마스크 부분집합 생성
        for (int subset = 1; subset < (1 << colCount); subset++) {
            // 2. 현재 조합이 후보키인지 검사
            if (isUnique(relation, rowCount, colCount, subset)) {
                boolean isMinimal = true;
                // 3. 최소성 검사 (이미 등록된 후보키와 비교)
                for (int key : keySet) {
                    if ((key & subset) == key) {// key가 subset의 부분집합인가?
                        //key가 subset의 부분집합인가?
                        // key가 subset의 부분집합인가?
                        // key가 subset의 부분집합인가?
                        // key가 subset의 부분집합인가? 중요
                        isMinimal = false;
                        break;
                    }
                }
                // 4. 최소성을 만족하면 후보키로 등록
                if (isMinimal) {
                    keySet.add(subset);
                    answer++;
                }
            }
        }
        return answer;
    }

    // 각 조합이 유일성을 만족하는지 확인
    private boolean isUnique(String[][] relation, int rowCount, int colCount, int subset) {
        Set<String> seen = new HashSet<>(); // 중복 검사에 사용

        // 각 row를 순회하며, subset 조합에 해당하는 컬럼 값을 하나의 문자열로 결합
        for (int i = 0; i < rowCount; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < colCount; j++) {
                if ((subset & (1 << j)) != 0) { // subset에 해당하는 컬럼만 추가
                    sb.append(relation[i][j]).append(",");
                }
            }
            // 이미 존재하는 조합이면 유일성 실패
            if (!seen.add(sb.toString())) {
                return false;
            }
        }
        return true; // 유일성을 만족함
    }

    public void p(){
        int[] a = {1,2,3};
        int n = a.length;

        for (int i = 1; i < (1 << n); i++) {
            // 각 부분집합 출력
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {//1 << j ==> 이진수로 나타냈을때 j번째가 1인 수이다 j = 0 / 1 << j = 1,j = 1 / 1 << j = 10
                    //따라서 i=5라면 101이라면
                    //1 << j 가 100 일때 그리고 1일때
                    //즉 j =0 , j = 2일때이다
                    System.out.print(a[j] + " ");
                }
            }
            System.out.println(); // 한 부분집합이 끝날 때 줄바꿈
        }
    }

    public static void main(String[] args) {
        CandidateKey candidateKey = new CandidateKey();
        System.out.println(candidateKey.solution(new String[][]{
                {"100", "ryan", "music", "2"},
                {"200", "apeach", "math", "2"},
                {"300", "tube", "computer", "3"},
                {"400", "con", "computer", "4"},
                {"500", "muzi", "music", "3"},
                {"600", "apeach", "music", "2"}
        })); // 출력: 2


    }
}

