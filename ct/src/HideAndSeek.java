public class HideAndSeek {
    public static int solution(int finder,int target){
        if(finder >= target)
            return finder - target;
        int[] dp = new int[target+1];
        int start = finder;
        for(int i=start-1;i >= 0;i--){
            dp[i] = dp[i + 1] + 1;
        }
        for(int i=start+1;i < dp.length;i++){
            if(i % 2 == 1){
                dp[i] =  Math.min(Math.min(dp[i-1] + 1,dp[(i-1)/2]+2),dp[(i+1)/2]+2);
            }else{
                dp[i] = Math.min(dp[i/2] + 1,dp[i-1]+1);
            }
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        HideAndSeek h = new HideAndSeek();
        int solution = h.solution(100, 0);
        System.out.println("solution = " + solution);
    }
}
