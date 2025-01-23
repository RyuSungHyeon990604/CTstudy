package LEETCODE.CountServersthatCommunicate;

public class Solution {
    public int countServers(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (row[i] > 1 || col[j] > 1)) {
                    res++;
                }
            }
        }
        return res;
    }





    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.countServers(new int[][]{{0,0,1,0,1},{0,1,0,1,0},{0,1,1,1,0},{1,0,0,1,1},{0,0,1,1,0}});
    }
}
