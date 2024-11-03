public class WayToSchool {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[m+1][n+1];
        int limit = 1_000_000_007;
        for (int[] puddle : puddles) {
            dp[puddle[0]][puddle[1]] = -1;
        }
        for (int i = 1; i <= m; i++) {
            if(dp[i][1] == -1) continue;
            if (dp[i-1][1] == -1) {
                dp[i][1] = -1;
            }else
                dp[i][1] = 1;
        }
        for (int i = 1; i <= n; i++) {
            if(dp[1][i] == -1) continue;
            if (dp[1][i-1] == -1) {
                dp[1][i] = -1;
            }else
                dp[1][i] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                if (dp[i][j] == -1) continue;
                if( dp[i][j-1] == -1 && dp[i-1][j] == -1){
                    dp[i][j] = -1;
                }else if(dp[i][j-1] == -1){
                    dp[i][j] = dp[i-1][j];
                }else if(dp[i-1][j] == -1){
                    dp[i][j] = dp[i][j-1];
                }else
                    dp[i][j] = (dp[i][j-1] + dp[i-1][j])%limit;
            }
        }

        return dp[m][n] == -1 ? 0 : dp[m][n];
    }


    public static void main(String[] args) {
        WayToSchool wayToSchool = new WayToSchool();
        int solution = wayToSchool.solution(1, 3, new int[][]{{2, 1}});
        System.out.println("solution = " + solution);
    }
}
