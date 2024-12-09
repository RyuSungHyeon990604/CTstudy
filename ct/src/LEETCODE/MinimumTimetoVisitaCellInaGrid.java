import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumTimetoVisitaCellInaGrid {
    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) return -1;
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        int[] dirX = {1, -1, 0, 0};
        int[] dirY = {0, 0, 1, -1};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        //Queue<int[]> pq = new LinkedList<>();
        pq.offer(new int[]{0, 0, 0});//[x,y,sec]
        visited[0][0] = 1;
        while (!pq.isEmpty()) {
            int size = pq.size();
            for (int s = 0; s < size; s++) {
                int[] poll = pq.poll();
                int x = poll[0], y = poll[1], sec = poll[2];
                if (x == m - 1 && y == n - 1) {
                    return poll[2];
                }
                for (int i = 0; i < 4; i++) {
                    int nx = x + dirX[i];
                    int ny = y + dirY[i];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                    if (visited[nx][ny] == 0) {
                        if (grid[nx][ny] <= sec + 1) {
                            visited[nx][ny] = 1;
                            pq.offer(new int[]{nx, ny, sec + 1});
                            continue;
                        }
                        if (grid[nx][ny] > sec + 1) {
                            int t = 0;
                            if ((grid[nx][ny] - (sec + 1)) % 2 == 1) {
                                t = grid[nx][ny] + 1;
                            } else {
                                t = grid[nx][ny];
                            }
                            visited[nx][ny] = 1;
                            pq.offer(new int[]{nx, ny, t});
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumTimetoVisitaCellInaGrid grid = new MinimumTimetoVisitaCellInaGrid();
        int i = grid.minimumTime(new int[][]{{0, 1, 3, 2}, {5, 1, 2, 5}, {4, 3, 8, 6}});
        System.out.println("i = " + i);
    }
}
