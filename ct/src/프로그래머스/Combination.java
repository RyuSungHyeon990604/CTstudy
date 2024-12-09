import java.util.ArrayList;
import java.util.List;

public class Combination {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];

        List<Integer> arr= new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }


        long answerNum, other=0;
        int index = 0;
        while(index <= n){
            //n = 3 k = 5  5/(3-1)! = 2
            answerNum = k/getFactorial(n-1-index); // 2
            other = k%getFactorial(n-1-index); // 1


            if(other == 0){
                answer[index++] = arr.get((int)answerNum -1);
                arr.remove((int) answerNum -1);
                while(arr.size() > 0){
                    answer[index++] = arr.get(arr.size()-1);
                    arr.remove(arr.size()-1);
                }
                break;
            }else{
                answer[index] = arr.get((int)answerNum);
                arr.remove((int) answerNum);
            }
            k = other;
            index++;
        }


        return answer;
    }

    public long getFactorial(int n){
        long r = 1;
        for (int i = 1; i <= n ; i++) {
            r *= i;
        }
        return r;
    }

}
