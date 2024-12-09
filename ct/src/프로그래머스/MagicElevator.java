public class MagicElevator {
    public int solution(int storey) {
        int answer = 0;
        int newint = storey;


        while((newint / 10) > 0){///2554
            int n = newint % 10; //4
            if(n < 5){ // 내림
                answer += n;
                newint -= n;
            }else if(n == 5){
                if(newint / 10 % 10 >= 5){
                    answer += n;
                    newint += n;
                }else{
                    answer += n;
                    newint -= n;
                }
            }else{//올림
                answer += 10 - n;
                newint += 10 - n;
            }
            newint = newint / 10;
        }
        if(newint > 5){
            answer += 10 - newint + 1;
        }else{
            answer += newint;
        }
        return answer;
    }
}
