import java.util.*;

public class CuttingRollCake {
    public int solution(int[] topping) {
        int answer = 0;

        int [] right = new int[10001];
        int [] left  = new int[10001];

        for (int i = 0; i < topping.length; i++) {
            right[topping[i]] += 1;
            if(right[topping[i]] == 1)
                right[0] +=1;
        }
        for (int i = 0 ; i <topping.length; i++) {

            right[topping[i]] -= 1;
            if (right[topping[i]] == 0){
                right[0] -= 1;
            }

            left[topping[i]] += 1;
            if(left[topping[i]] == 1)
                left[0] += 1;

            if(left[0] == right[0])
                answer++;
        }
        return answer;
    }


}
