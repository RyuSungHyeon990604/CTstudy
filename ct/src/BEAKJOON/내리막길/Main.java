package BEAKJOON.내리막길;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dirRow = {1,-1,0,0};
    static int[] dirCol = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        print(map,m,n);
    }
    public static void print(int[][] map,int m,int n) {
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        memo[m-1][n-1] = 1;
        dfs(map,memo,0,0);
        System.out.println(memo[0][0]);
    }
    public static void dfs(int[][] map,int[][] memo,int row,int col) {
        if(memo[row][col] != -1 || (row == map.length-1 && col == map[0].length-1)) return;

        memo[row][col] = 0;
        for(int i = 0; i < 4; i++) {
            int newRow = row + dirRow[i];
            int newCol = col + dirCol[i];
            if(newRow < 0 || newCol < 0 || newRow>= map.length || newCol >= map[0].length) continue;
            if(map[newRow][newCol] < map[row][col]){
                dfs(map,memo,newRow,newCol);
                memo[row][col] += memo[newRow][newCol];
            }

        }

    }
}
