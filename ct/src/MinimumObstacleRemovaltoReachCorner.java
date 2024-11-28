import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumObstacleRemovaltoReachCorner {
    public int minimumObstacles(int[][] grid) {
        return bfs(grid);
    }
    public int bfs(int[][] grid){
        int[] dirX = {1,-1,0,0};
        int[] dirY = {0,0,1,-1};
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                vis[i][j] = m*n;
            }
        }
        Queue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[2] - o2[2]);
        pq.offer(new int[]{0,0,0});
        vis[0][0] = 0;
        while(!pq.isEmpty()){
            int size = pq.size();
            for(int i = 0; i < size; i++){
                int[] poll = pq.poll();
                int x = poll[0];
                int y = poll[1];
                int remv = poll[2];
                for(int j = 0; j < 4; j++){
                    int nx = x + dirX[j];
                    int ny = y + dirY[j];
                    if(nx > m-1 || ny > n-1 || nx < 0 || ny < 0) continue;
                    if(grid[nx][ny]==1 && vis[nx][ny] > remv+1){
                        vis[nx][ny] = remv+1;
                        pq.offer(new int[]{nx, ny, remv + 1});
                    }
                    if(grid[nx][ny]==0 && vis[nx][ny] > remv){
                        vis[nx][ny] = remv;
                        pq.offer(new int[]{nx, ny, remv});
                    }
                }
            }
        }
        return vis[m-1][n-1];
    }
    public static void main(String[] args) {
        MinimumObstacleRemovaltoReachCorner m = new MinimumObstacleRemovaltoReachCorner();
        int i = m.minimumObstacles(new int[][]{{0, 1, 0, 0, 0}, {0, 1, 0, 1, 0}, {0, 0, 0, 1, 0}});
        System.out.println("i = " + i);
    }
}
