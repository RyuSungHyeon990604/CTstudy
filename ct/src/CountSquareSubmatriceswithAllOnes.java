public class CountSquareSubmatriceswithAllOnes {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int ans = 0;

        // dp[i][j]는 해당 점을 가장우측아래로하는 정사각형의 개수이다
        //matrix = [
        //[1, 1, 1, 0],
        //[1, 1, 1, 1],
        //[1, 1, 1, 1],
        //[0, 1, 1, 1]
        //] 일때

        // dp = [
        //[1, 1, 1, 0],
        //[1, 0, 0, 0],
        //[1, 0, 0, 0],
        //[0, 0, 0, 0]
        //] 이렇게 초기화된다
        for (int i = 0; i < rows; i++) {
            dp[i][0] = matrix[i][0];
            ans += dp[i][0];
        }
        for (int j = 1; j < cols; j++) {
            dp[0][j] = matrix[0][j];
            ans += dp[0][j];
        }


        // dp = [             matrix = [
        //[1, 1, 1, 0],                [1, 1, 1, 0],
        //[1, *, *, *],                [1, 1, 1, 1],
        //[1, *, *, *],                [1, 1, 1, 1],
        //[0, *, *, *]                 [0, 1, 1, 1]
        //]  * 부분으로 부터 matrix[i][j] == 1 일때 dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1 점화식 적용
        //
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    //점화식
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    ans += dp[i][j];
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        CountSquareSubmatriceswithAllOnes cs = new CountSquareSubmatriceswithAllOnes();
        cs.countSquares(new int[][]{{0,1,1,1},{1,1,1,1},{0,1,1,1}});
    }
}
