package BEAKJOON.알파벳;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int max = 1;
    static int[] dirX = {1,-1,0,0};
    static int[] dirY = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        char[][] map = new char[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        print(map);

    }
    public static void print(char[][] map){
        int[] vis =new int[26];
        vis[map[0][0]-'A']=1;
        dfs(map,0,0,1,vis);
        System.out.println(max);
    }
    public static void dfs(char[][] map, int row, int col,int cnt,int[] vis){
        for(int i = 0;i<4;i++){
            int nr = row + dirX[i];
            int nc = col + dirY[i];
            if(nr < 0 || nr >= map.length || nc < 0 || nc >= map[0].length) continue;
            int index = map[nr][nc] - 'A';
            if(vis[index] == 0){
                vis[index] = 1;
                dfs(map,nr,nc,cnt+1,vis);
                vis[index] = 0;
            }else{
                max = Math.max(max,cnt);
            }
        }
    }
}
