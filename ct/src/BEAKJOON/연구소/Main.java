package BEAKJOON.연구소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; st.hasMoreElements(); j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(maxAreaOfSafe(map, m, n));
    }
    public static int maxAreaOfSafe(int[][] map,int m,int n) {
        List<int[]> empty = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[j][i] == 0) {
                    empty.add(new int[]{j,i});
                }
            }
        }
        comb(map,empty,0,0);
        return max;
    }
    public static void comb(int[][] map,List<int[]> empty,int start,int count){
        if(count == 3){
            max = Math.max(max,bfs(map));
            return;
        }
        for (int i = start; i < empty.size(); i++) {
            map[empty.get(i)[0]][empty.get(i)[1]] = 1;
            comb(map,empty,i+1,count+1);
            map[empty.get(i)[0]][empty.get(i)[1]] = 0;
        }
    }
    // 0: 빈칸, 1 :벽  2:바이러스
    public static int bfs(int[][] map){

        int[] dirX = {-1,1,0,0};
        int[] dirY = {0,0,-1,1};

        Queue<int[]> q = new LinkedList<>();
        int m = map.length;
        int n = map[0].length;
        int[][] vis = new int[m][n];
        int safe = 0;

        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(map[i][j]==0){
                    safe++;
                }
                if(map[i][j]==2){
                    q.offer(new int[]{i,j});
                    vis[i][j]=1;
                }
            }
        }

        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] poll = q.poll();
                int row = poll[0] , col = poll[1];
                for(int j=0;j<4;j++){
                    int nr= row+dirX[j];
                    int nc= col+dirY[j];
                    if(nr < 0 || nc < 0 || nr >= m || nc >= n){
                        continue;
                    }
                    if(map[nr][nc]==0 && vis[nr][nc]==0){
                        vis[nr][nc]=1;
                        q.offer(new int[]{nr,nc});
                        safe--;
                        if(safe < max){
                            return safe;
                        }
                    }
                }
            }
        }

        return safe;
    }
}