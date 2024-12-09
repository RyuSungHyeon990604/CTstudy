import java.util.*;

public class EvaluationDepartment {
    public int solution(int[][] scores) {
        if (scores.length == 1)
            return 1;
        int[] target = scores[0];
        Arrays.sort(scores, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1]; //중요
                return o2[0] - o1[0];
            }
        });

        //동일한 점수를 카운팅하기위한 + 특정점수 보다 큰 값을 구하기위해 정렬될 필요가있음 ==> TreeMap 사용
        TreeMap<Integer, Integer> map = new TreeMap<>();//[score,count]
        for (int i = 0; i < scores.length; i++) {
            map.put(scores[i][0] + scores[i][1], map.getOrDefault(scores[i][0] + scores[i][1], 0) + 1);
        }

        //정렬된 결과로 scores[i][0] 은 scores[i-1][0]보다 항상 크거나같다
        //동일한 scores[i][0] 에서는 scores가 동일하지않은 이상 반드시 max값이 갱신된다.
        //즉, 인사고과를 받지못하는경우는 다음 scores[i][0]으로 넘어가고 max값을 갱신할수없는경우.
        //즉  scores[i][1] < max 일때 인사고과를 받지못하게된다.
        //때문에 정렬에서     if (o1[0] == o2[0])
        //                    return o1[1] - o2[1]; 조건이 필요하다.
        int max = scores[0][1];
        for (int i = 0; i < scores.length; i++) {
            if (scores[i][1] < max) {
                if (scores[i][0] == target[0] && scores[i][1] == target[1]) {
                    return -1;
                } else {
                    if (map.get(scores[i][1] + scores[i][0]) - 1 == 0) {
                        map.remove(scores[i][1] + scores[i][0]);
                    } else map.put(scores[i][1] + scores[i][0], map.get(scores[i][1] + scores[i][0]) - 1);
                }
            }
            max = Math.max(max, scores[i][1]);
        }
        int count = 0;
        int t = target[0] + target[1];
        Map.Entry<Integer, Integer> integerIntegerEntry = map.higherEntry(t);
        while (integerIntegerEntry != null) {
            t = integerIntegerEntry.getKey();
            count += integerIntegerEntry.getValue();
            integerIntegerEntry = map.higherEntry(t);
        }

        return count + 1;
    }

    public static void main(String[] args) {
        EvaluationDepartment e = new EvaluationDepartment();
        int solution = e.solution(new int[][]{{2, 2}, {1, 4}, {3, 2}, {3, 2}, {2, 1}});
        System.out.println("solution = " + solution);
    }
}
