import java.util.*;

public class CuttingRollCake {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        for (int i : topping){
            right.put(i,right.getOrDefault(i,0)+1);
        }
        for (int i : topping){
           right.put(i,right.getOrDefault(i,0)-1);
           if(right.get(i)==0){
               right.remove(i);
           }
           left.put(i,left.getOrDefault(i,0)+1);
           if(left.size()==right.size()){
               answer += 1;
           }
        }
        return answer;
    }


}
