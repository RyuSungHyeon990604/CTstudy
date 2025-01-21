package LEETCODE.GridGame;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public long gridGame(int[][] grid) {
        long[] prefix = new long[grid[0].length];
        long[] suffix = new long[grid[0].length];
        prefix[0] = grid[0][0];
        suffix[grid[0].length-1] = grid[1][grid[0].length-1];
        for (int i = 1; i < grid[0].length; i++) {
            prefix[i] = prefix[i-1] + grid[0][i];
        }
        for (int i = grid[0].length-2; i >= 0; i--) {
            suffix[i] = suffix[i+1] + grid[1][i];
        }
        long robot2Max = Long.MAX_VALUE;
        for (int i = 0; i < grid[0].length; i++) {
            robot2Max =Math.min(robot2Max, Math.max(prefix[grid[0].length-1]-prefix[i],suffix[0]-suffix[i]));
        }



        return robot2Max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.gridGame(new int[][]{{1,3,1,15},{1,3,3,1}});
    }
}
