import java.util.ArrayList;
import java.util.List;

public class DifferentBit {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int idx = 0;
        for(int i =0;i < numbers.length;i++) {
            if(numbers[i] % 2 == 0){// 짝수라면 가장마지막비트가 0 이므로 +1만 해준다
                answer[i] = numbers[i]+1;
            }else{//홀수라면 가장 마지막으로나오는 01을 10으로 바꿔준다
                long number = numbers[i];
                boolean flag = true;
                List<Long> bitArr = new ArrayList<>();//list에는 거꾸로들어가므로 가장먼저 들어가는 10을 찾아 값의 인덱스를 바꾼다
                while(number != 0){
                    bitArr.add(number%2);
                    if(bitArr.size()>=2){
                        if(flag && bitArr.get(bitArr.size()-2)==1 && bitArr.get(bitArr.size()-1)==0){
                            bitArr.set(bitArr.size()-2,0L);
                            bitArr.set(bitArr.size()-1,1L);
                            flag = false;
                        }
                    }
                    number = number / 2;
                }
                if(flag){
                    bitArr.set(bitArr.size()-1, 0L);
                    bitArr.add(1L);
                }
                long n=0;
                for(int j = 0;j < bitArr.size();j++){
                    if(bitArr.get(j) == 1)
                        n = (long) (n + Math.pow(2,j));
                }
                answer[i] = n;
            }
        }

        return answer;
    }

    public void sum(){
        int sum = 0;
        for(int i = 1 ;i<=100;i++){
            sum = sum + i;
        }
    }


}
