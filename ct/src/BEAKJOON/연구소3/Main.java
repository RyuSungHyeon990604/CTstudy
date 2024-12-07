package BEAKJOON.연구소3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; st.hasMoreElements(); j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(getMin(map, n, m));
    }
    public static int getMin(int[][] map,int n,int m) {
        List<int[]> virus = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[j][i] == 2) {
                    virus.add(new int[]{j,i});
                }
            }
        }
        comb(map,virus,0, m);
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    public static void comb(int[][] map,List<int[]> virus,int start,int count){
        if(count == 0){
            min = Math.min(min,bfs(map));
            return;
        }
        for (int i = start; i < virus.size(); i++) {
            map[virus.get(i)[0]][virus.get(i)[1]] = 3;
            comb(map,virus,i+1,count-1);
            map[virus.get(i)[0]][virus.get(i)[1]] = 2;
        }
    }
    // 0: 빈칸, 1 :벽  2: 비활성 바이러스 3:활성 바이러스
    public static int bfs(int[][] map){

        int[] dirX = {-1,1,0,0};
        int[] dirY = {0,0,-1,1};

        Queue<int[]> q = new LinkedList<>();
        int n = map.length;
        int[][] vis = new int[n][n];
        int safe = 0;

        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if(map[i][j]==0){
                    safe++;
                }
                if(map[i][j]==3){
                    q.offer(new int[]{i,j});
                    vis[i][j]=1;
                }
            }
        }
        if(safe == 0) return 0;
        int time = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] poll = q.poll();
                int row = poll[0] , col = poll[1];
                for(int j=0;j<4;j++){
                    int nr= row+dirX[j];
                    int nc= col+dirY[j];
                    if(nr < 0 || nc < 0 || nr >= n || nc >= n){
                        continue;
                    }
                    if(map[nr][nc] != 1 && vis[nr][nc]==0){
                        vis[nr][nc]=1;
                        q.offer(new int[]{nr,nc});
                        if(map[nr][nc] == 0)
                            safe--;
                        if(safe == 0)
                            return time;
                    }
                }
            }
            time++;
        }

        return Integer.MAX_VALUE;
    }
}
