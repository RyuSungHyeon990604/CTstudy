package LEETCODE.MinimumCosttoMakeatLeastOneValidPathinaGrid;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int minCost(int[][] grid) {
        int[] dirCol = {1,-1,0,0};
        int[] dirRow = {0,0,1,-1};
        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i],Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[2]-b[2]);
        pq.offer(new int[]{0,0,0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int row = cur[0];
            int col = cur[1];
            int cost = cur[2];
            if(row == m-1 && col == n-1)
                return cost;
            for (int i = 0 ; i < 4;i++){
                int nextCol = col + dirCol[i];
                int nextRow = row + dirRow[i];
                if(nextCol<0 || nextCol>= n || nextRow<0 || nextRow>=m) continue;
                int newCost = cost;
                if(i+1 != grid[row][col])
                    newCost++;
                if(memo[nextRow][nextCol] <= newCost) continue;
                memo[nextRow][nextCol] = newCost;
                pq.offer(new int[]{nextRow,nextCol,newCost});
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minCost(new int[][]{{1,2},{4,3}});
    }
}
