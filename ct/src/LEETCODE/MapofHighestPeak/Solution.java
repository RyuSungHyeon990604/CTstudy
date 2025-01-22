package LEETCODE.MapofHighestPeak;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        Queue<int[]> pq = new LinkedList<>();//[row,col,h]
        int[][] height = new int[isWater.length][isWater[0].length];
        for (int i = 0 ; i < isWater.length ;i++){
            for (int  j =0 ; j < isWater[0].length; j++){
                if(isWater[i][j] == 1){
                    pq.offer(new int[]{i,j,0});
                    height[i][j] = 0;
                }else height[i][j] = -1;
            }
        }
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int row = cur[0];
            int col = cur[1];
            int h = cur[2];
            for (int i = 0 ; i < 4 ; i++){
                int nextR = row + dir[i][0];
                int nextC = col + dir[i][1];
                int nextH = h+1;
                if(nextR >= 0 && nextR < isWater.length && nextC>=0 && nextC < isWater[0].length){
                    if(height[nextR][nextC] == -1){
                        height[nextR][nextC] = nextH;
                        pq.offer(new int[]{nextR,nextC,nextH});
                    }
                }
            }
        }
        return height;
    }
}
