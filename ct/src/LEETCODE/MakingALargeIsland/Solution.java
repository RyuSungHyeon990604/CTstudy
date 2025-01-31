package LEETCODE.MakingALargeIsland;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int largestIsland(int[][] grid) {
        int[] parent = new int[grid.length*grid[0].length];
        int[] island = new int[grid.length*grid[0].length];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < grid.length*grid[0].length; i++) {
            parent[i] = i;
        }
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int colSize = grid[0].length;
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    dfs(grid, i, j,vis,convert(colSize,i,j),parent,island);
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) continue;
                int sum = 0;
                set.add(convert(colSize,i,j));
                for (int k = 0; k < 4; k++) {
                    int x = i + dirs[k][0];
                    int y = j + dirs[k][1];
                    if(x >= 0 && y>=0 && x < grid.length && y < grid[0].length && grid[x][y] == 1) {
                        set.add(parent[convert(colSize,x,y)]);
                    }
                }
                for(int k : set){
                    sum+=island[k];
                }
                max = Math.max(max,sum+1);
                set.clear();
            }
        }

        return max == 0 ? grid.length * grid[0].length : max;
    }
    public int convert(int colSize , int row ,int col){
        return colSize * row + col;
    }
    public void dfs(int[][] grid, int row, int col,boolean[][] vis,int root,int[] parent,int[] island) {
        vis[row][col] = true;
        parent[convert(grid[0].length,row,col)] = root;
        island[root]++;
        for (int i = 0; i < 4; i++) {
            int x = row + dirs[i][0];
            int y = col + dirs[i][1];
            if(x >= 0 && y>= 0 && x < grid.length && y < grid[0].length && !vis[x][y] && grid[x][y] == 1) {
                vis[x][y] = true;
                dfs(grid,x,y,vis,root,parent,island);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.largestIsland(new int[][]{{1, 1, 0, 1, 1, 1, 0}, {0, 1, 1, 1, 1, 0, 1}, {1, 1, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 1}, {1, 0, 0, 1, 1, 0, 1}, {0, 1, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 0, 0, 1}});
    }
}
