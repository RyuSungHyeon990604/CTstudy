public class EasyStairNumber {
    public long solution(int N) {
        long[][] dp = new long[N+1][10];
        dp[1] =new long[]{0,1,1,1,1,1,1,1,1,1} ;
        for (int i = 2; i <= N; i++) {
            long [] t= dp[i-1] ;
            for (int j = 0; j < 10; j++) {
                if(j==0) dp[i][1]=(dp[i][1]+t[j])%1_000_000_000;
                else if(j < 9){
                    dp[i][j+1] =(dp[i][j+1]+t[j])%1_000_000_000;
                    dp[i][j-1] =(dp[i][j-1]+t[j])%1_000_000_000;
                }else dp[i][8]=(dp[i][8]+t[j])%1_000_000_000;
            }
        }
        long count = 0;
        for (int i = 0; i < 10; i++) {
            count = (count + dp[N][i])%1_000_000_000 ;
        }
        return count;
    }

    public static void main(String[] args) {
        EasyStairNumber asd= new EasyStairNumber();
        long solution = asd.solution(33);
        System.out.println(solution);
    }
}
