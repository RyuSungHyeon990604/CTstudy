package LEETCODE.TrappingRainWaterII;

import java.util.PriorityQueue;

public class Solution {
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] vis = new boolean[m][n];
        //주위에 아무리 높은 칸이있더라고 물이 고이는 높이는 주변에서 가장 낮은 칸을 기준으로 고임
        //    100
        //  1  0  100
        //    100
        //일때 물이 고이는 높이는 1
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);//[row,col,h]
        for(int i=0;i<m;i++){
            pq.offer(new int[]{i,0,heightMap[i][0]});
            pq.offer(new int[]{i,n-1,heightMap[i][n-1]});
            vis[i][0] = true;
            vis[i][n-1] = true;
        }
        for(int i=1;i<n-1;i++){
            pq.offer(new int[]{0,i,heightMap[0][i]});
            pq.offer(new int[]{m-1,i,heightMap[m-1][i]});
            vis[0][i] = true;
            vis[m-1][i] = true;
        }
        int answer = 0;
        while(!pq.isEmpty()){
            int[] poll = pq.poll();
            int row = poll[0];
            int col = poll[1];
            int h = poll[2];
            for (int i = 0; i < 4; i++) {
                int newRow = row + dir[i][0];
                int newCol = col + dir[i][1];
                if(isValid(newRow,newCol,heightMap) && !vis[newRow][newCol]){
                    //다음칸의 높이가 현재보다 낮다며 차이만큼 +
                    if(heightMap[newRow][newCol] < h){
                        answer += h - heightMap[newRow][newCol];
                    }
                    vis[newRow][newCol] = true;
                    //칸을 이동하면서 가장높은 칸을 유지
                    pq.offer(new int[]{newRow,newCol,Math.max(heightMap[newRow][newCol],h)});
                }
            }
        }

        return answer;
    }
    public boolean isValid(int row, int col, int[][] heightMap) {
        return row >= 0 && col >= 0 && row < heightMap.length && col < heightMap[0].length;
    }

}
