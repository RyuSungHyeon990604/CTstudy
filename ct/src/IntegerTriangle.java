public class IntegerTriangle {
    public int solution(int[][] triangle) {
        int answer = Integer.MIN_VALUE;
        int[][] dp = new int[triangle.length][];
        for (int i = 0; i < triangle.length; i++) {
            dp[i] = new int[triangle[i].length];
        }
        dp[0][0] = triangle[0][0];
        for (int row = 1; row < triangle.length; row++) {
            for (int col = 0; col < triangle[row].length; col++) {
                if(col == 0){
                    dp[row][col] = dp[row-1][col] + triangle[row][col];
                }else if(col == triangle[row].length-1){
                    dp[row][col] = dp[row-1][col-1] + triangle[row][col];
                }else
                    dp[row][col] = Math.max(triangle[row][col]+dp[row-1][col], triangle[row][col]+dp[row-1][col-1]);
            }
        }
        for (int value : dp[triangle.length-1]) {
            answer = Math.max(answer, value);
        }
        return answer;
    }


    public static void main(String[] args) {
        IntegerTriangle triangle = new IntegerTriangle();
        int[][] triangle1 = new int[][] {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        triangle.solution(triangle1);
    }
}
