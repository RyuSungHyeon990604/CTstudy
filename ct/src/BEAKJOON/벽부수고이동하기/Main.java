package BEAKJOON.벽부수고이동하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dirRow= {-1, 0, 1, 0};
    static int[] dirCol= {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            char[] c = new StringTokenizer(br.readLine()).nextToken().toCharArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = c[j] - '0';
            }
        }

        bfs(map,m,n);
    }
    public static void bfs(int[][] map,int m,int n) {
        Queue<int[]> q = new LinkedList<>();//[row,col,cnt]
        int[][][] vis = new int[m][n][2];
        int min = Integer.MAX_VALUE;
        vis[0][0][1] = 1;
        vis[0][0][0] = 1;
        q.offer(new int[]{0,0,0,1});
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int row = cur[0], col = cur[1] ,cnt = cur[2],step = cur[3];
                if(row == m-1 && col == n-1){
                    min = Math.min(min,step);
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    int nr = row + dirRow[k];
                    int nc = col + dirCol[k];
                    if(nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
                    if(map[nr][nc] == 0){
                        if(vis[nr][nc][cnt] == 0){
                            vis[nr][nc][cnt] = 1;
                            q.offer(new int[]{nr,nc,cnt,step+1});
                        }
                    }else{
                        if(cnt == 0){
                            if(vis[nr][nc][1] == 0){
                                vis[nr][nc][1] = 1;
                                q.offer(new int[]{nr,nc,1,step+1});
                            }
                        }
                    }
                }
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

}