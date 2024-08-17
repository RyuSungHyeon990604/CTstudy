import java.util.Arrays;

public class MoreSpicy {
        public int solution(int[] scoville, int K) {
            int answer = scoville(scoville, K, 0);;
            return answer;
        }

        public boolean isUp(int[] scoville, int K) {
            for(int s : scoville){
                if(s < K){
                    return false;
                }
            }
            return true;
        }

        public int scoville(int[] scoville, int K,int depth) {
            if(isUp(scoville, K)){
                return depth;
            }else{
                if(scoville.length == 1){
                    return -1;
                }
                Arrays.sort(scoville);
                scoville[1] = scoville[0] + scoville[1]*2;
                scoville = Arrays.copyOfRange(scoville, 1, scoville.length);
                return scoville(scoville, K,depth+1);
            }
        }
}
