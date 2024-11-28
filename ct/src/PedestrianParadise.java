public class PedestrianParadise {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if(cityMap[i][0] == 1)
               break;
            dp[i][0] = 1;

        }
        for (int i = 1; i < n; i++) {
            if(cityMap[0][i] == 1)
                break;
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(cityMap[i][j] == 1) continue;
                if(cityMap[i-1][j] != 2 && cityMap[i][j-1] != 2){
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD;
                }else if(cityMap[i-1][j] == 2 && cityMap[i][j-1] == 2){
                    int y = j-1;
                    while(y>=0&&cityMap[i][y] == 2){
                        y--;
                    }
                    int x = i-1;
                    while(x>=0&&cityMap[x][j] == 2){
                        x--;
                    }
                    dp[i][j] = ((x<0 ? 0 : dp[x][j]) + (y<0 ? 0 : dp[i][y]))%MOD;
                }else if(cityMap[i-1][j] == 2 && cityMap[i][j-1] == 1){
                    int x = i-1;
                    while(x>=0&&cityMap[x][j] == 2){
                        x--;
                    }
                    dp[i][j] = (x<0 ? 0 : dp[x][j])%MOD;
                }else if(cityMap[i-1][j] == 1 && cityMap[i][j-1] == 2){
                    int y = j-1;
                    while(y>=0&&cityMap[i][y] == 2){
                        y--;
                    }
                    dp[i][j] += (y<0 ? 0 : dp[i][y])%MOD;
                }else if(cityMap[i-1][j] == 2 && cityMap[i][j-1] == 0){
                    int x = i-1;
                    while(x>=0&&cityMap[x][j] == 2){
                        x--;
                    }
                    dp[i][j] += ((x<0 ? 0 : dp[x][j])+dp[i][j-1])%MOD;
                }else if(cityMap[i-1][j] == 0 && cityMap[i][j-1] == 2){
                    int y = j-1;
                    while(y>=0&&cityMap[i][y] == 2){
                        y--;
                    }
                    dp[i][j] += ((y<0 ? 0 : dp[i][y])+dp[i-1][j])%MOD;
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        PedestrianParadise p = new PedestrianParadise();
        int solution = p.solution(2, 2, new int[][]{{0,0},{0,0} });
        System.out.println("solution = " + solution);
    }
}
