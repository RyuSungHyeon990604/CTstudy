import java.util.Set;
import java.util.HashSet;

public class ExpressAsN {
    public int solution(int N, int number) {
        if(N == number)
            return 1;

        //사용하기 편하게
        //dp[i] : i개로 만들어낼수있는 정수들의 집합
        Set[] dp = new Set[9];

        //5,55,555 같은 숫자들은 각각의 자릿수가 최소이므로 미리 넣어준다.
        int repeatNum = N;
        for (int i = 0; i < 9; i++) {
            if(i>0){
                dp[i] = new HashSet<Integer>();
                dp[i].add(repeatNum);
                if(repeatNum == number)
                    return i;
                repeatNum = repeatNum*10+N;
            }
        }
        dp[2].add(N+N);
        dp[2].add(N*N);
        dp[2].add(0);
        dp[2].add(1);
        //dp[1] , dp[2] 는 고정이므로 3부터 시작
        for (int targetCount = 3; targetCount <= 8; targetCount++) {
            //targetSet : 다음으로 만들어야하는 집합
            //dp[n] = (dp[1],dp[n-1]) U (dp[2],dp[n-2]) U (dp[k],dp[n-k]) U ... U (dp[n-1],dp[1])
            Set<Integer> targetSet = dp[targetCount];
            for (int left = 1 ; left < targetCount; left++) {
               int right = targetCount - left ;
               Set<Integer> leftSet= dp[left];
               Set<Integer> rightSet= dp[right];
               for (int leftN : leftSet){
                   for (int rightN : rightSet){
                       if(leftN+rightN == number)//조기종료
                           return targetCount;
                       targetSet.add(leftN+rightN);
                       if(leftN-rightN == number)
                           return targetCount;
                       targetSet.add(leftN-rightN);
                       if(leftN*rightN == number)
                           return targetCount;
                       targetSet.add(leftN*rightN);
                       if(rightN != 0){
                           if(leftN/rightN == number)
                               return targetCount;
                           targetSet.add(leftN/rightN);
                       }

                   }
               }
            }
        }
        //8개 초과로 만들수있는 숫자이므로 -1 반환
        return -1;

    }
    public static void main(String[] args) {
        ExpressAsN expressAsN = new ExpressAsN();
        int solution = expressAsN.solution(8, 53);
        System.out.println("solution = " + solution);
    }

}
