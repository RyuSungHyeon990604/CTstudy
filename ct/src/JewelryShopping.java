import java.util.*;

public class JewelryShopping {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        int answerStart =0 , answerEnd =  gems.length ;
        int n = set.size();
        //"A", "B", "B", "B", "B", "B", "B", "C", "B", "A"
        while (end < gems.length) {
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
            if(map.size() == n){
                while(true) {
                    if(answerEnd - answerStart > end -start) {
                        answerEnd = end;
                        answerStart = start;
                    }
                    if(end - start + 1 == n) {
                        return new int[]{answerStart+1, answerEnd+1};
                    }
                    map.put(gems[start], map.get(gems[start]) - 1);
                    if(map.get(gems[start]) == 0) {
                        map.remove(gems[start]);
                        start++;
                        break;
                    }
                    start++;
                }
            }
            end++;
        }

        return new int[]{answerStart+1, answerEnd+1};
    }

    public static void main(String[] args) {
        JewelryShopping jewelryShopping = new JewelryShopping();
        jewelryShopping.solution(new String[]{"A", "B", "B", "B", "B", "B", "B", "C", "B", "A"});
    }
}
