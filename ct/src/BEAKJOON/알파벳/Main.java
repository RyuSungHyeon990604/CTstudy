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
        dfs(map,0,0,1,1<<map[0][0]-'A');
        System.out.println(max);
    }
    public static void dfs(char[][] map, int row, int col,int cnt,int bit){
        for(int i = 0;i<4;i++){
            int nr = row + dirX[i];
            int nc = col + dirY[i];
            if(nr < 0 || nr >= map.length || nc < 0 || nc >= map[0].length) continue;
            if((1<<map[nr][nc] - 'A' & bit) > 0){
                max= Math.max(max,cnt);
            }else{
                dfs(map,nr,nc,cnt+1,bit|(1<<map[nr][nc] - 'A'));
            }
        }
    }
}
