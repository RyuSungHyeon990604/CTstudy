import java.util.*;

public class MinimumObstacleRemovaltoReachCorner {
    public int minimumObstacles(int[][] grid) {
        return bfsWithDeque(grid);
    }
    public int bfs(int[][] grid){
        int[] dirX = {1,-1,0,0};
        int[] dirY = {0,0,1,-1};
        int m = grid.length;
        int n = grid[0].length;
        int[][] obstacles = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                obstacles[i][j] = m*n;
            }
        }
        Queue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[2] - o2[2]);
        pq.offer(new int[]{0,0,0});
        obstacles[0][0] = 0;
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
                    if(obstacles[nx][ny] > remv+grid[nx][ny]){
                        obstacles[nx][ny] = remv+grid[nx][ny];
                        pq.offer(new int[]{nx, ny, remv + grid[nx][ny]});
                    }
                }
            }
        }
        return obstacles[m-1][n-1];
    }

    public int bfsWithDeque(int[][] grid){
        int[] dirX = {1,-1,0,0};
        int[] dirY = {0,0,1,-1};
        int m = grid.length;
        int n = grid[0].length;
        int[][] obstacles = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                obstacles[i][j] = m*n;
            }
        }
        Deque<int[]> dq = new ArrayDeque<>();
        dq.addLast(new int[]{0,0,0});
        obstacles[0][0] = 0;
        while(!dq.isEmpty()){
            int size = dq.size();
            for(int i = 0; i < size; i++){
                int[] poll = dq.pollFirst();
                int x = poll[0];
                int y = poll[1];
                int remv = poll[2];
                for(int j = 0; j < 4; j++){
                    int nx = x + dirX[j];
                    int ny = y + dirY[j];
                    if(nx > m-1 || ny > n-1 || nx < 0 || ny < 0) continue;
                    if(grid[nx][ny] == 1 && obstacles[nx][ny] > remv+grid[nx][ny]){
                        obstacles[nx][ny] = remv+grid[nx][ny];
                        dq.addLast(new int[]{nx, ny, remv + grid[nx][ny]});
                    }
                    if(grid[nx][ny] == 0 && obstacles[nx][ny] > remv+grid[nx][ny]){
                        obstacles[nx][ny] = remv+grid[nx][ny];
                        dq.addFirst(new int[]{nx, ny, remv + grid[nx][ny]});
                    }
                }
            }
        }
        return obstacles[m-1][n-1];
    }
    public static void main(String[] args) {
        MinimumObstacleRemovaltoReachCorner m = new MinimumObstacleRemovaltoReachCorner();
        int i = m.minimumObstacles(new int[][]{{0, 1, 0, 0, 0}, {0, 1, 0, 1, 0}, {0, 0, 0, 1, 0}});
        System.out.println("i = " + i);
    }
}
