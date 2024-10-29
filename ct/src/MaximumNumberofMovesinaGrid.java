public class MaximumNumberofMovesinaGrid {
    public int maxMoves(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        int answer = 0;
        for (int j = 1 ; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length; i++) {
                if( j == 1){
                    if(i == 0){
                        if(grid[i][j] > grid[i][j-1] || grid[i][j] > grid[i+1][j-1] ){
                            dp[i][j] = 1;
                            answer = j;
                        }

                    }else if(i == grid.length-1){
                        if(grid[i][j] > grid[i][j-1] || grid[i][j] > grid[i-1][j-1]){
                            dp[i][j] = 1;
                            answer = j;
                        }

                    }else{
                        if(grid[i][j] > grid[i][j-1] || grid[i][j] > grid[i+1][j-1] || grid[i][j] > grid[i-1][j-1]) {
                            dp[i][j] = 1;
                            answer = j;
                        }
                    }
                }else{
                    if(i == 0){
                        if( dp[i][j-1] == 1  || dp[i+1][j-1] == 1 ){
                            if((grid[i][j] > grid[i][j-1] && dp[i][j-1] == 1) || (grid[i][j] > grid[i+1][j-1]&& dp[i+1][j-1] == 1)){
                                dp[i][j] = 1;
                                answer = j;
                            }
                        }
                            continue;
                    }else if(i == grid.length-1){
                        if( dp[i][j-1] == 1  || dp[i-1][j-1] == 1){
                            if((grid[i][j] > grid[i][j-1]&& dp[i][j-1] == 1) || (grid[i][j] > grid[i-1][j-1]&& dp[i-1][j-1] == 1)){
                                dp[i][j] = 1;
                                answer = j;
                            }
                        }
                    }else{
                        if(dp[i][j-1] == 1  || dp[i+1][j-1] == 1 || dp[i-1][j-1] == 1) {
                            if ((grid[i][j] > grid[i][j - 1]&& dp[i][j-1] == 1) || (grid[i][j] > grid[i + 1][j - 1]&& dp[i+1][j-1] == 1) || (grid[i][j] > grid[i - 1][j - 1]&& dp[i-1][j-1] == 1)) {
                                dp[i][j] = 1;
                                answer = j;
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        MaximumNumberofMovesinaGrid grid = new MaximumNumberofMovesinaGrid();
        int i = grid.maxMoves(new int[][]{{187, 167, 209, 251, 152, 236, 263, 128, 135}, {267, 249, 251, 285, 73, 204, 70, 207, 74}, {189, 159, 235, 66, 84, 89, 153, 111, 189}, {120, 81, 210, 7, 2, 231, 92, 128, 218}, {193, 131, 244, 293, 284, 175, 226, 205, 245}});
        System.out.println("i = " + i);
    }
}
