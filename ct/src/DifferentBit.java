import java.util.ArrayList;
import java.util.List;

public class DifferentBit {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i =0;i < numbers.length;i++) {
            if(numbers[i] % 2 == 0){
                answer[i] = numbers[i]+1;
            }else{
                long t = numbers[i];
                int bit = 1;
                while (t != 0){
                    if((t&1) != 1){
                        break;
                    }
                    t = t >> 1;
                    bit++;
                }
                answer[i] = numbers[i] + (1L<<(bit-1)) - (1L<<(bit-2));
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        DifferentBit differentBit =new DifferentBit();
        differentBit.solution(new long[]{5,127});
    }

}
