package LEETCODE.FirstCompletelyPaintedRoworColumn;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int[] rowCnt = new int[mat.length];
        int[] colCnt = new int[mat[0].length];
        int[][] map = new int[arr.length+1][];//[num,{row,col}]
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                map[mat[i][j]] = new int[]{i,j};
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int[] ints = map[arr[i]];
            int row = ints[0];
            int col = ints[1];
            rowCnt[row]++;
            colCnt[col]++;
            if (rowCnt[row] == mat[0].length || colCnt[col] == mat.length) {
                return i;
            }
        }
        return arr.length-1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.firstCompleteIndex(new int[]{1,3,4,2},new int[][]{{1,4},{2,3}});
    }
}
