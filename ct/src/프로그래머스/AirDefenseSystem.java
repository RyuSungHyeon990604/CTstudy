import java.util.*;

public class AirDefenseSystem {
    public int solution(int[][] targets) {
       int answer = 1;//  정수 쌍 (s, e) 이 0 ≤ s < e ≤ 100,000,000 이므로 반드시 1발은 발사한다.
       Arrays.sort(targets,new Comparator<int[]>() { // 끝점을 기준으로 정렬
           public int compare(int[] o1, int[] o2) {
               return o1[1] - o2[1];
           }
       });
       int pre = targets[0][1];
       for (int i = 0; i < targets.length; i++) {
           if (pre <= targets[i][0]) {// 현재의 범위가 이전과 겹치는지 비교
               answer++; // 겹치지 않는다면  +1
               pre = targets[i][1];
           }
       }
        return answer;
    }



    public static void main(String[] args) {
        AirDefenseSystem airDefenseSystem = new AirDefenseSystem();
        int[][] targets = new int[][]{{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};

        airDefenseSystem.solution(targets);
    }
}
